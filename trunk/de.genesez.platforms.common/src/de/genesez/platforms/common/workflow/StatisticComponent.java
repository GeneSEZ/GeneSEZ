package de.genesez.platforms.common.workflow;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.xtend.type.impl.java.JavaMetaModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;

import de.genesez.platforms.common.statistic.StatisticObserver;
import de.genesez.platforms.common.statistic.StatisticsSet;
import de.genesez.platforms.common.workflow.feature.FileTreeWalkerFeature;

/**
 * Generates a statistic html-site for the given StatisticObserver.
 * 
 * @author Dominik Wetzel
 * @date 2011-11-15
 */
public class StatisticComponent extends CompositeComponent {

	/**
	 * Log instance for this class.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	private StatisticObserver statisticObserver = null;

	private DirectoryCleaner cleaner = new DirectoryCleaner();
	private Copier copier = new Copier();
	private Generator generator = new Generator();

	private Path defaultSource = null;
	private FileTreeWalkerFeature ftw = new FileTreeWalkerFeature();
	private String toCheck = null;

	private Properties properties = new Properties();

	private static final Properties defaults = new Properties();
	static {
		defaults.put("template",
				"de::genesez::platforms::common::statistic::Evaluation::Root");
		defaults.put("slot", "statisticModel");
		defaults.put("source", "../html_template");
		defaults.put("withDetails", "false");
	}

	/**
	 * Constructor for the StatistikGenerator. Configures the generator and the
	 * copier.
	 */
	public StatisticComponent() {
		super(StatisticComponent.class.getSimpleName());
		properties.putAll(defaults);

		cleaner.setUseDefaultExcludes(false);

		try {
			defaultSource = Paths.get(getClass().getProtectionDomain()
					.getCodeSource().getLocation().toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		generator.addMetaModel(new JavaMetaModel());
		generator.setTemplate(properties.getProperty("template"));
		generator.setSlot(properties.getProperty("slot"));

		if (defaultSource != null) {
			copier.setSource(defaultSource.resolve(
					properties.getProperty("source")).toString());
		}

		super.addComponent(cleaner);
		super.addComponent(copier);
		super.addComponent(generator);
	}

	/**
	 * checks the configuration of the component
	 */
	@Override
	public void checkConfiguration(Issues issues) {
		if (properties.getProperty("outputDir") == null) {
			issues.addError(this,
					"No outputDir given, cannot generate statistics");
		} else {
			if (statisticObserver == null) {
				issues.addInfo(
						this,
						"Missing property statisticObserver, standard will be used",
						statisticObserver);
				statisticObserver = new StatisticObserver();
			}
			statisticObserver.setProperties(properties);
			if (toCheck == null) {
				toCheck = Paths.get(properties.getProperty("outputDir")).toAbsolutePath()
						.getParent().toString();
			}
			ftw.setSearchedDir(toCheck);
			ftw.addObserver(statisticObserver);
			generator.addPreFeature(ftw);
			super.checkConfiguration(issues);
		}
	}

	/**
	 * Generates two pie charts for the overall statistics.
	 * @param issues from {@link #invoke(WorkflowContext, ProgressMonitor, Issues)}
	 */
	private void generatePieCharts(Issues issues) {
		try {
			Path dir = Files.createDirectories(Paths.get(
					properties.getProperty("outputDir"), "charts"));
			StatisticsSet statSet = statisticObserver.getRootDir().getStatSet();
			
			// the dataset for the pie charts 
			DefaultPieDataset dataset = new DefaultPieDataset();
			
			// fills the dataset for first pie chart
			dataset.setValue("impl. Code", statSet.getLinesOfOwnCode());
			dataset.setValue("gen. Code", statSet.getLinesOfGenCode());
			generatePieChart(dataset, "gen_imp.png", dir, issues);
			
			// adds information for the second pie chart
			dataset.setValue("docu", statSet.getLinesOfDocu());
			dataset.setValue("comments", statSet.getLinesOfComments()
					+ statSet.getLinesOfProtRegs());
			generatePieChart(dataset, "all.png", dir, issues);
		} catch (IOException e) {
			issues.addWarning(this, "Charts couldn't be generated.");
		}

	}

	/**
	 * generates a pie chart and saves it as png file.
	 * 
	 * @param dataset the set which contains the information for the chart
	 * @param name the filename of the generated chart
	 * @param dir the directory where the chart will be stored
	 * @param issues the issues from {@link #generatePieCharts(Issues)}
	 * @throws IOException If IO-Error occurs.
	 */
	private void generatePieChart(DefaultPieDataset dataset, String name,
			Path dir, Issues issues) throws IOException {
		
		// creates a 3D pie chart and sets the border invisible 
		JFreeChart chart = ChartFactory.createPieChart3D("", dataset, false,
				true, false);
		chart.setBorderVisible(false);
		
		// gets the plot from the chart
		PiePlot plot = ((PiePlot) chart.getPlot());
		
		// configuration of the labels in the charts
		plot.setLabelBackgroundPaint(Color.WHITE);
		plot.setLabelFont(new Font(Font.SANS_SERIF, Font.PLAIN, 11));
		plot.setLabelOutlinePaint(Color.WHITE);
		plot.setLabelShadowPaint(Color.WHITE);
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}\n{2}"));
		plot.setLabelPaint(Color.GRAY);
		
		// configuration of the plot in itself to look nicer
		plot.setInsets(new RectangleInsets(0.0,0.0,1.0,1.0));
		plot.setBackgroundPaint(Color.WHITE);
		plot.setOutlineVisible(false);
		plot.setForegroundAlpha((float) 0.7);
		
		// saves the chart as an png file
		ChartUtilities.saveChartAsPNG(dir.resolve(name).toFile(), chart, 380,
				120);
	}

	/**
	 * invokes the component and its subcomponents
	 */
	@Override
	public void invoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		if (statisticObserver.getPrepared()) {
			ftw.unregisterObserver(statisticObserver);
		}
		ctx.set(properties.getProperty("slot"), statisticObserver);
		super.invoke(ctx, monitor, issues);
		generatePieCharts(issues);
	}

	/**
	 * Sets the StatisticFeature that contains all statistic information. It is
	 * like the model of the statistics.
	 * 
	 * @param feature
	 *            the feature that contains the information
	 */
	public void setStatisticObserver(StatisticObserver feature) {
		this.statisticObserver = feature;
	}

	/**
	 * Sets the directory were the statistics will be generated in
	 * 
	 * @param dir
	 *            the path to the output directory
	 */
	public void setOutputDir(String dir) {
		properties.setProperty("outputDir", dir);
		generator.setOutputDir(dir);
		cleaner.setDirectory(dir);
		copier.setDestination(dir);
	}

	/**
	 * Sets the directory which should be checked
	 * 
	 * @param dir
	 *            the directory to check
	 */
	public void setDirToCheck(String dir) {
		toCheck = dir;
	}

	/**
	 * Sets the template for the generator.
	 * 
	 * @See de.genesez.platforms.common.workflow.Generator#setTemplate(String)
	 * @param template
	 *            the template for the generation
	 */
	public void setTemplate(String template) {
		properties.setProperty("template", template);
		generator.setTemplate(template);
	}

	/**
	 * Sets the directory of the YAML template
	 * 
	 * @param templateDir
	 *            the directory of the YAML-template
	 */
	public void setHtmlTemplateDirectory(String templateDir) {
		properties.setProperty("source", templateDir);
		copier.setSource(templateDir);
	}
	
	/**
	 * Sets whether details should be generated or not
	 * @param details if true details will be generated
	 */
	public void setWithDetails(String details) {
		properties.put("withDetails", details);
	}
}

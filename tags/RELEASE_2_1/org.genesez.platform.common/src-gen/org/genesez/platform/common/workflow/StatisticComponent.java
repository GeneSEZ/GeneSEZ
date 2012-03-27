package org.genesez.platform.common.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1321346476896_817371_2401) 
 */

import org.genesez.platform.common.statistic.StatisticsSet;
import org.genesez.platform.common.statistic.StatisticObserver;
import org.jfree.chart.ChartFactory;
import java.nio.file.Paths;
import org.genesez.platform.common.FileTreeObserverAdapter;
import java.util.Properties;
import java.awt.Color;
import org.jfree.chart.JFreeChart;
import java.net.URL;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.core.WorkflowContext;
import java.nio.file.Path;
import java.nio.file.Files;
import org.eclipse.xtend.type.impl.java.JavaMetaModel;
import org.jfree.chart.ChartUtilities;
import org.jfree.ui.RectangleInsets;
import java.io.File;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.jfree.data.general.DefaultPieDataset;
import org.genesez.platform.common.revisioncontrol.RevisionControlSystem;
import org.jfree.chart.plot.PiePlot3D;
import org.genesez.platform.common.FileSystemHelper;
import java.io.IOException;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.genesez.platform.common.revisioncontrol.RegisterHelper;
import java.awt.Font;
import org.jfree.data.general.PieDataset;
import java.util.Set;
import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.genesez.platform.common.workflow.feature.FileTreeWalkerFeature;
import java.net.URI;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.eclipse.emf.mwe.core.container.CompositeComponent;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class StatisticComponent extends CompositeComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** Stores the associated object of association STATISTICOBSERVER to StatisticObserver */
	private StatisticObserver statisticObserver;
	
	private static final String IMPL_CODE_LABEL = "impl. Code";
	
	private static final String GEN_CODE_LABEL = "gen. Code";
	
	private static final String DOCU_LABEL = "docu";
	
	private static final String COMMENT_LABEL = "comments";
	
	private static Properties defaults = new Properties();
	
	/**
	 * The Log instance of this class.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	private DirectoryCleaner cleaner;
	
	private Copier copier;
	
	private Generator generator;
	
	private Path defaultSource;
	
	private FileTreeWalkerFeature ftw;
	
	private String dirToCheck;
	
	private Properties properties = new Properties();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor. Configures the DirectoryCleaner, the Generator and the Copier and adds everything to the superclass. Prepares also the default path to the html_template directory.
	 */
	public StatisticComponent() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1321347033009_319721_2490) ENABLED START */
		super(StatisticComponent.class.getSimpleName());
		
		// initialization
		copier = new Copier();
		generator = new Generator();
		cleaner = new DirectoryCleaner();
		ftw = new FileTreeWalkerFeature();
		
		properties.putAll(defaults);
		
		cleaner.setUseDefaultExcludes(false);
		
		try {
			// obtain location of class file; note: could be a directory or a jar file!
			URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
			logger.debug("location: " + url);
			// either the directory or the jar file are in the same folder which contains the default template
			URI dir = new File(url.getPath()).getParentFile().toURI();
			defaultSource = Paths.get(dir);
			logger.debug("path: " + defaultSource);
		} catch (Exception e) {
			logger.error("could not obtain default source for statistic html template", e);
		}
		
		generator.addMetaModel(new JavaMetaModel());
		generator.setTemplate(properties.getProperty("template"));
		generator.setSlot(properties.getProperty("slot"));
		
		if (defaultSource != null) {
			copier.setSource(defaultSource.resolve(properties.getProperty("source")).toString());
		}
		
		super.addComponent(cleaner);
		super.addComponent(copier);
		super.addComponent(generator);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Checks the configuration of the component. And sets a default statisticObserver if none set.
	 * @param	issues	the issues.
	 */
	
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321347254248_662123_2493) ENABLED START */
		if (properties.getProperty("outputDir") == null) {
			issues.addError(this, "No outputDir given, cannot generate statistics");
		} else {
			if (statisticObserver == null) {
				issues.addInfo(this, "Missing property statisticObserver, standard will be used", statisticObserver);
				statisticObserver = new StatisticObserver();
			}
			statisticObserver.setProperties(properties);
			if (dirToCheck == null) {
				dirToCheck = Paths.get(properties.getProperty("outputDir")).toAbsolutePath().getParent().toString();
			}
			ftw.setSearchedDir(dirToCheck);
			ftw.addObserver(statisticObserver);
			
			// workaround for statistic SVN Problem, it deletes all .svn folders
			// after copying
			// It alternates also all permission of the .svn folders for
			// deletion
			FileTreeWalkerFeature workaround = new FileTreeWalkerFeature();
			workaround.setSearchedDir(properties.getProperty("outputDir"));
			workaround.addObserver(new FileTreeObserverAdapter() {
				
				private boolean toDelete = false;
				private Set<RevisionControlSystem> rcs = RegisterHelper.getAvailableImpls();
				
				/**
				 * deletes the file if in a metadatafolder
				 */
				@Override
				public void updateFileVisit(Path file) {
					if (toDelete) {
						try {
							FileSystemHelper.alterPermission(file);
							Files.delete(file);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
				/**
				 * checks if directory is a metadatafolder
				 */
				@Override
				public void updateBeforeDir(Path dir) {
					for (RevisionControlSystem system : rcs) {
						if (dir.endsWith(system.getMetadataFolderName())) {
							toDelete = true;
							return;
						}
					}
					if (dir.endsWith(".cvs")) {
						toDelete = true;
					}
				}
				
				/**
				 * Deletes a directory if its (in) a metadatafolder
				 */
				@Override
				public void updateAfterDir(Path dir) {
					if (toDelete) {
						try {
							FileSystemHelper.alterPermission(dir);
							Files.delete(dir);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					for (RevisionControlSystem system : rcs) {
						if (dir.endsWith(system.getMetadataFolderName())) {
							toDelete = false;
							return;
						}
					}
					if (dir.endsWith(".cvs")) {
						toDelete = false;
					}
				}
			});
			generator.addPreFeature(workaround);
			
			generator.addPreFeature(ftw);
			super.checkConfiguration(issues);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invokes the component and its subcomponent.
	 * @param	ctx	
	 * @param	monitor	
	 * @param	issues	
	 */
	
	public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321347353744_117417_2498) ENABLED START */
		if (statisticObserver.getPrepared()) {
			ftw.unregisterObserver(statisticObserver);
		}
		ctx.set(properties.getProperty("slot"), statisticObserver);
		super.invoke(ctx, monitor, issues);
		generatePieCharts(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * generates two pie charts for the overview page and saves it into outputDir/charts.
	 * @param	issues	the issues from {@link #invoke(WorkflowContext, ProgressMonitor, Issues)}
	 */
	
	private void generatePieCharts(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1323875448044_297639_1655) ENABLED START */
		try {
			Path dir = Files.createDirectories(Paths.get(properties.getProperty("outputDir"), "charts"));
			StatisticsSet statSet = statisticObserver.getRootDir().getStatSet();
			
			// the dataset for the pie charts 
			DefaultPieDataset dataset = new DefaultPieDataset();
			
			// fills the dataset for first pie chart
			dataset.setValue(IMPL_CODE_LABEL, statSet.getLinesOfOwnCode());
			dataset.setValue(GEN_CODE_LABEL, statSet.getLinesOfGenCode());
			generatePieChart(dataset, "gen_imp.png", dir, issues);
			
			// adds information for the second pie chart
			dataset.setValue(DOCU_LABEL, statSet.getLinesOfDocu());
			dataset.setValue(COMMENT_LABEL, statSet.getLinesOfComments() + statSet.getLinesOfProtRegs());
			generatePieChart(dataset, "all.png", dir, issues);
		} catch (IOException e) {
			issues.addWarning(this, "Charts couldn't be generated.");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * generates a pie chart and saves it as png file.
	 * @throws IOException if IO-Error occurs.
	 * @param	dataset	the set which contains the information for the chart
	 * @param	name	the filename of the generated chart
	 * @param	dir	the directory where the chart will be stored
	 * @param	issues	the issues from {@link #generatePieCharts(Issues)}
	 * @throws	IOException
	 */
	
	private void generatePieChart(PieDataset dataset, String name, Path dir, Issues issues) throws IOException {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1323875608701_996432_1680) ENABLED START */
		
		// creates a 3D pie chart and sets the border invisible 
		JFreeChart chart = ChartFactory.createPieChart3D("", dataset, false, false, false);
		
		// gets the plot from the chart
		PiePlot3D plot = ((PiePlot3D) chart.getPlot());
		
		// configuration of the labels in the charts
		plot.setLabelBackgroundPaint(Color.WHITE);
		plot.setLabelFont(new Font(Font.SANS_SERIF, Font.PLAIN, 11));
		plot.setLabelOutlinePaint(Color.WHITE);
		plot.setLabelShadowPaint(Color.WHITE);
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}\n{2}"));
		plot.setLabelPaint(Color.GRAY);
		
		plot.setSectionOutlinesVisible(false);
		plot.setSectionPaint(IMPL_CODE_LABEL, new Color(238, 64, 0));
		plot.setSectionPaint(GEN_CODE_LABEL, new Color(0, 238, 0));
		plot.setSectionPaint(DOCU_LABEL, Color.ORANGE);
		plot.setSectionPaint(COMMENT_LABEL, new Color(58, 95, 205));
		
		// configuration of the plot in itself to look nicer
		plot.setInsets(new RectangleInsets(0.0, 0.0, 1.0, 1.0));
		plot.setBackgroundPaint(Color.WHITE);
		plot.setOutlineVisible(false);
		plot.setForegroundAlpha((float) 0.7);
		
		// saves the chart as an png file
		ChartUtilities.saveChartAsPNG(dir.resolve(name).toFile(), chart, 380, 120);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets the directory were the statistics will be generated in. Be careful this will be cleaned before generation (that means all files in it will be deleted).
	 * @param	dir	the path to the output directory
	 */
	
	public void setOutputDir(String dir) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321347485545_459542_2501) ENABLED START */
		properties.setProperty("outputDir", dir);
		generator.setOutputDir(dir);
		cleaner.setDirectory(dir);
		copier.setDestination(dir);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets the template for the generator.
	 * @See de.genesez.platform.common.workflow.Generator#setTemplate(String)
	 * @param	template	the template for the generation
	 */
	
	public void setTemplate(String template) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321347701383_715764_2506) ENABLED START */
		properties.setProperty("template", template);
		generator.setTemplate(template);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets the directory of the YAML template.
	 * @param	templateDir	the directory of the YAML-template
	 */
	
	public void setHtmlTemplateDirectory(String templateDir) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321347772118_819220_2511) ENABLED START */
		properties.setProperty("source", templateDir);
		copier.setSource(templateDir);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Indicates whether details page should be generated or not.
	 * @param	withDetails	true if details page should be generated
	 */
	
	public void setWithDetails(boolean withDetails) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1323875343102_557159_1648) ENABLED START */
		properties.put("withDetails", Boolean.toString(withDetails));
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Sets the value of attribute '<em><b>dirToCheck</b></em>'
	 */
	public void setDirToCheck(String dirToCheck) {
		this.dirToCheck = dirToCheck;
	}
	
	/**
	 * accessor for association to statisticObserver
	 */
	public void setStatisticObserver(StatisticObserver statisticObserver) {
		this.statisticObserver = statisticObserver;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1321346476896_817371_2401) ENABLED START */
	static {
		defaults.put("template", "org::genesez::platform::common::statistic::Evaluation::Root");
		defaults.put("slot", "statisticModel");
		defaults.put("source", "html_template");
		defaults.put("withDetails", "false");
	}
	/* PROTECTED REGION END */
	
}

package org.genesez.statistic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_u1uL0IZUEeKi-fAVJTcXlg) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.type.impl.java.JavaMetaModel;
import org.genesez.m2t.FileTreeWalker;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;
import org.genesez.workflow.xpand.Model2TextComponent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleInsets;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class StatisticComponent extends Model2TextComponent {
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String htmlTemplateDir = "html_template";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String labelOwnImplCode = "impl. Code";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String labelGeneratedCode = "gen. Code";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String labelDocumentation = "documentation";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String labelComments = "comments";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private LineCounter lineCounter;
	
	private FileTreeWalker fileTreeWalker;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String title;
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._zIDYCIzIEeKLl_w7vhifuQ) ENABLED START */
		if (lineCounter == null) {
			issues.addInfo(this, "Missing property 'lineCounter', default will be used!", lineCounter);
			lineCounter = new LineCounter();
		}
		// don't use default slot of base class
		if (getSlot() == super.getDefaultSlot()) {
			setSlot(getDefaultSlot());
		}
		addMetaModel(new JavaMetaModel());
		super.checkConfiguration(issues);
		
		// init file tree walker
		fileTreeWalker = new FileTreeWalker();
		String dir = lineCounter.getBaseDir();
		if (dir == null) {
			dir = Paths.get(super.getOutputDir()).toAbsolutePath().getParent().toString();
			issues.addInfo(this, "LineCounter is missing property 'baseDir', parent directory of 'outputDir' will be used!", dir);
		}
		fileTreeWalker.setBaseDir(dir);
		if (!lineCounter.initialize()) {
			issues.addError(this, "LineCounter couldn't be initialized successfully!", lineCounter);
		}
		fileTreeWalker.addObserver(lineCounter);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._zIDYAIzIEeKLl_w7vhifuQ) ENABLED START */
		fileTreeWalker.walkFileTree();
		// prepare output dir
		Path htmlTemplate = Paths.get(htmlTemplateDir);
		if (Files.notExists(htmlTemplate)) {
			try {
				// obtain location of class file; note: could be a directory or a jar file!
				URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
				logger.debug("location: " + url);
				// either the directory or the jar file are in the same folder which contains the default template
				Path base = Paths.get(url.toURI()).getParent();
				htmlTemplate = base.resolve(htmlTemplate);
				logger.debug("path: " + htmlTemplate);
			} catch (Exception e) {
				logger.error("could not obtain default source for statistic html template", e);
			}
		}
		if (Files.exists(htmlTemplate)) {
			Path base = htmlTemplate;
			// try to read from the zip file
			Path zipped = htmlTemplate.resolve("html_template.zip");
			if (Files.exists(zipped)) {
				// create a new zip file system and copy html template from zip
				URI uri = URI.create("jar:file:" + zipped.toUri().getPath());
				try {
					FileSystem zfs = FileSystems.newFileSystem(uri, Collections.<String, String>emptyMap());
					base = zfs.getPath("/");
				} catch (IOException e) {
					logger.error("could not create zip file system", e);
				}
			}
			// copy html template files
			final Path copyBase = base;
			final Path destination = Paths.get(getOutputDir());
			try {
				Files.walkFileTree(base, new SimpleFileVisitor<Path>() {
					@Override
					public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
						// create output directory if not exists
						Path rel = copyBase.relativize(dir);
						Path dest = Paths.get(destination.toString(), rel.toString());
						if (Files.notExists(dest)) {
							Files.createDirectories(dest);
						}
						return FileVisitResult.CONTINUE;
					}
					
					@Override
					public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
						// copy file
						Path rel = copyBase.relativize(file);
						Path dest = Paths.get(destination.toString(), rel.toString());
						Files.copy(file, dest, StandardCopyOption.REPLACE_EXISTING);
						return super.visitFile(file, attrs);
					}
				});
			} catch (IOException e) {
				logger.error("could not copy html template!", e);
			}
		}
		
		generatePieCharts(issues);
		if (title == null) {
			title = Paths.get(lineCounter.getBaseDir()).getFileName().toString();
		}
		lineCounter.getRootDir().getStatSet().setTitle(title);
		context.set(getSlot(), lineCounter);
		super.invokeInternal(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Generates two pie charts for the overview page:
	 * - one showing only generated and manually implemented source code
	 * - another showing comments, documentation, generated and implemented source code
	 */
	protected void generatePieCharts(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._-zyFsIzQEeKLl_w7vhifuQ) ENABLED START */
		try {
			Path base = Paths.get(getOutputDir());
			Path dir = Files.createDirectories(base.resolve("charts"));
			StatisticsSet statSet = lineCounter.getRootDir().getStatSet();
			
			// the dataset for the pie charts 
			DefaultPieDataset dataset = new DefaultPieDataset();
			
			// fills the dataset for first pie chart
			dataset.setValue(labelOwnImplCode, statSet.getLinesOfOwnCode());
			dataset.setValue(labelGeneratedCode, statSet.getLinesOfGenCode());
			Path file = dir.resolve("gen_imp.png");
			generatePieChart(dataset, file, issues);
			statSet.setRelPathToGeneratedImplChart(base.relativize(file).toString().replace("\\", "/"));
			
			// adds information for the second pie chart
			dataset.setValue(labelDocumentation, statSet.getLinesOfDocu());
			dataset.setValue(labelComments, statSet.getLinesOfComments() + statSet.getLinesOfProtRegs());
			file = dir.resolve("all.png");
			generatePieChart(dataset, file, issues);
			statSet.setRelPathToOverviewChart(base.relativize(file).toString().replace("\\", "/"));
		} catch (IOException e) {
			issues.addWarning(this, "Charts couldn't be generated.", e);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Generates a pie chart and saves it as png file.
	 */
	protected void generatePieChart(PieDataset data, Path file, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._AaKNoIzREeKLl_w7vhifuQ) ENABLED START */
		// creates a 3D pie chart and sets the border invisible 
		JFreeChart chart = ChartFactory.createPieChart3D("", data, false, false, false);
		
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
		plot.setSectionPaint(labelOwnImplCode, new Color(238, 64, 0));
		plot.setSectionPaint(labelGeneratedCode, new Color(0, 238, 0));
		plot.setSectionPaint(labelDocumentation, Color.ORANGE);
		plot.setSectionPaint(labelComments, new Color(58, 95, 205));
		
		// configuration of the plot in itself to look nicer
		plot.setInsets(new RectangleInsets(0.0, 0.0, 1.0, 1.0));
		plot.setBackgroundPaint(Color.WHITE);
		plot.setOutlineVisible(false);
		plot.setForegroundAlpha((float) 0.7);
		
		// saves the chart as an png file
		try {
			ChartUtilities.saveChartAsPNG(file.toFile(), chart, 380, 120);
		} catch (IOException e) {
			issues.addWarning(this, "Pie chart couldn't be generated.", e);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>htmlTemplateDir</b></em>'.
	 */
	public String getHtmlTemplateDir() {
		return htmlTemplateDir;
	}
	
	/**
	 * Sets the value of attribute '<em><b>htmlTemplateDir</b></em>'.
	 * @param	htmlTemplateDir	the value to set.
	 */
	public void setHtmlTemplateDir(String htmlTemplateDir) {
		this.htmlTemplateDir = htmlTemplateDir;
	}
	
	/**
	 * Returns the value of attribute '<em><b>labelOwnImplCode</b></em>'.
	 */
	public String getLabelOwnImplCode() {
		return labelOwnImplCode;
	}
	
	/**
	 * Sets the value of attribute '<em><b>labelOwnImplCode</b></em>'.
	 * @param	labelOwnImplCode	the value to set.
	 */
	public void setLabelOwnImplCode(String labelOwnImplCode) {
		this.labelOwnImplCode = labelOwnImplCode;
	}
	
	/**
	 * Returns the value of attribute '<em><b>labelGeneratedCode</b></em>'.
	 */
	public String getLabelGeneratedCode() {
		return labelGeneratedCode;
	}
	
	/**
	 * Sets the value of attribute '<em><b>labelGeneratedCode</b></em>'.
	 * @param	labelGeneratedCode	the value to set.
	 */
	public void setLabelGeneratedCode(String labelGeneratedCode) {
		this.labelGeneratedCode = labelGeneratedCode;
	}
	
	/**
	 * Returns the value of attribute '<em><b>labelDocumentation</b></em>'.
	 */
	public String getLabelDocumentation() {
		return labelDocumentation;
	}
	
	/**
	 * Sets the value of attribute '<em><b>labelDocumentation</b></em>'.
	 * @param	labelDocumentation	the value to set.
	 */
	public void setLabelDocumentation(String labelDocumentation) {
		this.labelDocumentation = labelDocumentation;
	}
	
	/**
	 * Returns the value of attribute '<em><b>labelComments</b></em>'.
	 */
	public String getLabelComments() {
		return labelComments;
	}
	
	/**
	 * Sets the value of attribute '<em><b>labelComments</b></em>'.
	 * @param	labelComments	the value to set.
	 */
	public void setLabelComments(String labelComments) {
		this.labelComments = labelComments;
	}
	
	/**
	 * Returns the value of attribute '<em><b>lineCounter</b></em>'.
	 */
	public LineCounter getLineCounter() {
		return lineCounter;
	}
	
	/**
	 * Sets the value of attribute '<em><b>lineCounter</b></em>'.
	 * @param	lineCounter	the value to set.
	 */
	public void setLineCounter(LineCounter lineCounter) {
		this.lineCounter = lineCounter;
	}
	
	/**
	 * Returns the value of attribute '<em><b>title</b></em>'.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the value of attribute '<em><b>title</b></em>'.
	 * @param	title	the value to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "htmlTemplateDir")
	public String getDefaultHtmlTemplateDir() {
		return "html_template";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "slot")
	public String getDefaultSlot() {
		return "statisticmodel";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "labelOwnImplCode")
	public String getDefaultLabelOwnImplCode() {
		return "impl. Code";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "labelGeneratedCode")
	public String getDefaultLabelGeneratedCode() {
		return "gen. Code";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "labelDocumentation")
	public String getDefaultLabelDocumentation() {
		return "documentation";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "labelComments")
	public String getDefaultLabelComments() {
		return "comments";
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._u1uL0IZUEeKi-fAVJTcXlg) ENABLED START */
	/* PROTECTED REGION END */
}

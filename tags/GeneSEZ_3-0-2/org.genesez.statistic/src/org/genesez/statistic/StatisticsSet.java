package org.genesez.statistic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1320316789551_308733_1733) 
 */

/**
 * Stores the values of the code statistics.
 * 
 * @author T. Hartmann
 * @author Dominik Wetzel
 * @date 2011-11-15
 */
public class StatisticsSet {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * count of generated comment lines
	 */
	private int linesOfGenComments = 0;
	
	/**
	 * count of own documentation lines
	 */
	private int linesOfOwnDocu = 0;
	
	/**
	 * count of generated protected region lines.
	 */
	private int linesOfProtRegs = 0;
	
	/**
	 * count of own comment lines
	 */
	private int linesOfOwnComments = 0;
	
	/**
	 * count of generated docu lines
	 */
	private int linesOfGenDocu = 0;
	
	/**
	 * count of generated code lines
	 */
	private int linesOfGenCode = 0;
	
	/**
	 * count of own code lines
	 */
	private int linesOfOwnCode = 0;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * increases all stats by the given values.
	 * @param	genComment	generated comments
	 * @param	genDocu	generated documentation
	 * @param	genCode	generated code
	 * @param	protReg	protected region lines
	 * @param	ownComment	self written comments
	 * @param	ownDocu	self written documentation
	 * @param	ownCode	self written implementation
	 */
	
	public void incStats(int genComment, int genDocu, int genCode, int protReg, int ownComment, int ownDocu, int ownCode) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321005698441_599119_3730) ENABLED START */
		this.linesOfGenComments += genComment;
		this.linesOfGenDocu += genDocu;
		this.linesOfGenCode += genCode;
		this.linesOfProtRegs += protReg;
		this.linesOfOwnComments += ownComment;
		this.linesOfOwnDocu += ownDocu;
		this.linesOfOwnCode += ownCode;
		/* PROTECTED REGION END */
	}
	
	/**
	 * increases the stats by the values in the given statisticSet
	 * @param	statSet	the StatisticSet that contains the values.
	 */
	
	public void incStats(StatisticsSet statSet) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321005964511_81231_3771) ENABLED START */
		incStats(statSet.getLinesOfGenComments(), statSet.getLinesOfGenDocu(), statSet.getLinesOfGenCode(), statSet.getLinesOfProtRegs(), statSet.getLinesOfOwnComments(), statSet.getLinesOfOwnDocu(), statSet.getLinesOfOwnCode());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Increments the count of the code lines.
	 * @param	gen	if true linesOfGenCode will be increased else linesOfOwnCode
	 */
	
	public void incCode(boolean gen) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321006229008_405969_3778) ENABLED START */
		if (gen) {
			linesOfGenCode++;
		} else {
			linesOfOwnCode++;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Increments the count of documentation lines.
	 * @param	gen	if true linesOfGenDocu will be increased else linesOfOwnDocu.
	 */
	
	public void incDocu(boolean gen) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321006364446_921040_3785) ENABLED START */
		if (gen) {
			linesOfGenDocu++;
		} else {
			linesOfOwnDocu++;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Increments the count of comment lines.
	 * @param	gen	if true linesOfGenComments will be increased else linesOfOwnComments
	 */
	
	public void incComment(boolean gen) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321006436470_96878_3796) ENABLED START */
		if (gen) {
			linesOfGenComments++;
		} else {
			linesOfOwnComments++;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Increments the count of protected region lines.
	 */
	
	public void incProtReg() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321006531574_185681_3804) ENABLED START */
		linesOfProtRegs++;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Increases the count of code lines.
	 * @param	value	count of code lines will be increased by this value.
	 * @param	gen	if true linesOfGenCode will be increased else linesOfOwnCode
	 */
	
	public void incCode(int value, boolean gen) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321006594310_227443_3809) ENABLED START */
		if (gen) {
			linesOfGenCode += value;
		} else {
			linesOfOwnCode += value;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Increases the count of comment lines.
	 * @param	value	count of comment lines will be increased by this value.
	 * @param	gen	if true linesOfGenComments will be increased else linesOfOwnComments.
	 */
	
	public void incComment(int value, boolean gen) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321006705446_189308_3818) ENABLED START */
		if (gen) {
			linesOfGenComments += value;
		} else {
			linesOfOwnComments += value;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Increases the count of documentation lines.
	 * @param	value	count of documentation lines will be increased by this value.
	 * @param	gen	if true linesOfGenDocu will be increased else linesOfOwnDocu.
	 */
	
	public void incDocu(int value, boolean gen) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321006799694_32147_3827) ENABLED START */
		if (gen) {
			linesOfGenDocu += value;
		} else {
			linesOfOwnDocu += value;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Increases the count of protected region lines
	 * @param	value	count of protected region lines is increased by this value.
	 */
	
	public void incProtReg(int value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321006917414_713722_3836) ENABLED START */
		linesOfProtRegs += value;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	all counted lines together.
	 */
	public int getAllLines() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321007102630_319748_3843) ENABLED START */
		return (linesOfGenCode + linesOfGenComments + linesOfGenDocu + linesOfProtRegs + linesOfOwnCode + linesOfOwnComments + linesOfOwnDocu);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	all generated lines together.
	 */
	public int getAllGeneratedLines() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321007155655_418049_3849) ENABLED START */
		return (linesOfGenCode + linesOfGenComments + linesOfGenDocu + linesOfProtRegs);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	all self written lines together.
	 */
	public int getAllOwnLines() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321007208055_398222_3855) ENABLED START */
		return (linesOfOwnCode + linesOfOwnComments + linesOfOwnDocu);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	all lines of generated together with implemented code.
	 */
	public int getLinesOfCode() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321007273166_789439_3861) ENABLED START */
		return (linesOfGenCode + linesOfOwnCode);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	all lines of generated and self written comments
	 */
	public int getLinesOfComments() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321007331615_188244_3867) ENABLED START */
		return (linesOfGenComments + linesOfOwnComments);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	all lines of generated and self written documentation
	 */
	public int getLinesOfDocu() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321007384711_513363_3873) ENABLED START */
		return (linesOfGenDocu + linesOfOwnDocu);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Accounts the percentage of generated code to all code lines
	 * @return	the percentage of generated code to all code lines
	 */
	public int getGenCodeRating() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321007516637_647509_3879) ENABLED START */
		return Math.round((getLinesOfGenCode() / Float.valueOf(getLinesOfCode())) * 100);
		/* PROTECTED REGION END */
	}
	
	/**
	 * The string representation of the object.
	 * @return	The String containing all important information:<br>"[genCode | genComments | genDocu | protRegLines:::ownCode | ownComments | ownDocu:::overall]"
	 */
	public String toString() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321008197198_556780_3943) ENABLED START */
		return "[genCode=" + linesOfGenCode + " | genComments=" + linesOfGenComments + " | genDocu=" + linesOfGenDocu + " | protRegLines=" + linesOfProtRegs + ":::" + "ownCode=" + linesOfOwnCode + " | ownComments=" + linesOfOwnComments + " | ownDocu=" + linesOfOwnDocu + ":::overall=" + getAllLines() + "]\n";
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * count of generated comment lines
	 */
	public int getLinesOfGenComments() {
		return linesOfGenComments;
	}
	
	/**
	 * count of own documentation lines
	 */
	public int getLinesOfOwnDocu() {
		return linesOfOwnDocu;
	}
	
	/**
	 * count of generated protected region lines.
	 */
	public int getLinesOfProtRegs() {
		return linesOfProtRegs;
	}
	
	/**
	 * count of own comment lines
	 */
	public int getLinesOfOwnComments() {
		return linesOfOwnComments;
	}
	
	/**
	 * count of generated docu lines
	 */
	public int getLinesOfGenDocu() {
		return linesOfGenDocu;
	}
	
	/**
	 * count of generated code lines
	 */
	public int getLinesOfGenCode() {
		return linesOfGenCode;
	}
	
	/**
	 * count of own code lines
	 */
	public int getLinesOfOwnCode() {
		return linesOfOwnCode;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1320316789551_308733_1733) ENABLED START */
	private String relPathToGeneratedImplChart = null;
	private String relPathToOverviewChart = null;
	private String title = null;
	
	public String getRelPathToGeneratedImplChart() {
		return relPathToGeneratedImplChart;
	}

	public void setRelPathToGeneratedImplChart(String relPathToGeneratedImplChart) {
		this.relPathToGeneratedImplChart = relPathToGeneratedImplChart;
	}

	public String getRelPathToOverviewChart() {
		return relPathToOverviewChart;
	}

	public void setRelPathToOverviewChart(String relPathToOverviewChart) {
		this.relPathToOverviewChart = relPathToOverviewChart;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	/* PROTECTED REGION END */
}

package de.genesez.platforms.common.statistic;

/**
 * Set for values of the statistics
 * 
 * @author T. Hartmann ( tomha@fh-zwickau.de )
 * @author Dominik Wetzel
 * @date 2011-11-15
 */
public class StatisticsSet {

	/** count of generated comments lines */
	private int linesOfGenComments = 0;
	/** count of generated documentation lines */
	private int linesOfGenDocu = 0;
	/** count of generated code lines */
	private int linesOfGenCode = 0;
	/** count of protected region lines */
	private int linesOfProtRegs = 0;
	/** count of own comment lines */
	private int linesOfOwnComments = 0;
	/** count of own documentation lines */
	private int linesOfOwnDocu = 0;
	/** count of own code lines */
	private int linesOfOwnCode = 0;

	/**
	 * increases the statistics by the given amounts of:
	 * 
	 * @param genCommment
	 *            generated comment lines
	 * @param genDocu
	 *            generated documentation lines
	 * @param genCode
	 *            generated code lines
	 * @param protReg
	 *            generated protected region liness
	 * @param ownComment
	 *            own comment lines
	 * @param ownDocu
	 *            own documentation lines
	 * @param ownCode
	 *            implemented code lines
	 */
	public void incStats(int genCommment, int genDocu, int genCode,
			int protReg, int ownComment, int ownDocu, int ownCode) {
		this.linesOfGenComments += genCommment;
		this.linesOfGenDocu += genDocu;
		this.linesOfGenCode += genCode;
		this.linesOfProtRegs += protReg;
		this.linesOfOwnComments += ownComment;
		this.linesOfOwnDocu += ownDocu;
		this.linesOfOwnCode += ownCode;
	}

	/**
	 * increases the statistics by the given amounts in the given StatisticsSet
	 * 
	 * @param statSet
	 *            the StatisticsSet
	 */
	public void incStats(StatisticsSet statSet) {
		incStats(statSet.getLinesOfGenComments(), statSet.getLinesOfGenDocu(),
				statSet.getLinesOfGenCode(), statSet.getLinesOfProtRegs(),
				statSet.getLinesOfOwnComments(), statSet.getLinesOfOwnDocu(),
				statSet.getLinesOfOwnCode());
	}

	/**
	 * increments code lines
	 * 
	 * @param gen
	 *            true if its generated
	 */
	public void incCode(boolean gen) {
		if (gen) {
			linesOfGenCode++;
		} else {
			linesOfOwnCode++;
		}
	}

	/**
	 * increments documentation lines
	 * 
	 * @param gen
	 *            true if its generated
	 */
	public void incDocu(boolean gen) {
		if (gen) {
			linesOfGenDocu++;
		} else {
			linesOfOwnDocu++;
		}
	}

	/**
	 * increments comment lines
	 * 
	 * @param gen
	 *            true if its generated
	 */
	public void incComment(boolean gen) {
		if (gen) {
			linesOfGenComments++;
		} else {
			linesOfOwnComments++;
		}
	}

	/**
	 * increments the value of protected regions
	 */
	public void incProtReg() {
		linesOfProtRegs++;
	}

	/**
	 * increases code lines
	 * 
	 * @param value
	 *            increase by this
	 * @param gen
	 *            true if its generated
	 */
	public void incCode(int value, boolean gen) {
		if (gen) {
			linesOfGenCode += value;
		} else {
			linesOfOwnCode += value;
		}
	}

	/**
	 * increases comment lines
	 * 
	 * @param value
	 *            increase by this
	 * @param gen
	 *            true if generated
	 */
	public void incComment(int value, boolean gen) {
		if (gen) {
			linesOfGenComments += value;
		} else {
			linesOfOwnComments += value;
		}
	}

	/**
	 * increase documentation lines
	 * 
	 * @param value
	 *            increase by this
	 * @param gen
	 *            true if its generated
	 */
	public void incDocu(int value, boolean gen) {
		if (gen) {
			linesOfGenDocu += value;
		} else {
			linesOfOwnDocu += value;
		}
	}

	/**
	 * increases protected region lines
	 * 
	 * @param value
	 *            increase by this
	 */
	public void incProtReg(int value) {
		linesOfProtRegs += value;
	}

	// ----GETTERS----------------------------------------------------------
	/**
	 * 
	 * @return all lines
	 */
	public int getAllLines() {
		return (linesOfGenCode + linesOfGenComments + linesOfGenDocu
				+ linesOfProtRegs + linesOfOwnCode + linesOfOwnComments + linesOfOwnDocu);
	}

	/**
	 * 
	 * @return all generated lines
	 */
	public int getAllGeneratedLines() {
		return (linesOfGenCode + linesOfGenComments + linesOfGenDocu + linesOfProtRegs);
	}

	/**
	 * 
	 * @return all self written lines
	 */
	public int getAllOwnLines() {
		return (linesOfOwnCode + linesOfOwnComments + linesOfOwnDocu);
	}

	/**
	 * 
	 * @return all Code lines (generated and implemented)
	 */
	public int getLinesOfCode() {
		return (linesOfGenCode + linesOfOwnCode);
	}

	/**
	 * 
	 * @return all comment lines (generated and own)
	 */
	public int getLinesOfComments() {
		return (linesOfGenComments + linesOfOwnComments);
	}

	/**
	 * 
	 * @return all documentation lines (generated and own)
	 */
	public int getLinesOfDocu() {
		return (linesOfGenDocu + linesOfOwnDocu);
	}

	/**
	 * 
	 * @return protected region lines
	 */
	public int getLinesOfProtRegs() {
		return linesOfProtRegs;
	}

	/**
	 * 
	 * @return generated comment lines
	 */
	public int getLinesOfGenComments() {
		return linesOfGenComments;
	}

	/**
	 * 
	 * @return own comment lines
	 */
	public int getLinesOfOwnComments() {
		return linesOfOwnComments;
	}

	/**
	 * 
	 * @return generated code lines
	 */
	public int getLinesOfGenCode() {
		return linesOfGenCode;
	}

	/**
	 * 
	 * @return implemented code lines
	 */
	public int getLinesOfOwnCode() {
		return linesOfOwnCode;
	}

	/**
	 * @return generated documentation lines
	 */
	public int getLinesOfGenDocu() {
		return linesOfGenDocu;
	}

	/**
	 * 
	 * @return own documentation lines
	 */
	public int getLinesOfOwnDocu() {
		return linesOfOwnDocu;
	}

	/**
	 * calculates the rate of generated code to all code lines
	 * @return rate of generated code to all code lines
	 */
	public int getGenCodeRating() {
		float gen = getLinesOfGenCode();
		float imp = getLinesOfOwnCode();
		float erg = (gen / (gen + imp)) * 100;

		return new Float(erg).intValue();
	}

//	/**
//	 * gibt den Anteil an nicht generierten/impl. Code zurueck im Bezug auf d.
//	 * funktionellen Codezeilen
//	 * 
//	 * @return Prozentsatz an implementiertem Code
//	 */
//	public int getImpCodeRating() {
//		float gen = getLinesOfGenCode();
//		float imp = getLinesOfOwnCode();
//		float erg = (imp / (gen + imp)) * 100;
//
//		return new Float(erg).intValue();
//	}
//
//	/**
//	 * gibt den Anteil an generierten Code zurueck im Bezug auf die
//	 * Gesamtcodezeilenanzahl
//	 * 
//	 * @return Prozentsatz an generierten Code
//	 */
//	public int getGenCodeRatingAll() {
//		float gen = getLinesOfGenCode();
//		float erg = (gen / (getAllLines())) * 100;
//
//		return new Float(erg).intValue();
//	}
//
//	/**
//	 * gibt den Anteil an nicht generierten/impl. Code zurueck im Bezug auf die
//	 * Gesamtcodezeilenanzahl
//	 * 
//	 * @return Prozentsatz an implementiertem Code
//	 */
//	public int getImpCodeRatingAll() {
//		float imp = getLinesOfOwnCode();
//		float erg = (imp / (getAllLines())) * 100;
//
//		return new Float(erg).intValue();
//	}
//
//	/**
//	 * gibt den Anteil an Kommentarzeilen zurueck im Bezug auf die
//	 * Gesamtcodezeilenanzahl
//	 * 
//	 * @return Prozentsatz an Kommentarzeilen
//	 */
//	public int getCommentRatingAll() {
//		float com = getLinesOfComments();
//		float erg = (com / (getAllLines())) * 100;
//
//		return new Float(erg).intValue();
//	}
//
//	/**
//	 * gibt den Anteil an Dokumentationszeilen zurueck im Bezug auf die
//	 * Gesamtcodezeilenanzahl
//	 * 
//	 * @return Prozentsatz an Dokumentationszeilen
//	 */
//	public int getDocuRatingAll() {
//		float doc = getLinesOfDocu();
//		float erg = (doc / (getAllLines())) * 100;
//
//		return new Float(erg).intValue();
//	}
//
//	public int getProtRegRatingAll() {
//		float protReg = getLinesOfProtRegs();
//		float erg = (protReg / (getAllLines())) * 100;
//
//		return new Float(erg).intValue();
//	}

	/**
	 * String representation of the StatisticSet
	 * @return field=value, for all fields, and all counted lines.
	 */
	@Override
	public String toString() {
		return "[genCode=" + linesOfGenCode + " | genComments="
				+ linesOfGenComments + " | genDocu=" + linesOfGenDocu
				+ " | protRegLines=" + linesOfProtRegs + ":::" + "ownCode="
				+ linesOfOwnCode + " | ownComments=" + linesOfOwnComments
				+ " | ownDocu=" + linesOfOwnDocu + ":::overall="
				+ getAllLines() + "]\n";
	}
}

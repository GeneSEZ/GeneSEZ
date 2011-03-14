package de.genesez.platforms.common.statistic;

/**
 * Kommentarzeichen der entsprechenden Sprache
 * 
 * @author T. Hartmann ( tomha@fh-zwickau.de )
 */
public class CommentSign {

	/** zeichen fuer Kommentar */
	private String singleLineComment;
	/** zeichen fuer einleitendes eines mehrzeiligen Kommentares */
	private String multiLineCommentStart;
	/** zeichen fuer Ende eines mehrzeiligen Kommentares */
	private String multiLineCommentEnd;
	/** zeichen fuer einzelene Zeile eines mehrzeiligen Kommentares */
	private String multiLineCommentLine;
	/** zeichen fuer einleitendes eines mehrzeiligen Dokumentationskommentars */
	private String multiLineDocCommentStart;

	/** Java-Kommentarzeichen */
	public static final String[] JAVA = { "//", "/\\*", "\\*/", "\\*", "/\\*\\*" };
	/** PHP-Kommentarzeichen */
	public static final String[] PHP = { "//", "/\\*", "\\*/", "\\*", "/\\*\\*" };

	/**
	 * Standardkonstruktor
	 */
	public CommentSign() {
		setComSigns(JAVA);
	}

	/**
	 * gibt das normale Kommentarzeichen zurueck
	 * 
	 * @return Standard-Kommentarzeichen
	 */
	public String getSingleLineComment() {
		return singleLineComment;
	}

	/**
	 * setzen des normalen Kommentarzeichen
	 * 
	 * @param comment
	 *            Standard-Kommentarzeichen
	 */
	public void setSingleLineComment(String comment) {
		singleLineComment = comment;
	}

	/**
	 * rueckgabe des Zeichens zum einleiten eines mehrzeiligen Kommentares
	 * 
	 * @return zeichen zum einleiten eines mehrzeiligen Kommentares
	 */
	public String getMultiLineCommentStart() {
		return multiLineCommentStart;
	}

	/**
	 * setzen des Zeichens zum einleiten eines mehrzeiligen Kommentares
	 * 
	 * @param zeichen
	 *            zum einleiten eines mehrzeiligen Kommentares
	 */
	public void setMultiLineCommentStart(String comStart) {
		multiLineCommentStart = comStart;
	}

	/**
	 * rueckgabe des Zeichens zum beenden eines mehrzeiligen Kommentares
	 * 
	 * @return zeichen zum beenden eines mehrzeiligen Kommentares
	 */
	public String getMultiLineCommentEnd() {
		return multiLineCommentEnd;
	}

	/**
	 * setzen des Zeichens zum beenden eines mehrzeiligen Kommentares
	 * 
	 * @param zeichen
	 *            zum beenden eines mehrzeiligen Kommentares
	 */
	public void setMultiLineCommentEnd(String comEnd) {
		multiLineCommentEnd = comEnd;
	}

	/**
	 * rueckgabe des Zeichens fuer mehrzeilige Kommentare
	 * 
	 * @return zeichen fuer mehrzeilige Kommentare
	 */
	public String getMultiLineCommentLine() {
		return multiLineCommentLine;
	}

	/**
	 * setzen des Zeichens fuer mehrzeilige Kommentare
	 * 
	 * @param zeichen
	 *            fuer mehrzeilige Kommentare
	 */
	public void setMultiLineCommentLine(String com) {
		multiLineCommentLine = com;
	}

	/**
	 * rueckgabe des Zeichens Dokumentationskommentare
	 * 
	 * @return zeichen fuer Dokumentationskommentare
	 */
	public String getMultiLineDocCommentStart() {
		return multiLineDocCommentStart;
	}

	/**
	 * setzen des Zeichens Dokumentationskommentare
	 * 
	 * @param zeichen
	 *            fuer Dokumentationskommentare
	 */
	public void setMultiLineDocCommentStart(String doc) {
		multiLineDocCommentStart = doc;
	}

	/**
	 * setzen aller Kommentarzeichen
	 * 
	 * @param sComment
	 *            normales Kommentarzeichen
	 * @param sComStart
	 *            Anfang eines mehrzeiligen Kommentars
	 * @param sComEnd
	 *            Ende eines mehrzeiligen Kommentars
	 * @param sCom
	 *            Zeichen eines Mehrzeiligen Kommentars
	 * @param sDoc
	 *            Zeichen um Dokumentationkommentare einzuleiten
	 */
	public void setComSigns(String sComment, String sComStart, String sComEnd,
			String sCom, String sDoc) {
		this.multiLineCommentLine = sCom;
		this.singleLineComment = sComment;
		this.multiLineCommentStart = sComStart;
		this.multiLineCommentEnd = sComEnd;
		this.multiLineDocCommentStart = sDoc;
	}

	/**
	 * rueckgabe aller Kommentarzeichen als Array
	 * 
	 * @return StringArray mit Kommentarzeichen
	 */
	public String[] getSignsAsArray() {
		return new String[] { singleLineComment, multiLineCommentLine, multiLineCommentStart, multiLineCommentEnd, multiLineDocCommentStart };
	}

	/**
	 * setzen aller Kommentarzeichen
	 * 
	 * @param StringArray
	 *            mit Kommentarzeichen
	 */
	public void setComSigns(String[] sA) {
		setComSigns(sA[0], sA[1], sA[2], sA[3], sA[4]);
	}

}

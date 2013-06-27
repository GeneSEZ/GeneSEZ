package de.genesez.platforms.common.statistic;

/**
 * Set fuer die einzelnen Werte der Codestatistik
 * 
 * @author T. Hartmann ( tomha@fh-zwickau.de )
 */
public class StatisticSet {

	/** Anzahl d. Zeilen generiert */
	private int iGen = 0;
	/** Anzahl d. Zeilen implementiert */
	private int iImpl = 0;
	/** Anzahl d. Kommentare */
	private int iComment = 0;
	/** Anzahl d. Dokukommentare */
	private int iDocu = 0;
	/** Anzahl d. prot.Regions */
	private int iProtReg = 0;

	/** Standardkonstruktor */
	public StatisticSet() {

	}

	/**
	 * erhoehe die Werte der CodeStatistik
	 * 
	 * @param impl
	 *            Anteil implementierter Code
	 * @param gen
	 *            Anteil generierter Code
	 * @param com
	 *            Anteil Kommentare
	 * @param doc
	 *            Anteil Dokumentationskommentare
	 */
	public void incStats(int impl, int gen, int com, int doc) {
		this.iGen += gen;
		this.iImpl += impl;
		this.iComment += com;
		this.iDocu += doc;
	}
	
	public void incStats(StatisticSet statSet){
		iGen += statSet.getLinesOfGenCode();
		iImpl += statSet.getLinesOfImplCode();
		iComment += statSet.getLinesOfComments();
		iDocu += statSet.getLinesOfDocu();		
	}

	/**
	 * erhoeht den Wert fuer generierten Code um 1
	 */
	public void incGen() {
		iGen++;
	}

	/**
	 * erhoeht den Wert fuer implementierten Code um 1
	 */
	public void incImpl() {
		iImpl++;
	}

	/**
	 * erhoeht den Wert fuer Kommentare um 1
	 */
	public void incCom() {
		iComment++;
	}

	/**
	 * erhoeht den Wert fuer Dokumentationskommentare um 1
	 */
	public void incDocu() {
		iDocu++;
	}

	/**
	 * erhoeht den Wert fuer die Protected Regions um 1
	 */
	public void incProtReg() {
		iProtReg++;
	}

	/**
	 * * erhoeht den Wert fuer generierten Code
	 * 
	 * @param wert
	 *            wert um den erhoeht werden soll
	 */
	public void incGen(int wert) {
		iGen = iGen + wert;
	}

	/**
	 * * erhoeht den Wert fuer implementierten Code
	 * 
	 * @param wert
	 *            wert um den erhoeht werden soll
	 */
	public void incImpl(int wert) {
		iImpl = iImpl + wert;
	}

	/**
	 * * erhoeht den Wert fuer die Kommentare
	 * 
	 * @param wert
	 *            wert um den erhoeht werden soll
	 */
	public void incCom(int wert) {
		iComment = iComment + wert;
	}

	/**
	 * * erhoeht den Wert fuer die Dokumentationskommentare
	 * 
	 * @param wert
	 *            wert um den erhoeht werden soll
	 */
	public void incDocu(int wert) {
		iDocu = iDocu + wert;
	}

	/**
	 * * erhoeht den Wert fuer Prot.Regions
	 * 
	 * @param wert
	 *            wert um den erhoeht werden soll
	 */
	public void incProtReg(int wert) {
		iProtReg = iProtReg + wert;
	}

	/**
	 * Ausgabe ob der Code ueberhaupt generierte Zeilen enthaelt bzw.
	 * ProtectedRegions
	 * 
	 * @return gibt es prot. Regions im Code?
	 */
	public boolean isGenerated() {
		if (iProtReg == 0)
			return false;
		return true;
	}

	// ----GETTERS----------------------------------------------------------
	/** Rueckgabe der Anzahl an Codezeilen */
	public int getLinesOfCode() {
		return (iGen + iImpl + iComment + iDocu +iProtReg);
	}

	/** Rueckgabe der Anzahl an Kommentarzeilen */
	public int getLinesOfComments() {
		return iComment;
	}

	/** Rueckgabe der Anzahl an generierten Codezeilen */
	public int getLinesOfGenCode() {
		return iGen + iProtReg;
	}

	/** Rueckgabe der Anzahl an selbst implementierten Codezeilen */
	public int getLinesOfImplCode() {
		return iImpl;
	}

	/** Rueckgabe der Anzahl an Dokumentarzeilen */
	public int getLinesOfDocu() {
		return iDocu;
	}

	// ----SETTERS-----------------------------------------------------------
	/** Setzen der Anzahl an generierten Codezeilen */
	public void setLinesOfGenCode(int gen) {
		this.iGen = gen;
	}

	/** Setzen der Anzahl an selbst implementierten Codezeilen */
	public void setLinesOfImplCode(int impl) {
		this.iImpl = impl;
	}

	/* Setzen der Anzahl an Kommentarzeilen */
	public void setLinesOfComments(int comment) {
		this.iComment = comment;
	}

	/** Setzen der Anzahl an Dokumentarzeilen */
	public void setLinesOfDocu(int docu) {
		this.iDocu = docu;
	}
	
	/** Setzen der Anzahl an Dokumentarzeilen */
	public void setLinesOfProtReg(int prReg) {
		this.iProtReg = prReg;
	}
	
	
	// --Prozente----------------------------------------------------------
	
	/**
	 * gibt den Anteil an generierten Code zurueck im Bezug
	 * auf d. funktionellen Codezeilen
	 * 
	 * @return Prozentsatz an generierten Code
	 */
	public int getGenCodeRating()
	{
		float gen = getLinesOfGenCode();
		float imp = getLinesOfImplCode();
		float erg = (gen/(gen+imp))*100;
		
		return new Float(erg).intValue();
	}
	
	/**
	 * gibt den Anteil an nicht generierten/impl. Code zurueck im Bezug
	 * auf d. funktionellen Codezeilen
	 * 
	 * @return Prozentsatz an implementiertem Code
	 */
	public int getImpCodeRating()
	{
		float gen = getLinesOfGenCode();
		float imp = getLinesOfImplCode();
		float erg = (imp/(gen+imp))*100;
		
		return new Float(erg).intValue();
	}
	
	
	/**
	 * gibt den Anteil an generierten Code zurueck im Bezug
	 * auf die Gesamtcodezeilenanzahl
	 * 
	 * @return Prozentsatz an generierten Code
	 */
	public int getGenCodeRatingAll()
	{
		float gen = getLinesOfGenCode();
		float erg = (gen/(getLinesOfCode()))*100;
		
		return new Float(erg).intValue();
	}
	
	/**
	 * gibt den Anteil an nicht generierten/impl. Code zurueck im Bezug
	 * auf die Gesamtcodezeilenanzahl
	 * 
	 * @return Prozentsatz an implementiertem Code
	 */
	public int getImpCodeRatingAll()
	{
		float imp = getLinesOfImplCode();
		float erg = (imp/(getLinesOfCode()))*100;
		
		return new Float(erg).intValue();
	}
	
	/**
	 * gibt den Anteil an Kommentarzeilen zurueck im Bezug
	 * auf die Gesamtcodezeilenanzahl
	 * 
	 * @return Prozentsatz an Kommentarzeilen
	 */
	public int getCommentRatingAll()
	{
		float com = getLinesOfComments();
		float erg = (com/(getLinesOfCode()))*100;
		
		return new Float(erg).intValue();
	}
	
	/**
	 * gibt den Anteil an Dokumentationszeilen zurueck im Bezug
	 * auf die Gesamtcodezeilenanzahl
	 * 
	 * @return Prozentsatz an Dokumentationszeilen
	 */
	public int getDocuRatingAll()
	{
		float doc = getLinesOfDocu();
		float erg = (doc/(getLinesOfCode()))*100;
		
		return new Float(erg).intValue();
	}
	

}

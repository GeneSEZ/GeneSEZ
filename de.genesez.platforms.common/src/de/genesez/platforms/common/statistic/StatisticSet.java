package de.genesez.platforms.common.statistic;

/**
 * Set für die einzelnen Werte der Codestatistik
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
	 * erhöhe die Werte der CodeStatistik
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
	 * erhöht den Wert für generierten Code um 1
	 */
	public void incGen() {
		iGen++;
	}

	/**
	 * erhöht den Wert für implementierten Code um 1
	 */
	public void incImpl() {
		iImpl++;
	}

	/**
	 * erhöht den Wert für Kommentare um 1
	 */
	public void incCom() {
		iComment++;
	}

	/**
	 * erhöht den Wert für Dokumentationskommentare um 1
	 */
	public void incDocu() {
		iDocu++;
	}

	/**
	 * erhöht den Wert für die Protected Regions um 1
	 */
	public void incProtReg() {
		iProtReg++;
	}

	/**
	 * * erhöht den Wert für generierten Code
	 * 
	 * @param wert
	 *            wert um den erhöht werden soll
	 */
	public void incGen(int wert) {
		iGen = iGen + wert;
	}

	/**
	 * * erhöht den Wert für implementierten Code
	 * 
	 * @param wert
	 *            wert um den erhöht werden soll
	 */
	public void incImpl(int wert) {
		iImpl = iImpl + wert;
	}

	/**
	 * * erhöht den Wert für die Kommentare
	 * 
	 * @param wert
	 *            wert um den erhöht werden soll
	 */
	public void incCom(int wert) {
		iComment = iComment + wert;
	}

	/**
	 * * erhöht den Wert für die Dokumentationskommentare
	 * 
	 * @param wert
	 *            wert um den erhöht werden soll
	 */
	public void incDocu(int wert) {
		iDocu = iDocu + wert;
	}

	/**
	 * * erhöht den Wert für Prot.Regions
	 * 
	 * @param wert
	 *            wert um den erhöht werden soll
	 */
	public void incProtReg(int wert) {
		iProtReg = iProtReg + wert;
	}

	/**
	 * Ausgabe ob der Code überhaupt generierte Zeilen enthält bzw.
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
	/** Rückgabe der Anzahl an Codezeilen */
	public int getLinesOfCode() {
		return (iGen + iImpl + iComment + iDocu +iProtReg);
	}

	/** Rückgabe der Anzahl an Kommentarzeilen */
	public int getLinesOfComments() {
		return iComment;
	}

	/** Rückgabe der Anzahl an generierten Codezeilen */
	public int getLinesOfGenCode() {
		return iGen + iProtReg;
	}

	/** Rückgabe der Anzahl an selbst implementierten Codezeilen */
	public int getLinesOfImplCode() {
		return iImpl;
	}

	/** Rückgabe der Anzahl an Dokumentarzeilen */
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
	 * gibt den Anteil an generierten Code zurück im Bezug
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
	 * gibt den Anteil an nicht generierten/impl. Code zurück im Bezug
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
	 * gibt den Anteil an generierten Code zurück im Bezug
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
	 * gibt den Anteil an nicht generierten/impl. Code zurück im Bezug
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
	 * gibt den Anteil an Kommentarzeilen zurück im Bezug
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
	 * gibt den Anteil an Dokumentationszeilen zurück im Bezug
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

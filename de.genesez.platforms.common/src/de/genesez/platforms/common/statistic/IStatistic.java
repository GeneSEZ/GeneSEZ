package de.genesez.platforms.common.statistic;

/**
 * Interface fuer die Statistik Dateien
 * 
 * @author T. Hartmann ( tomha@fh-zwickau.de )
 */
public interface IStatistic extends IParser {
	/**
	 * analysiert die Datei(en) und zaehlt die entsprechenden Anteile des Codes
	 */
	public void parseCode();

	/**
	 * Anzahl der gesamten Codezeilen
	 * 
	 * @return iCode AlleCode zeilen (generiert+implementiert)
	 */
	public int getLinesOfCode();

	/**
	 * Anzahl der generierten Codezeilen
	 * 
	 * @return iGen Anzahl d. generierten Zeilen
	 */
	public int getLinesOfGenCode();

	/**
	 * Anzahl der selbst implementierten Codezeilen
	 * 
	 * @return iCode Anzahl der implementierten Zeilen
	 */
	public int getLinesOfImplCode();

	/**
	 * Anzahl aller Kommentarzeilen
	 * 
	 * @return iComment Anzahl der Kommentarzeilen
	 */
	public int getLinesOfComments();

	/**
	 * Anzahl aller JavaDoc-Zeilen
	 * 
	 * @return iDocu Anzahl der Dokumentationszeilen
	 */
	public int getLinesOfDocu();
}
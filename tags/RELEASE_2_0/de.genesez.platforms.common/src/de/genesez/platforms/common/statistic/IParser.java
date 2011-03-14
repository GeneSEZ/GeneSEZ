package de.genesez.platforms.common.statistic;

/**
 * Interface fuer den Parser der generierten CodeDateien
 * 
 * @author T. Hartmann ( tomha@fh-zwickau.de )
 */
public interface IParser {
	/** leerzeichen */
	public static final int space = 0;
	/** normaler Code */
	public static final int code = 1;
	/** Kommentar */
	public static final int comment = 2;
	/** Anfang protected Regions */
	public static final int protRegStart = 3;
	/** Ende protected Regions */
	public static final int protRegEnd = 4;
	/** Dokumentationskommentar */
	public static final int docu = 5;
	/** Ende mehrzeiliger Kommentar */
	public static final int commentEnd = 6;
	/** generierter Code */
	public static final int genCode = 7;
	/** implementierter Code */
	public static final int implCode = 8;

	// --> zeichen fuer debugOutput
	public static final char signGen = 'G';
	public static final char signImp = 'I';
	public static final char signProtRegS = '<';
	public static final char signProtRegE = '>';
	public static final char signCom = '*';
	public static final char signDoc = '@';
	public static final char signSpace = '-';

	/** zeichen vor zeilennummerausgabe */
	public static final String debgStr = "|";
}

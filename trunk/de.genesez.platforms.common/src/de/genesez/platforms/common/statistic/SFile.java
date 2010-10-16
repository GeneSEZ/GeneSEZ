package de.genesez.platforms.common.statistic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * einzelne Datei eines Projektes das ausgewertet wird
 * 
 * @author T. Hartmann ( tomha@fh-zwickau.de )
 */
@SuppressWarnings("serial")
public class SFile extends File implements IStatistic {
	
	
	/** Logger fuers Debuggen */
	private Log logger = LogFactory.getLog(getClass());

	/** SpeicherContainr fuer die StatistikWerte */
	private StatisticSet statSet;
	
	/** Bool-Wert ob das File generiert ist */
	boolean gen = true;

	/** Standard-Konstruktor */
	public SFile() {
		super("");
		statSet = new StatisticSet();
	}

	/**
	 * Konstruktor mit Pfadangabe als String
	 * 
	 * @param s
	 *            Pfad
	 */
	public SFile(String s) {
		super(s);
		statSet = new StatisticSet();
	}
	
	/**
	 * Konstruktor mit Pfadangabe als String
	 * 
	 * 
	 * @param s
	 *           	Pfad
	 * @param gen
	 * 				generierter Code?
	 */
	public SFile(String s, boolean gen) {
		super(s);
		statSet = new StatisticSet();
		this.gen = gen;
	}
	

	/**
	 * Konstruktor mit Fileobjektinput
	 * 
	 * @param f
	 *            Pfad
	 */
	public SFile(File f) {
		super(f.getAbsolutePath());
		statSet = new StatisticSet();
	}

	/*
	 * parst den im File enthaltenen Code und setzt die entsprechenden werte
	 * 
	 * @see IStatistic#parseCode()
	 */
	public void parseCode() {
		try {
			FileReader fr = new FileReader(this);
			BufferedReader br = new BufferedReader(fr);

			for (int i = 0; i <= 2; i++)
				logger.debug("");
			
			logger.debug("\t\t\t   Analysiere Quellcode von " + this.getName() + "");
		
		
			
			logger.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			int znr = 0; // zeilennummer beim parsen
			String znrS; // Zeilennummer-String
			String n; // eingelesene Zeile

			// ----zeilenweise einlesen bis zum Dateiende:---------------------------------------
			do {
				n = br.readLine();
				if (n == null)
					break; // Endbedingung, wenn keine Zeile mehr eingelesen
							// wird = DateiEnde

				znr++;
				znrS = this.getLineNbrString(znr);

				/*
				 * Parser wertet aus um was fuer eine Art es sich bei der
				 * aktuellen Zeile handelt
				 */
				LineParser r = LineParser.getReader();
				int z = r.parseLine(n);

				/* aktuelle Zeile = Leerzeile */
				if (z == space) {
					this.logLine(znrS, space, n);
				}

				/* aktuelle Zeile = Documentationskommentar */
				if (z == docu) {
					this.logLine(znrS, docu, n);
					statSet.incDocu();

					while (z == comment | z == docu) // kommentarende?
					{
						n = br.readLine();
						z = r.parseLine(n);
						znr++;
						znrS = this.getLineNbrString(znr);
						if (z != comment)
							break;
						statSet.incDocu();

						this.logLine(znrS, docu, n);
					}
				}

				/* aktuelle Zeile = generierter Code */
				if (z == code && (gen)) {
					this.logLine(znrS, genCode, n);
					statSet.incGen();
				}
				if (z == code && (!gen)) {
					this.logLine(znrS, implCode, n);
					statSet.incImpl();
				}

				/* aktuelle Zeile = Kommentar */
				if (z == comment) // kommentar?
				{
					this.logLine(znrS, comment, n);
					statSet.incCom();
				}

				if(gen){
					/* aktuelle Zeile = Anfang einer protected Region */
					if (z == protRegStart) {
						this.logLine(znrS, protRegStart, n);
						statSet.incProtReg(); // protRegions = genCode
	
						while (z != protRegEnd) // Ende Protected Regions?
						{
							n = br.readLine();
							znr++;
							znrS = this.getLineNbrString(znr);
							z = r.parseLine(n);
							if (z == code) // implementierter Code?
							{
								this.logLine(znrS, implCode, n);
								statSet.incImpl();
							}
	
							if (z == docu) // dokumentation
							{
								this.logLine(znrS, docu, n);
								statSet.incDocu();
	
								while (z == comment | z == docu) // kommentarende?
								{
									n = br.readLine();
									z = r.parseLine(n);
									znr++;
									znrS = this.getLineNbrString(znr);
									if (z != comment)
										break;
									this.logLine(znrS, docu, n);
									statSet.incDocu();
								}
							}
	
							if (z == comment) // kommentar?
							{
								this.logLine(znrS, comment, n);
								statSet.incCom();
							}
	
						}
						/* Ende der protected Region */
						this.logLine(znrS, protRegEnd, n);
						statSet.incProtReg(); // protRegions = genCode
					}
				}
				
				//im manuellen/selbst impl. Verzeichnis gibt es eig keine prot. Reg
				//wenn doch, dann sind sie selbst geschrieben also nicht generiert!
				else{
					if( z == protRegStart || z == protRegEnd)
					{
						this.logLine(znrS, implCode, n);
						statSet.incImpl();
					}
				}
					
			} while (n != null);

			// -------END-PARSEN-----------------------------------------------------------------------

			/*
			 * wenn keine protRegions in der Datei enthalten sind, dann gibt es
			 * keinen generierter Code! Dann ist der ganze funktionale Code ==
			 * implementierte Code
			 */
			if (!(statSet.isGenerated() )) {
				statSet.setLinesOfImplCode(statSet.getLinesOfGenCode()
						+ statSet.getLinesOfImplCode());
				statSet.setLinesOfGenCode(0);
			}
			
			if (!(gen)) {
				statSet.setLinesOfImplCode(statSet.getLinesOfGenCode()+ statSet.getLinesOfImplCode());
				statSet.setLinesOfGenCode(0);
				statSet.setLinesOfProtReg(0);
			}

			// Augabe der Statistik:
			logger.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~FILE-STATISTIK~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
		
			//Komplete Pfadangabe:
			String path = this.getAbsolutePath().toString();
			
			if (path.length() > 80){
				String[] paths = path.substring(path.length()-80, path.length()).split("/");
				path = "";
				for(int i = 1; i<= paths.length -1; i++)
				{
					path += "/"+ paths[i];
				}
				logger.debug("\t    (..."+path+")");		
			}
			else {
				logger.debug("\t      ("+path+")");
			}
			
			logger.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
					+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
			
			
			// Statistikwerte:
			logger.debug(" \t\t" + "GenCode:" + getLinesOfGenCode() + "       "
					+ "ImpCode:" + getLinesOfImplCode() + "       "
					+ "Comments:" + getLinesOfComments() + "       " + "Docu:"
					+ getLinesOfDocu() + "       " + "All:" + getLinesOfCode()
					+ "");
			logger.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
					+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}

		catch (FileNotFoundException e) {
			// logger.error(e.getCause().toString());
			logger.error(e.getMessage().toString());
			e.printStackTrace();
		} catch (IOException ie) {
			// logger.error(ie.getCause().toString());
			logger.error(ie.getMessage().toString());
			ie.printStackTrace();
		} catch (Exception e) {
			// logger.error(e.getCause().toString());
			logger.error(e.getMessage().toString());
			e.printStackTrace();
		}

	}

	/** Rueckgabe der Anzahl an Codezeilen der Datei */
	public int getLinesOfCode() {
		return (statSet.getLinesOfCode());
	}

	/** Rueckgabe der Anzahl an Kommentarzeilen der Datei */
	public int getLinesOfComments() {
		return statSet.getLinesOfComments();
	}

	/** Rueckgabe der Anzahl an generierten Codezeilen der Datei */
	public int getLinesOfGenCode() {
		return statSet.getLinesOfGenCode();
	}

	/** Rueckgabe der Anzahl an selbst implementierten Codezeilen der Datei */
	public int getLinesOfImplCode() {
		return statSet.getLinesOfImplCode();
	}

	/** Rueckgabe der Anzahl an Dokumentarzeilen der Datei */
	public int getLinesOfDocu() {
		return statSet.getLinesOfDocu();
	}



	/**
	 * String fuer die aktuelle Zeilennummer
	 * 
	 * @param znr
	 *            zeilennummer
	 * @return zeilennummer als Zeichenkette
	 */
	public String getLineNbrString(int znr) {
		String znrS = "";

		if (znr < 100) {
			if (znr < 10) {
				znrS = "  " + new Integer(znr).toString();
			} else
				znrS = " " + new Integer(znr).toString();
		} else
			znrS = new Integer(znr).toString();

		return znrS;
	}

	/**
	 * Ausgabe der aktuellen Zeile im Logger
	 * 
	 * @param znrS
	 *            Zeilennumer als String
	 * @param lineT
	 *            Art der Codezeile
	 * @param n
	 *            die Codezeile
	 */
	public void logLine(String znrS, int lineT, String n) {
		switch (lineT) {
		case (space):
			logger.trace(signSpace + debgStr + znrS + "|" + n);
			break;
		case (docu):
			logger.trace(signDoc + debgStr + znrS + "|" + n);
			break;
		case (comment):
			logger.trace(signCom + debgStr + znrS + "|" + n);
			break;
		case (protRegStart):
			logger.trace(signProtRegS + debgStr + znrS + "|" + n);
			break;
		case (protRegEnd):
			logger.trace(signProtRegE + debgStr + znrS + "|" + n);
			break;
		case (genCode):
			logger.trace(signGen + debgStr + znrS + "|" + n);
			break;
		case (implCode):
			logger.trace(signImp + debgStr + znrS + "|" + n);
			break;
		default:
			logger.trace("?" + debgStr + znrS + "|" + n);
			break;
		}
	}
	
	/**
	 * Rueckgabe des relativen Pfades zum Ordner fuer den die stat. Werte ermitteln werden sollen
	 * 
	 * @return relativer Pfad
	 */
	public String getRelativePath()
	{
	/*	return this.getAbsolutePath().substring(0, this.getAbsolutePath().length() - 
				(this.getParent().length()+this.getName().length()));
	*/
		return this.getAbsolutePath().substring( this.getAbsolutePath().length() -
				(this.getName().length() + new File(this.getParent()).getName().length())-1
				,this.getAbsolutePath().length());
		//
	}
	
	/**
	 * Zugriff auf Speichercontainer mit den Statistikwerten
	 * 
	 * @return das Statistik Set der Datei 
	 */
	public StatisticSet getStatSet()
	{
		return statSet;
	}

}
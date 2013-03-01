package de.genesez.platforms.common.statistic;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openarchitectureware.xpand2.pr.util.GenericFileFilter;

/**
 * Verzeichnis eines Projektes
 * 
 * @author T. Hartmann ( tomha@fh-zwickau.de )
 */
public class SDirectory implements IStatistic {

	public static final String EXCLUDES = ".svn, .cvs";
	
	/** aktuelles Verzeichnis als File */
	public File dir;

	/** bool wert ob es sich um generierten Code im Verzeichniss handelt */
	boolean gen = false;

	/** Liste aller Dateien im Verzeichnis */
	public LinkedList<SFile> files = new LinkedList<SFile>();

	/** Liste aller Unterordner im aktuellen Verzeichnis */
	public Vector<SDirectory> subdirs = new Vector<SDirectory>();

	/** Logger */
	private Log logger = LogFactory.getLog(getClass());

	/** SpeicherContainer fuer die Statistikwerte */
	private StatisticSet statSet;

	/**
	 * Kontruktor mit Pfadangabe (non-gen-Code)
	 * 
	 * @param s
	 *            pfad des Verzeichnisses
	 */
	public SDirectory(String s) {
		this(s, true, EXCLUDES);
	}

	/**
	 * Kontruktor mit Pfadangabe
	 * 
	 * @param s
	 *            pfad des Verzeichnisses
	 * @param gen
	 *            generierter Code im Verzeichnis?
	 */
	public SDirectory(String s, boolean gen, String excludes) {
		dir = new File(s);
		
		// container fuer die Werte Initialisieren
		statSet = new StatisticSet();
		
		// file filter
		GenericFileFilter filter = new GenericFileFilter(excludes, false);
		
		// Unterteilen und abspeichern der Ordner und Dateien
		if (dir.isDirectory()) {
			File[] list = dir.listFiles(filter);
			for (int i = list.length - 1; i >= 0; i--) // Rueckwaertszaehlen fuers
			// Alphabetische
			// anordnen!
			{
				if (list[i].isDirectory()) // ist das File-Objekt ein
				// Verzeichnis oder eine Datei?
				{
					subdirs.add(new SDirectory(list[i].getAbsolutePath(), gen, excludes));
				} else
					files.add(new SFile(list[i].getAbsolutePath(), gen));
			}
		} else {
			// kein Verzeichnis im angegebenen Pfad?
			logger.error("kein Ordner beim angegebenen Pfad: "
					+ dir.getAbsolutePath() + "");
			System.exit(1); // beenden mit Fehler!

		}
	}

	/**
	 * Auflisten aller Dateien/Verzeichnissen des Projektordners (mit Ausgabe)
	 */
	public void showAllFiles() {
		logger.info("zu Untersuchende Dateien");
		logger.info("");
		showFiles();
		logger.info("");
	}

	/**
	 * Auflisten aller Dateien/Verzeichnissen des aktuellen Ordners
	 */
	public void showFiles() {

		// Unterverzeichnisse durchsuchen
		Iterator<SDirectory> subIt = subdirs.iterator();
		while (subIt.hasNext()) {
			// subIt.next().getAbsolutePath();

			SDirectory ssubdir = subIt.next();
			ssubdir.showFiles();
		}

		// Ausgabe der Dateien im aktuellen Verzeichniss
		Iterator<SFile> itFiles = files.iterator();
		while (itFiles.hasNext()) {
			File f = itFiles.next();
			logger.info(" " + f.getAbsolutePath());
		}
	}

	/**
	 * gibt den Absulten Pfad zurueck (von File)
	 * 
	 * @return den absoluten Pfad als String
	 */
	private String getAbsolutePath() {
		// TODO Auto-generated method stub
		return dir.getAbsolutePath();
	}

	public void parseCode() {
		Iterator<SFile> itFiles = files.iterator();

		// setzen der VerzeichnisStatistik durch addieren der Dateistatistik
		// aller Dateien im Verzeichnis
		while (itFiles.hasNext()) {
			try {
				SFile sFile = itFiles.next();
				sFile.parseCode();
				statSet.incGen(sFile.getLinesOfGenCode());
				statSet.incImpl(sFile.getLinesOfImplCode());
				statSet.incCom(sFile.getLinesOfComments());
				statSet.incDocu(sFile.getLinesOfDocu());
			} catch (Exception e) {
				logger.error("Exception aufgetreten: " + e.getMessage());
				e.printStackTrace();
			}
		}

		Iterator<SDirectory> itSubdir = subdirs.iterator();

		// setzen der VerzeichnisStatistik durch addieren der
		// Unterverzeichnisstatistiken
		while (itSubdir.hasNext()) {
			SDirectory sDir = itSubdir.next();
			sDir.parseCode();
			statSet.incGen(sDir.getLinesOfGenCode());
			statSet.incImpl(sDir.getLinesOfImplCode());
			statSet.incCom(sDir.getLinesOfComments());
			statSet.incDocu(sDir.getLinesOfDocu());
		}

		// Debug Ausgabe der Verzeichnisstatistik:
		for (int i = 0; i <= 3; i++)
			logger.debug("");
		
		logger.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~VERZEICHNIS-STATISTIK~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		// Komplete Pfadangabe:
		String path = this.getAbsolutePath().toString();

		if (path.length() > 80) {
			String[] paths = path.substring(path.length() - 80, path.length())
					.split("/");
			path = "";
			for (int i = 1; i <= paths.length - 1; i++) {
				path += "/" + paths[i];
			}
			logger.debug("\t    (..." + path + ")");
		} else {
			logger.debug("\t      (" + path + ")");
		}

		logger.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		logger.debug(" \t\t\t" + "GenCode:" + getLinesOfGenCode() + "       "
				+ "ImpCode:" + getLinesOfImplCode() + "       " + "Comments:"
				+ getLinesOfComments() + "       " + "Docu:" + getLinesOfDocu()
				+ "       " + "All:" + getLinesOfCode() + "");
		logger.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	/**
	 * Rueckgabe des Fileobjekts des aktuellen Verzeichnisses
	 * 
	 * @return Fileobjekt des Verzeichnisses
	 */
	public File getDir() {
		return dir;
	}

	/** Rueckgabe der Anzahl an Codezeilen im Verzeichnis */
	public int getLinesOfCode() {
		return (statSet.getLinesOfCode());
	}

	/** Rueckgabe der Anzahl an Kommentarzeilen im Verzeichnis */
	public int getLinesOfComments() {
		return statSet.getLinesOfComments();
	}

	/** Rueckgabe der Anzahl an generierten Codezeilen im Verzeichnis */
	public int getLinesOfGenCode() {
		return statSet.getLinesOfGenCode();
	}

	/** Rueckgabe der Anzahl an selbst implementierten Codezeilen im Verzeichnis */
	public int getLinesOfImplCode() {
		return statSet.getLinesOfImplCode();
	}

	/** Rueckgabe der Anzahl an Dokumentarzeilen im Verzeichnis */
	public int getLinesOfDocu() {
		return statSet.getLinesOfDocu();
	}

	/**
	 * gibt eine Liste mit allen Dateien des Ordners zurueck
	 * 
	 * @return Liste mit d. Dateien des Ordners
	 */
	public LinkedList<SFile> getFiles() {
		return files;
	}

	/**
	 * gibt eine Array mit dem Unterverzeichnissen zurueck
	 * 
	 * @return Array mit Unterverzeichnissen des Ordners
	 */
	public Vector<SDirectory> getSubdirs() {
		return subdirs;
	}

	/**
	 * gibt alle Dateien d. Ordners und aller Unterverzeichnisse und deren
	 * Unterverzeichnisse zurueck
	 * 
	 * @return Liste mit alen Dateien
	 */
	public LinkedList<SFile> getAllFiles() {

		LinkedList<SFile> files = new LinkedList<SFile>();

		files.addAll(getFiles());

		Iterator<SDirectory> it = subdirs.iterator();
		while (it.hasNext()) {
			files.addAll(it.next().getAllFiles());
		}

		return files;

	}

	/**
	 * Zugriff auf Speichercontainer mit den Statistikwerten
	 * 
	 * @return das Statistik Set des Verzeichnisses
	 */
	public StatisticSet getStatSet() {
		return statSet;
	}

	/**
	 * Rueckgabe des relativen Pfades
	 * 
	 * @return relativer Pfad als String
	 */
	public String getPath() {
		return dir.getPath();
	}
}

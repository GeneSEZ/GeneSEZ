package de.genesez.platforms.common.statistic;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Verzeichnis eines Projektes
 * 
 * @author T. Hartmann ( tomha@fh-zwickau.de )
 */
public class SDirectory implements IStatistic {

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

	/** SpeicherContainer für die Statistikwerte */
	private StatisticSet statSet;

	/**
	 * Kontruktor mit Pfadangabe (non-gen-Code)
	 * 
	 * @param s
	 *            pfad des Verzeichnisses
	 */
	public SDirectory(String s) {
		new SDirectory(s, true);
	}

	/**
	 * Kontruktor mit Pfadangabe
	 * 
	 * @param s
	 *            pfad des Verzeichnisses
	 * @param gen
	 *            generierter Code im Verzeichnis?
	 */
	public SDirectory(String s, boolean gen) {
		dir = new File(s);

		// container für die Werte Initialisieren
		statSet = new StatisticSet();

		// Unterteilen und abspeichern der Ordner und Dateien
		if (dir.isDirectory()) {
			File[] list = dir.listFiles();
			for (int i = list.length - 1; i >= 0; i--) // Rückwärtszählen fürs
			// Alphabetische
			// anordnen!
			{
				if (list[i].isDirectory()) // ist das File-Objekt ein
				// Verzeichnis oder eine Datei?
				{
					subdirs.add(new SDirectory(list[i].getAbsolutePath(), gen));
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
	 * gibt den Absulten Pfad zurück (von File)
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
	 * Rückgabe des Fileobjekts des aktuellen Verzeichnisses
	 * 
	 * @return Fileobjekt des Verzeichnisses
	 */
	public File getDir() {
		return dir;
	}

	/** Rückgabe der Anzahl an Codezeilen im Verzeichnis */
	public int getLinesOfCode() {
		return (statSet.getLinesOfCode());
	}

	/** Rückgabe der Anzahl an Kommentarzeilen im Verzeichnis */
	public int getLinesOfComments() {
		return statSet.getLinesOfComments();
	}

	/** Rückgabe der Anzahl an generierten Codezeilen im Verzeichnis */
	public int getLinesOfGenCode() {
		return statSet.getLinesOfGenCode();
	}

	/** Rückgabe der Anzahl an selbst implementierten Codezeilen im Verzeichnis */
	public int getLinesOfImplCode() {
		return statSet.getLinesOfImplCode();
	}

	/** Rückgabe der Anzahl an Dokumentarzeilen im Verzeichnis */
	public int getLinesOfDocu() {
		return statSet.getLinesOfDocu();
	}

	/**
	 * gibt eine Liste mit allen Dateien des Ordners zurück
	 * 
	 * @return Liste mit d. Dateien des Ordners
	 */
	public LinkedList<SFile> getFiles() {
		return files;
	}

	/**
	 * gibt eine Array mit dem Unterverzeichnissen zurück
	 * 
	 * @return Array mit Unterverzeichnissen des Ordners
	 */
	public Vector<SDirectory> getSubdirs() {
		return subdirs;
	}

	/**
	 * gibt alle Dateien d. Ordners und aller Unterverzeichnisse und deren
	 * Unterverzeichnisse zurück
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
	 * Rückgabe des relativen Pfades
	 * 
	 * @return relativer Pfad als String
	 */
	public String getPath() {
		return dir.getPath();
	}

}
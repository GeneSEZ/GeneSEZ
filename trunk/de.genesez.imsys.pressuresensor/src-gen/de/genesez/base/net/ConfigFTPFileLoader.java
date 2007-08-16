package de.genesez.base.net;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1185115357700_382500_709) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.io.IOException;

import java.lang.String;

import de.genesez.imsys.conf.Configurator;
import de.genesez.imsys.net.FTPLoader;

/* <!-- PROTECTED REGION END --> */
/**
 * @author nicher
 */
public class ConfigFTPFileLoader extends FTPLoader implements Runnable {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * variable
     */
    private long autoDownloadCycleTime = 86400000;

    /**
     * variable
     */
    private boolean autoDownLoadStop = false;

    /**
     * variable
     */
    private String ftpFile = "config.txt";

    /**
     */
    private Thread runner;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  host
     * @param  port
     * @param  userName
     * @param  passWord
     */
    public ConfigFTPFileLoader(String host, int port, String userName,
        String passWord) {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185115718034_872414_759) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        super(host, port, userName, passWord);

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated attribute derived method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated association method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated abstract method declaration
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated normal method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     */
    public void autoDownload() {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185197427492_723109_1104) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        runner = new Thread(this);
        runner.start();

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     */
    public void run() {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.threadrun.code._12_5_8a7027a_1185115357700_382500_709) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        synchronized (this) {
            while (!autoDownLoadStop) {
                try {
                    // open the ftp connection
                    open();
                    // download the configuration file from ftp
                    // and store it in the config directory
                    // close the ftp connection
                    download(ftpFile, Configurator.getConfigFile());
                    close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                try {
                    Thread.sleep(autoDownloadCycleTime);
                } catch (InterruptedException e) {
                }
            }
        }

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for attribute autoDownloadCycleTime
     */
    public long getAutoDownloadCycleTime() {
        return autoDownloadCycleTime;
    }

    /**
     * accessor for attribute autoDownloadCycleTime
     */
    public void setAutoDownloadCycleTime(long _autoDownloadCycleTime) {
        autoDownloadCycleTime = _autoDownloadCycleTime;
    }

    /**
     * accessor for attribute autoDownLoadStop
     */
    public boolean getAutoDownLoadStop() {
        return autoDownLoadStop;
    }

    /**
     * accessor for attribute autoDownLoadStop
     */
    public void setAutoDownLoadStop(boolean _autoDownLoadStop) {
        autoDownLoadStop = _autoDownLoadStop;
    }

    /**
     * accessor for attribute ftpFile
     */
    public String getFtpFile() {
        return ftpFile;
    }

    /**
     * accessor for attribute ftpFile
     */
    public void setFtpFile(String _ftpFile) {
        ftpFile = _ftpFile;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1185115357700_382500_709) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}

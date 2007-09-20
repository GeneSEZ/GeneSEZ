package de.genesez.imsys.net;


/* PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1185482037977_264407_642) ENABLED START */
/* TODO put your imports here */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.lang.String;

import se.imsys.net.FtpClient;
import se.imsys.net.FtpFile;

/* PROTECTED REGION END */
/**
 * This class implements an FTP client, following the specifications in RFC 959 - File Transfer Protocol.
 * @author nicher
 */
public class FTPLoader {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * variable
     */
    private String host;

    /**
     * variable
     */
    private int port;

    /**
     * variable
     */
    private String userName;

    /**
     * variable
     */
    private String passWord;

    /**
     * variable for association to ftpClient
     */
    private FtpClient ftpClient;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  host
     * @param  port
     * @param  userName
     * @param  passWord
     */
    public FTPLoader(String host, int port, String userName, String passWord) {
        /* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185482236292_798682_785) ENABLED START */
        /* TODO put your own implementation code here */
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.passWord = passWord;

        /* PROTECTED REGION END */
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
     * Open the ftp connection.
     * @throws  IOException
     */
    public void open() throws IOException {
        /* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185482153897_606143_765) ENABLED START */
        /* TODO put your own implementation code here */
        ftpClient = new FtpClient(host, port, userName, passWord);

        /* PROTECTED REGION END */
    }

    /**
     * Close the ftp connection.
     * @throws  IOException
     */
    public void close() throws IOException {
        /* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185482159517_960344_769) ENABLED START */
        /* TODO put your own implementation code here */
        ftpClient.close();

        /* PROTECTED REGION END */
    }

    /**
     * Download a ftp file and store it local.
     * @param  ftpFile
     * @param  localFile
     * @throws  IOException
     */
    public void download(String ftpFile, String localFile) throws IOException {

        /* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185482167676_936413_773) ENABLED START */
        /* TODO put your own implementation code here */
        FtpFile ff = ftpClient.get(ftpFile);
        if (ff == null) {
            throw (new IOException("no such file"));
        }

        byte[] b = new byte[ff.getSize()];
        b = ff.getData();

        FileOutputStream fos = new FileOutputStream(localFile);
        fos.write(b);
        fos.close();

        /* PROTECTED REGION END */
    }

    /**
     * Upload a local file by ftp.
     * @param  localFile
     * @param  ftpFile
     * @throws  IOException
     */
    public void upload(String localFile, String ftpFile) throws IOException {

        /* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185482194494_355974_778) ENABLED START */
        /* TODO put your own implementation code here */
        FileInputStream fis = new FileInputStream(localFile);
        byte[] b = new byte[fis.available()];
        fis.read(b);
        fis.close();

        FtpFile ff = new FtpFile(ftpFile, FtpFile.FILE, b.length);
        if (ff == null) {
            throw (new IOException("no such file"));
        }

        ff.setData(b);
        ftpClient.put(ff);

        /* PROTECTED REGION END */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for attribute host
     */
    public String getHost() {
        return host;
    }

    /**
     * accessor for attribute host
     */
    public void setHost(String _host) {
        host = _host;
    }

    /**
     * accessor for attribute port
     */
    public int getPort() {
        return port;
    }

    /**
     * accessor for attribute port
     */
    public void setPort(int _port) {
        port = _port;
    }

    /**
     * accessor for attribute userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * accessor for attribute userName
     */
    public void setUserName(String _userName) {
        userName = _userName;
    }

    /**
     * accessor for attribute passWord
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * accessor for attribute passWord
     */
    public void setPassWord(String _passWord) {
        passWord = _passWord;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1185482037977_264407_642) ENABLED START */
    /* TODO put your own implementation code here */

    /* PROTECTED REGION END */
}

package de.genesez.imsys.net;


/* PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184944505566_991228_701) ENABLED START */
/* TODO put your imports here */
import java.lang.String;

import se.imsys.net.Email;
import se.imsys.net.SmtpClient;
import se.imsys.net.SmtpException;

/* PROTECTED REGION END */
/**
 * @author nicher
 */
public class SMTPMailer implements ISMTPMailer, Runnable {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     */
    private Thread runner;

    /**
     * variable for association to smtpClient
     */
    private SmtpClient smtpClient;

    /**
     * variable for association to eMail
     */
    private Email eMail;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  domain
     * @param  server
     */
    public SMTPMailer(String domain, String server) {
        /* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185019603143_328147_1045) ENABLED START */
        /* TODO put your own implementation code here */
        smtpClient = new SmtpClient(domain, server);

        /* PROTECTED REGION END */
    }

    /**
     * @param  domain
     * @param  server
     * @param  port
     * @param  userName
     * @param  passWord
     */
    public SMTPMailer(String domain, String server, int port, String userName,
        String passWord) {
        /* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185019028417_73961_1019) ENABLED START */
        /* TODO put your own implementation code here */
        this(domain, server);
        smtpClient.setPort(port);
        smtpClient.setLogin(userName);
        smtpClient.setPassword(passWord);

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
     * @param  eMail
     */
    public void sendMail(Email eMail) {
        /* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185018419499_350927_693) ENABLED START */
        /* TODO put your own implementation code here */
        this.eMail = eMail;

        runner = new Thread(this);
        runner.start();

        /* PROTECTED REGION END */
    }

    /**
     */
    public void run() {

        /* PROTECTED REGION ID(java.moperation.implementation.threadrun.code._12_5_8a7027a_1184944505566_991228_701) ENABLED START */
        /* TODO put your own implementation code here */
        synchronized (this) {
            try {
                smtpClient.send(eMail);
            } catch (SmtpException e) {
                System.out.println(e.getMessage());
            }
        }

        /* PROTECTED REGION END */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184944505566_991228_701) ENABLED START */
    /* TODO put your own implementation code here */

    /* PROTECTED REGION END */
}

package de.genesez.imsys.net;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184944458206_482942_675) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

import se.imsys.net.Email;

/* <!-- PROTECTED REGION END --> */
/**
 * This interface contains all methods to send mails by the smtp service  over the tcp/ip protocol.
 * @author nicher
 */
public interface ISMTPMailer {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable and constant declarations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated association method declarations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated abstract method declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @return
     */
    public abstract String getDomain();

    /**
     * @param  domain
     */
    public abstract void setDomain(String domain);

    /**
     * @return
     */
    public abstract String getServer();

    /**
     * @param  server
     */
    public abstract void setServer(String server);

    /**
     * @return
     */
    public abstract int getPort();

    /**
     * @param  port
     */
    public abstract void setPort(int port);

    /**
     * @return
     */
    public abstract String getUserName();

    /**
     * @param  userName
     */
    public abstract void setUserName(String userName);

    /**
     * @return
     */
    public abstract String getPassWord();

    /**
     * @param  passWord
     */
    public abstract void setPassWord(String passWord);

    /**
     * Send the mail.
     * @param  smtpMail
     */
    public abstract void sendMail(Email smtpMail);

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184944458206_482942_675) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}

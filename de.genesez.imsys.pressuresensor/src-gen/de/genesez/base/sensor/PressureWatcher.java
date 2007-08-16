package de.genesez.base.sensor;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1185627683353_829337_549) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.io.IOException;

import de.genesez.base.ConfigParameter;
import de.genesez.imsys.net.ISMTPMailer;
import de.genesez.imsys.net.TcpIpSocket;
import de.genesez.imsys.sensor.MeasureEvent;
import de.genesez.imsys.system.Mailbox;
import de.genesez.imsys.util.DateFormatter;

import se.imsys.net.Email;

/* <!-- PROTECTED REGION END --> */
/**
 * Listener which is interested in preasure sensor events.
 * @author nicher
 */
public class PressureWatcher implements Runnable {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * variable
     */
    private boolean autoSendingStop = false;

    /**
     * variable
     */
    private int autoSendingCycleTime = 10000;

    /**
     */
    private Thread runner;

    /**
     * variable for association to socket
     */
    private TcpIpSocket socket;

    /**
     * variable for association to mailbox
     */
    private Mailbox mailbox;

    /**
     * variable for association to mailer
     */
    private ISMTPMailer mailer;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  mailbox
     * @param  socket
     * @param  mailer
     */
    public PressureWatcher(Mailbox mailbox, TcpIpSocket socket,
        ISMTPMailer mailer) {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185627716667_538887_575) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        this.mailbox = mailbox;
        this.socket = socket;
        this.mailer = mailer;

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated attribute derived method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated association method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for association to socket
     */
    public TcpIpSocket getSocket() {
        return socket;
    }

    /**
     * accessor for association to socket
     */
    public void insertInSocket(TcpIpSocket _in) {
        if (socket == _in) {
            return;
        }
        socket = _in;
    }

    /**
     * accessor for association to socket
     */
    public void removeFromSocket(TcpIpSocket _ex) {
        if (socket != _ex) {
            return;
        }
        socket = null;
    }

    /**
     * accessor for association to mailbox
     */
    public Mailbox getMailbox() {
        return mailbox;
    }

    /**
     * accessor for association to mailbox
     */
    public void insertInMailbox(Mailbox _in) {
        if (mailbox == _in) {
            return;
        }
        mailbox = _in;
    }

    /**
     * accessor for association to mailbox
     */
    public void removeFromMailbox(Mailbox _ex) {
        if (mailbox != _ex) {
            return;
        }
        mailbox = null;
    }

    /**
     * accessor for association to mailer
     */
    public ISMTPMailer getMailer() {
        return mailer;
    }

    /**
     * accessor for association to mailer
     */
    public void insertInMailer(ISMTPMailer _in) {
        if (mailer == _in) {
            return;
        }
        mailer = _in;
    }

    /**
     * accessor for association to mailer
     */
    public void removeFromMailer(ISMTPMailer _ex) {
        if (mailer != _ex) {
            return;
        }
        mailer = null;
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated abstract method declaration
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated normal method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     */
    public void autoSending() {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185630686443_675808_743) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        runner = new Thread(this);
        runner.start();

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     * @param  e
     */
    public void addPressureValue(MeasureEvent e) {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185645360153_389597_875) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        synchronized (mailbox) {
            mailbox.setValue(DateFormatter.getUTCFormat(e.getTimeStamp()) +
                " " + e.getMeasureValue());
            mailbox.notifyAll();
        }

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     */
    public void run() {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.threadrun.code._12_5_8a7027a_1185627683353_829337_549) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        boolean isSocket = true;

        try {
            socket.open();
        } catch (IOException e) {
            isSocket = false;
        }

        while (!autoSendingStop) {
            synchronized (mailbox) {

                // if no message is in the mailbox, then
                // the this thread waits until a message 
                // is in the mailbox
                if (mailbox.getValue() == null) {
                    try {
                        mailbox.wait();
                    } catch (InterruptedException e) {
                    }
                }

                // if the socket connection is ready, 
                // then the message will be send by 
                // socket else by mail
                if (isSocket) {
                    try {
                        socket.write(mailbox.getValue());
                        mailbox.setValue(null);
                    } catch (IOException e) {
                        isSocket = false;
                    }
                } else {
                    Email mail = new Email();
                    mail.setFrom(ConfigParameter.getEMAIL_FROM());
                    mail.setTo(ConfigParameter.getEMAIL_TO());
                    mail.setSubject("PressureSensor");
                    mail.setMessage(mailbox.getValue());
                    mailer.sendMail(mail);
                }
            }
        }

        try {
            if (isSocket) {
                socket.close();
            }
        } catch (IOException e) {
            isSocket = false;
        }

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for attribute autoSendingStop
     */
    public boolean getAutoSendingStop() {
        return autoSendingStop;
    }

    /**
     * accessor for attribute autoSendingStop
     */
    public void setAutoSendingStop(boolean _autoSendingStop) {
        autoSendingStop = _autoSendingStop;
    }

    /**
     * accessor for attribute autoSendingCycleTime
     */
    public int getAutoSendingCycleTime() {
        return autoSendingCycleTime;
    }

    /**
     * accessor for attribute autoSendingCycleTime
     */
    public void setAutoSendingCycleTime(int _autoSendingCycleTime) {
        autoSendingCycleTime = _autoSendingCycleTime;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1185627683353_829337_549) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}

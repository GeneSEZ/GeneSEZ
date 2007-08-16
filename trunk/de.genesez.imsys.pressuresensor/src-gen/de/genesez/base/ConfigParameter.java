package de.genesez.base;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1185483878862_479900_1008) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

import de.genesez.imsys.conf.Configurator;
import de.genesez.imsys.conf.ConfiguratorException;

/* <!-- PROTECTED REGION END --> */
/**
 * Reads the configuration parameters. If an error happend then the default values will be used.
 * @author nicher
 */
public class ConfigParameter {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * variable
     */
    private static final int PS_CYCLETIME = 10000;

    /**
     * variable
     */
    private static final int PS_MIN = 30;

    /**
     * variable
     */
    private static final int PS_MAX = 60;

    /**
     * variable
     */
    private static final String SMTP_DOMAIN = "fh-zwickau.de";

    /**
     * variable
     */
    private static final String SMTP_SERVER = "mailhost.fh-zwickau.de";

    /**
     * variable
     */
    private static final int SMTP_PORT = 25;

    /**
     * variable
     */
    private static final String SMTP_USERNAME = null;

    /**
     * variable
     */
    private static final String SMTP_PASSWORD = null;

    /**
     * variable
     */
    private static final String EMAIL_FROM = "nihe@fh-zwickau.de";

    /**
     * variable
     */
    private static final String EMAIL_TO = "nihe@fh-zwickau.de";

    /**
     * variable
     */
    private static final String FTP_SERVER = "ftp.nico-herbig.de";

    /**
     * variable
     */
    private static final int FTP_PORT = 21;

    /**
     * variable
     */
    private static final String FTP_USERNAME = "";

    /**
     * variable
     */
    private static final String FTP_PASSWORD = "";

    /**
     * variable
     */
    private static final String FTP_CONFIGFILE = "config.txt";

    /**
     * variable
     */
    private static final String SO_SERVER = "141.32.28.64";

    /**
     * variable
     */
    private static final int SO_PORT = 7777;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

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
     * @return
     */
    public static int getPS_CYCLETIME() {
        int returnValue = 0;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484423455_517247_1100) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = Integer.parseInt(getConfigValue("PS_CYCLETIME"));
        } catch (ConfiguratorException e) {
            System.out.println(e.getMessage());
            returnValue = PS_CYCLETIME;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static int getPS_MIN() {
        int returnValue = 0;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484436498_365836_1104) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = Integer.parseInt(getConfigValue("PS_MIN"));
        } catch (ConfiguratorException e) {
            returnValue = PS_MIN;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static int getPS_MAX() {
        int returnValue = 0;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484442744_105535_1108) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = Integer.parseInt(getConfigValue("PS_MAX"));
        } catch (ConfiguratorException e) {
            returnValue = PS_MAX;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static String getSMTP_DOMAIN() {
        String returnValue = null;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484449167_578558_1112) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = getConfigValue("SMTP_DOMAIN");
        } catch (ConfiguratorException e) {
            returnValue = SMTP_DOMAIN;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static String getSMTP_SERVER() {
        String returnValue = null;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484462059_569005_1116) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = getConfigValue("SMTP_SERVER");
        } catch (ConfiguratorException e) {
            returnValue = SMTP_SERVER;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static int getSMTP_PORT() {
        int returnValue = 0;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484472084_937994_1120) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = Integer.parseInt(getConfigValue("SMTP_PORT"));
        } catch (ConfiguratorException e) {
            returnValue = SMTP_PORT;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static String getSMTP_USERNAME() {
        String returnValue = null;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484481732_130309_1124) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = getConfigValue("SMTP_USERNAME");
        } catch (ConfiguratorException e) {
            returnValue = SMTP_USERNAME;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static String getSMTP_PASSWORD() {
        String returnValue = null;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484494282_494030_1128) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = getConfigValue("SMTP_PASSWORD");
        } catch (ConfiguratorException e) {
            returnValue = SMTP_PASSWORD;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static String getEMAIL_FROM() {
        String returnValue = null;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484504599_222719_1132) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = getConfigValue("EMAIL_FROM");
        } catch (ConfiguratorException e) {
            returnValue = EMAIL_FROM;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static String getEMAIL_TO() {
        String returnValue = null;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484527835_629192_1136) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = getConfigValue("EMAIL_TO");
        } catch (ConfiguratorException e) {
            returnValue = EMAIL_TO;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static String getFTP_SERVER() {
        String returnValue = null;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484534595_890553_1140) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = getConfigValue("FTP_SERVER");
        } catch (ConfiguratorException e) {
            returnValue = FTP_SERVER;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static int getFTP_PORT() {
        int returnValue = 0;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484543517_366080_1144) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = Integer.parseInt(getConfigValue("FTP_PORT"));
        } catch (ConfiguratorException e) {
            returnValue = FTP_PORT;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static String getFTP_USERNAME() {
        String returnValue = null;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484551678_82723_1148) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = getConfigValue("FTP_USERNAME");
        } catch (ConfiguratorException e) {
            returnValue = FTP_USERNAME;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static String getFTP_PASSWORT() {
        String returnValue = null;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484562432_7384_1152) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = getConfigValue("FTP_PASSWORD");
        } catch (ConfiguratorException e) {
            returnValue = FTP_PASSWORD;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static String getFTP_CONFIGFILE() {
        String returnValue = null;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484571087_280816_1156) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = getConfigValue("FTP_CONFIGFILE");
        } catch (ConfiguratorException e) {
            returnValue = FTP_CONFIGFILE;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static String getSO_SERVER() {
        String returnValue = null;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185795379511_604414_492) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = getConfigValue("SO_SERVER");
        } catch (ConfiguratorException e) {
            returnValue = SO_SERVER;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @return
     */
    public static int getSO_PORT() {
        int returnValue = 0;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185795387558_763172_496) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            returnValue = Integer.parseInt(getConfigValue("SO_PORT"));
        } catch (ConfiguratorException e) {
            returnValue = SO_PORT;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @param  key
     * @return
     * @throws  ConfiguratorException  Exception which throws by an configuration error.
     */
    private static String getConfigValue(String key)
        throws ConfiguratorException {
        String returnValue = null;
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185484821592_674886_1160) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        returnValue = Configurator.getValue(key);

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1185483878862_479900_1008) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}

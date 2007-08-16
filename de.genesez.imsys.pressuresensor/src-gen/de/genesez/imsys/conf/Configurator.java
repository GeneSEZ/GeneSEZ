package de.genesez.imsys.conf;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1185118181164_31989_509) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.lang.String;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;

/* <!-- PROTECTED REGION END --> */
/**
 * This class read and write the configuration file.
 * @author nicher
 */
public class Configurator {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * variable
     * @see {@link getConfigFile}
     */
    private static String configFile = "config/config.txt";

    /**
     * variable
     * @see {@link getKeyVal}
     */
    private static Hashtable keyVal;

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
     * Read all configuration parameter to the keyval table.
     * @throws  ConfiguratorException  Exception which throws by an configuration error.
     */
    private static void readConfigFile() throws ConfiguratorException {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185118217981_951644_531) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        keyVal = new Hashtable();
        byte[] b = new byte[0];

        try {
            FileInputStream fis = new FileInputStream(configFile);
            b = new byte[fis.available()];
            fis.read(b);
            fis.close();
        } catch (IOException e) {
            throw new ConfiguratorException(e.getMessage());
        }

        StringTokenizer st = new StringTokenizer(new String(b), "\n");

        while (st.hasMoreTokens()) {
            String kv = st.nextToken().trim();
            if (!kv.equals("")) {
                String key = kv.substring(0, kv.indexOf("="));
                String value = kv.substring(kv.indexOf("=") + 1);
                keyVal.put(key, value);
            }
        }

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     * Write all configuration parameter form the keyval table to the configuration file.
     * @throws  ConfiguratorException  Exception which throws by an configuration error.
     */
    private static void writeConfigFile() throws ConfiguratorException {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185118225780_782542_539) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            FileOutputStream fos = new FileOutputStream(configFile);

            String str = "";
            Enumeration it = keyVal.keys();
            while (it.hasMoreElements()) {
                String key = (String) it.nextElement();
                String value = (String) keyVal.get(key);
                str += key + "=" + value + "\n";
            }
            fos.write(str.getBytes());
            fos.close();
        } catch (IOException e) {
            throw new ConfiguratorException(e.getMessage());
        }

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     * Add a configuration parameter to the config file.
     * @param  key
     * @param  value
     * @return
     * @throws  ConfiguratorException  Exception which throws by an configuration error.
     */
    public static boolean addParameter(String key, String value)
        throws ConfiguratorException {
        boolean returnValue = false;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185118232168_662846_543) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            readConfigFile();
            if (!keyVal.containsKey(key)) {
                keyVal.put(key, value);
                returnValue = true;
            } else {
                returnValue = false;
            }
            writeConfigFile();
        } catch (NullPointerException e) {
            throw new ConfiguratorException(e.getMessage());
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * Update a parameter in the configuration file.
     * @param  key
     * @param  value
     * @return
     * @throws  ConfiguratorException  Exception which throws by an configuration error.
     */
    public static boolean updateParameter(String key, String value)
        throws ConfiguratorException {
        boolean returnValue = false;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185179130903_308086_503) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            readConfigFile();
            if (keyVal.containsKey(key)) {
                keyVal.put(key, value);
                returnValue = true;
            } else {
                returnValue = false;
            }
            writeConfigFile();
        } catch (NullPointerException e) {
            throw new ConfiguratorException(e.getMessage());
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * remove a parameter form the configuration file.
     * @param  key
     * @return
     * @throws  ConfiguratorException  Exception which throws by an configuration error.
     */
    public static boolean removeParameter(String key)
        throws ConfiguratorException {
        boolean returnValue = false;
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185118257015_73441_548) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        readConfigFile();
        if (keyVal.remove(key) != null) {
            returnValue = true;
        } else {
            returnValue = false;
        }
        writeConfigFile();

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * Get a value by a key.
     * @param  key
     * @return
     * @throws  ConfiguratorException  Exception which throws by an configuration error.
     */
    public static String getValue(String key) throws ConfiguratorException {
        String returnValue = null;
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185118311184_318761_558) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        readConfigFile();

        returnValue = (String) keyVal.get(key);

        if (returnValue.equals("NULL")) {
            returnValue = null;
        } else if (returnValue == null) {
            throw new ConfiguratorException(
                "Key not found in HashTable keyVal.");
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     */
    public static void main(String[] args) {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.staticmain.code._12_5_8a7027a_1185118181164_31989_509) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        try {
            System.out.println(getValue("PS_CYCLETIME"));
        } catch (ConfiguratorException e) {
            System.out.println(e.toString());
        }

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for attribute configFile
     * Link to the config file.
     */
    public static String getConfigFile() {
        return configFile;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1185118181164_31989_509) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}

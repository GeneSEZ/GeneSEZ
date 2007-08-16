package de.genesez.imsys.net;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1185389215755_762230_877) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* <!-- PROTECTED REGION END --> */
/**
 * This class reads messages form the other maschine
 * @author nicher
 */
public class SocketReader {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * variable for association to reader
     * @see {@link getReader}
     */
    private BufferedReader reader;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  inputStream
     */
    public SocketReader(InputStream inputStream) {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185389637960_515186_1086) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        reader = new BufferedReader(new InputStreamReader(inputStream));

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
     * Close the reader.
     * @throws  IOException
     */
    public void close() throws IOException {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185389755707_159402_1092) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        reader.close();

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     * Read a line form the stream.
     * @throws  IOException
     */
    public void readLine() throws IOException {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185786708809_341069_720) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        String str = reader.readLine();

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1185389215755_762230_877) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}

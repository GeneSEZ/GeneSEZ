package de.genesez.imsys.net;


/* PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1185389191164_683799_848) ENABLED START */
/* TODO put your imports here */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* PROTECTED REGION END */
/**
 * This class write messages to the other maschine.
 * @author nicher
 */
public class SocketWriter {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * variable for association to writer
     * @see {@link getWriter}
     */
    private BufferedWriter writer;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  outputStream
     */
    public SocketWriter(OutputStream outputStream) {
        /* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185389707082_297982_1089) ENABLED START */
        /* TODO put your own implementation code here */
        writer = new BufferedWriter(new OutputStreamWriter(outputStream));

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
     * Close the writer.
     * @throws  IOException
     */
    public void close() throws IOException {
        /* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185389768747_957428_1096) ENABLED START */
        /* TODO put your own implementation code here */
        writer.close();

        /* PROTECTED REGION END */
    }

    /**
     * Write a message to the stream.
     * @param  str
     * @throws  IOException
     */
    public void write(String str) throws IOException {
        /* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185628062784_763994_594) ENABLED START */
        /* TODO put your own implementation code here */
        writer.write(str);
        writer.newLine();
        writer.flush();

        /* PROTECTED REGION END */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1185389191164_683799_848) ENABLED START */
    /* TODO put your own implementation code here */

    /* PROTECTED REGION END */
}

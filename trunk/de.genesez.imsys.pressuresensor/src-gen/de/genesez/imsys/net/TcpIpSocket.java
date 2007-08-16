package de.genesez.imsys.net;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1185388034362_849599_466) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.io.IOException;

import java.lang.String;

import java.net.Socket;

/* <!-- PROTECTED REGION END --> */
/**
 * This class implements a client socket. A socket is an endpoint for communication between two machines.
 * @author nicher
 */
public class TcpIpSocket {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * variable
     * @see {@link getAddress}
     */
    private String address;

    /**
     * variable
     * @see {@link getPort}
     */
    private int port;

    /**
     * variable for association to server
     * @see {@link getServer}
     */
    private Socket server;

    /**
     * variable for association to reader
     * @see {@link getReader}
     */
    private SocketReader reader;

    /**
     * variable for association to writer
     * @see {@link getWriter}
     */
    private SocketWriter writer;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * Create a new TCP/IP socket.
     * @param  address
     * @param  port
     */
    public TcpIpSocket(String address, int port) {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185388542727_468457_804) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        this.address = address;
        this.port = port;

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
     * Create a new socket by address and port and create also a writer to wirte messages over socket and a reader witch reads messages form socket.
     * @throws  IOException
     */
    public void open() throws IOException {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185434979537_159417_702) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        if (address == null || port <= 0) {
            throw new IOException("Host or port not initialized");
        }
        server = new Socket(address, port);
        reader = new SocketReader(server.getInputStream());
        writer = new SocketWriter(server.getOutputStream());

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     * Close the in- and output streams and the socket.
     * @throws  IOException
     */
    public void close() throws IOException {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185392319195_711499_1236) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        reader.close();
        writer.close();
        server.close();

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     * Refer the message to the writer.
     * @param  str
     * @throws  IOException
     */
    public void write(String str) throws IOException {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185627850372_132998_830) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        writer.write(str);

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for attribute address
     * Address of the other maschine.
     */
    public String getAddress() {
        return address;
    }

    /**
     * accessor for attribute address
     * @see {@link getAddress}
     */
    public void setAddress(String _address) {
        address = _address;
    }

    /**
     * accessor for attribute port
     * Pot of the other maschine.
     */
    public int getPort() {
        return port;
    }

    /**
     * accessor for attribute port
     * @see {@link getPort}
     */
    public void setPort(int _port) {
        port = _port;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1185388034362_849599_466) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}

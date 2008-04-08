

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Base class for socket server implementations.
 * @author georg nicher
 */
public class BasicServer {

	private int port;

	private ServerSocket serverSocket = null;


	/**
	 * constructor
	 * @param portNummer
	 * @throws IOException
	 */
	public BasicServer(int portNummer) throws IOException {
		port = portNummer;
	}

	/**
	 * starts the server
	 * @throws IOException
	 */
	public void start() throws IOException {
		if (port <= 0)
			throw new IOException("Illegal port number");
		serverSocket = new ServerSocket(port);
		run();
	}

	/**
	 * listens to server socket and spawns new thread for every new client
	 * 
	 * @throws IOException
	 */
	protected void run() throws IOException {
		Socket client;
		
		while (true) {
			System.out.println("Wait for connections");
			// waiting for client
			client = serverSocket.accept();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while (true) {
				String msg = reader.readLine();
				if (msg == null) {
					break;
				} else {
					System.out.println(msg);
				}
			}
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BasicServer server = new BasicServer(7777);
			server.start();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}

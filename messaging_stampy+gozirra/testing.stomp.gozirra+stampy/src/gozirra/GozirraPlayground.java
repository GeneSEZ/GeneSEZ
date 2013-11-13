package gozirra;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.login.LoginException;

import net.ser1.stomp.Client;
import net.ser1.stomp.Listener;
import net.ser1.stomp.Server;

public class GozirraPlayground {
	
	public static void main(String[] args) {
		try {
			// the server is just middleware - it can run everywhere
			Server server = new Server(12345);
			Thread.yield();
			
			// all communication partners are clients
			Client client1 = new Client("localhost", 12345, null, null);
			Client client2 = new Client("localhost", 12345, null, null);
			Client client3 = new Client("localhost", 12345, null, null);
			
			System.out.println(client1.isConnected());
			System.out.println(client2.isConnected());
			
			// client 1 is consumer of messages
			client1.subscribe("/validation", new Listener() {
				
				@Override
				public void message(Map headers, String body) {
					System.out.println("client1 receives: " + body);
				}
			});
			Thread.sleep(200);
			
			// client 3 is consumer of messages
			client3.subscribe("/validation", new Listener() {
				
				@Override
				public void message(Map headers, String body) {
					System.out.println("client3 receives: " + body);
				}
			});
			Thread.sleep(200);
			
			// client 2 produces messages
			client2.send("/validation", "huhu");
			Thread.sleep(200);
			
			System.in.read(new byte[10]);
			
			client2.send("/validation", "hello again");
			Thread.sleep(200);
			
			// leave threads some time to receive the messages
			Thread.sleep(500);
			
			client1.disconnect();
			System.out.println(client1.isConnected());
			
			// somehow does not work :(
			server.close(12345);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LoginException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

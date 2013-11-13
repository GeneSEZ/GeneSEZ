package stampy;

import asia.stampy.client.message.connect.ConnectMessage;
import asia.stampy.client.message.disconnect.DisconnectMessage;
import asia.stampy.client.message.subscribe.SubscribeMessage;
import stampy.StampyPlayground.Client;

public class Consumer {
	
	public static void main(String[] args) {
		try {
			Client consumer = new Client();
			consumer.gateway.connect();
			
			// connect is just a raw connect, no stampy connect...
			ConnectMessage cm = new ConnectMessage("localhost");
			consumer.gateway.broadcastMessage(cm);
			
			System.in.read(new byte[10]);
			
			SubscribeMessage subscribe = new SubscribeMessage("/validation", "test");
			consumer.gateway.broadcastMessage(subscribe);
			
			System.in.read(new byte[10]);
			
			DisconnectMessage dm = new DisconnectMessage();
			consumer.gateway.broadcastMessage(dm);
			
			System.in.read(new byte[10]);
			
			consumer.gateway.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

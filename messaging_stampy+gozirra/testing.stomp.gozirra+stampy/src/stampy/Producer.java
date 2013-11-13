package stampy;

import asia.stampy.client.message.connect.ConnectMessage;
import asia.stampy.client.message.disconnect.DisconnectMessage;
import asia.stampy.client.message.send.SendMessage;
import stampy.StampyPlayground.Client;

public class Producer {

	public static void main(String[] args) {
		try {
			Client producer = new Client();
			producer.gateway.connect();
			
			// connect is just a raw connect, no stampy connect...
			ConnectMessage cm = new ConnectMessage("localhost");
			producer.gateway.broadcastMessage(cm);
			
			System.in.read(new byte[10]);
			
			// send a message
			SendMessage sm = new SendMessage("/validation", null);
			sm.setBody("the message body");
			producer.gateway.broadcastMessage(sm);
			
			System.in.read(new byte[10]);
			
			DisconnectMessage dm = new DisconnectMessage();
			producer.gateway.broadcastMessage(dm);
			
			System.in.read(new byte[10]);
			producer.gateway.shutdown();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

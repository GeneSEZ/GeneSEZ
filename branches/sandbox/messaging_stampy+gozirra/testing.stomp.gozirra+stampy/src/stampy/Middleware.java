package stampy;

import asia.stampy.server.message.message.MessageMessage;
import stampy.StampyPlayground.Server;

public class Middleware {
	
	public static void main(String[] args) {
		Server server = new Server();
		try {
			server.gateway.connect();
			// pause execution of main thread
			System.in.read(new byte[10]);
			
			MessageMessage mm = new MessageMessage("/validation", "test", "test");
			server.gateway.broadcastMessage(mm);
			
			System.in.read(new byte[10]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			server.gateway.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

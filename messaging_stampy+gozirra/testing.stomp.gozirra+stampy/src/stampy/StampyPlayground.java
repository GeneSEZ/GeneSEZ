package stampy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import net.ser1.stomp.Client;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

import asia.stampy.client.listener.validate.ClientMessageValidationListener;
import asia.stampy.client.message.connect.ConnectMessage;
import asia.stampy.client.message.disconnect.DisconnectMessage;
import asia.stampy.client.message.send.SendMessage;
import asia.stampy.client.message.subscribe.SubscribeMessage;
import asia.stampy.client.message.unsubscribe.UnsubscribeMessage;
import asia.stampy.client.netty.ClientNettyChannelHandler;
import asia.stampy.client.netty.ClientNettyMessageGateway;
import asia.stampy.client.netty.connected.NettyConnectedMessageListener;
import asia.stampy.client.netty.disconnect.NettyDisconnectListenerAndInterceptor;
import asia.stampy.common.gateway.HostPort;
import asia.stampy.common.gateway.SecurityMessageListener;
import asia.stampy.common.gateway.StampyMessageListener;
import asia.stampy.common.heartbeat.HeartbeatContainer;
import asia.stampy.common.heartbeat.StampyHeartbeatContainer;
import asia.stampy.common.message.StampyMessage;
import asia.stampy.common.message.StompMessageType;
import asia.stampy.server.listener.subscription.StampyAcknowledgementHandler;
import asia.stampy.server.listener.validate.ServerMessageValidationListener;
import asia.stampy.server.message.error.ErrorMessage;
import asia.stampy.server.message.message.MessageMessage;
import asia.stampy.server.netty.ServerNettyChannelHandler;
import asia.stampy.server.netty.ServerNettyMessageGateway;
import asia.stampy.server.netty.connect.NettyConnectResponseListener;
import asia.stampy.server.netty.connect.NettyConnectStateListener;
import asia.stampy.server.netty.heartbeat.NettyHeartbeatListener;
import asia.stampy.server.netty.receipt.NettyReceiptListener;
import asia.stampy.server.netty.subscription.NettyAcknowledgementListenerAndInterceptor;
import asia.stampy.server.netty.transaction.NettyTransactionListener;

public class StampyPlayground {
	
	static class Server {
		ServerNettyMessageGateway gateway;
		// subscription destination -> host port -> subscription id
		Map<String, Map<HostPort, Set<String>>> subscriptions = new LinkedHashMap<>();
		
		public Server() {
			// basic connection setup
			gateway = new ServerNettyMessageGateway();
			gateway.setPort(12345);
			gateway.setHeartbeat(1000);
			gateway.setAutoShutdown(true);
			gateway.addHandler(new SimpleChannelUpstreamHandler() {
				@Override
				public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
					System.out.println("channel disconnected!");
					super.channelDisconnected(ctx, e);
				}
			});
			
			StampyHeartbeatContainer heartbeat = new HeartbeatContainer();
			ServerNettyChannelHandler channelHandler = new ServerNettyChannelHandler();
			channelHandler.setGateway(gateway);
			channelHandler.setHeartbeatContainer(heartbeat);
			gateway.setHandler(channelHandler);
			
			// protocol setup
			SecurityMessageListener sml = new SecurityMessageListener() {
				
				@Override
				public void messageReceived(StampyMessage<?> message, HostPort hostPort) throws Exception {
					// simply do nothing
				}
				
				@Override
				public boolean isForMessage(StampyMessage<?> message) {
					return false;
				}
				
				@Override
				public StompMessageType[] getMessageTypes() {
					return null;
				}
			};
			gateway.addMessageListener(sml);
			
			ServerMessageValidationListener smvl = new ServerMessageValidationListener();
			gateway.addMessageListener(smvl);
			
			NettyConnectResponseListener ncrl = new NettyConnectResponseListener();
			ncrl.setGateway(gateway);
			gateway.addMessageListener(ncrl);
			
			NettyConnectStateListener ncsl = new NettyConnectStateListener();
			ncsl.setGateway(gateway);
			gateway.addMessageListener(ncsl);
			
			NettyHeartbeatListener nhbl = new NettyHeartbeatListener();
			nhbl.setHeartbeatContainer(heartbeat);
			nhbl.setGateway(gateway);
			gateway.addMessageListener(nhbl);
			
			NettyTransactionListener ntl = new NettyTransactionListener();
			ntl.setGateway(gateway);
			gateway.addMessageListener(ntl);
			
			StampyAcknowledgementHandler sah = new StampyAcknowledgementHandler() {
				@Override
				public void noAcknowledgementReceived(String id) {
					System.out.println("No acknowledgement received for " + id);
				}
				
				@Override
				public void nackReceived(String id, String receipt, String transaction) throws Exception {
					System.out.println("Nack message received for " + id);
				}
				
				@Override
				public void ackReceived(String id, String receipt, String transaction) throws Exception {
					System.out.println("Ack message received for " + id);
				}
			};
			NettyAcknowledgementListenerAndInterceptor nalai = new NettyAcknowledgementListenerAndInterceptor();
			nalai.setAckTimeoutMillis(200);
			nalai.setHandler(sah);
			nalai.setGateway(gateway);
			gateway.addOutgoingMessageInterceptor(nalai);
			gateway.addMessageListener(nalai);
			
			NettyReceiptListener nrl = new NettyReceiptListener();
			nrl.setGateway(gateway);
			gateway.addMessageListener(nrl);
			
			gateway.addMessageListener(new StampyMessageListener() {
				
				@Override
				public void messageReceived(StampyMessage<?> message, HostPort hostPort) throws Exception {
					System.out.println("server received: " + message.getMessageType() + " " + message.getHeader().getHeaders());
				}
				
				@Override
				public boolean isForMessage(StampyMessage<?> message) {
					// message listener for all messages
					return true;
				}
				
				@Override
				public StompMessageType[] getMessageTypes() {
					// all message types
					return StompMessageType.values();
				}
			});
			
			// listen to subscriptions + send message + forward appropriate
			gateway.addMessageListener(new StampyMessageListener() {
				
				@Override
				public void messageReceived(StampyMessage<?> message, HostPort hostPort) throws Exception {
					switch (message.getMessageType()) {
						case SUBSCRIBE : 
							// register subscriber
							SubscribeMessage sm = (SubscribeMessage)message;
							String subscribeDestination = sm.getHeader().getDestination();
							String subscriptionId = sm.getHeader().getId();
							Map<HostPort, Set<String>> subscriber = subscriptions.get(subscribeDestination);
							if (subscriber == null) {
								subscriber = new LinkedHashMap<>();
								subscriptions.put(subscribeDestination, subscriber);
							}
							Set<String> subscribedIds = subscriber.get(hostPort);
							if (subscribedIds == null) {
								subscribedIds = new LinkedHashSet<>();
								subscriber.put(hostPort, subscribedIds);
							}
							subscribedIds.add(subscriptionId);
							break;
							
						case UNSUBSCRIBE :
							// unregister subscriber
							UnsubscribeMessage usm = (UnsubscribeMessage)message;
							String unsubscribeId = usm.getHeader().getId();
							Collection<Map<HostPort, Set<String>>> values = subscriptions.values();
							Set<String> toRemoveFrom = null;
							for (Map<HostPort, Set<String>> entry : values) {
								Set<String> subscriptionIds = entry.get(hostPort);
								if (subscriptionIds == null) {
									continue;
								}
								if (subscriptionIds.contains(unsubscribeId)) {
									toRemoveFrom = subscriptionIds;
								}
							}
							if (toRemoveFrom != null) {
								toRemoveFrom.remove(unsubscribeId);
							}
							break;
							
						case SEND :
							// forward message to all subscribers
							SendMessage sendm = (SendMessage)message;
							String destination = sendm.getHeader().getDestination();
							Map<HostPort, Set<String>> clients = subscriptions.get(destination);
							if (clients != null) {
								for (Map.Entry<HostPort, Set<String>> entry : clients.entrySet()) {
									HostPort receiver = entry.getKey();
									for (String subscription : entry.getValue()) {
										String messageId = UUID.randomUUID().toString();
										MessageMessage mm = new MessageMessage(destination, messageId, subscription);
										gateway.sendMessage(mm, receiver);
									}
								}
							}
							break;
							
						default :
							// should not happen
							System.out.println("Unsupported message received: " + message.getHeader().getHeaders());
					}
				}
				
				@Override
				public boolean isForMessage(StampyMessage<?> message) {
					return true;
				}
				
				@Override
				public StompMessageType[] getMessageTypes() {
					return new StompMessageType[] {StompMessageType.SUBSCRIBE, StompMessageType.UNSUBSCRIBE, StompMessageType.SEND};
				}
			});
		}
		
		public void shutdown() throws Exception {
			gateway.shutdown();
		}
	}
	
	static class Client {
		ClientNettyMessageGateway gateway;
		
		public Client() {
			gateway = new ClientNettyMessageGateway();
			gateway.setHost("localhost");
			gateway.setPort(12345);
			gateway.setHeartbeat(1000);
			
			StampyHeartbeatContainer shc = new HeartbeatContainer();
			ClientNettyChannelHandler nch = new ClientNettyChannelHandler();
			nch.setHeartbeatContainer(shc);
			nch.setGateway(gateway);
			gateway.setHandler(nch);
			
			// protocol setup
			SecurityMessageListener sml = new SecurityMessageListener() {
				
				@Override
				public void messageReceived(StampyMessage<?> message, HostPort hostPort) throws Exception {
					// simply do nothing
				}
				
				@Override
				public boolean isForMessage(StampyMessage<?> message) {
					return false;
				}
				
				@Override
				public StompMessageType[] getMessageTypes() {
					return null;
				}
			};
			gateway.addMessageListener(sml);
			
			ClientMessageValidationListener cmvl = new ClientMessageValidationListener();
			gateway.addMessageListener(cmvl);
			
			NettyConnectedMessageListener ncml = new NettyConnectedMessageListener();
			ncml.setHeartbeatContainer(shc);
			ncml.setGateway(gateway);
			gateway.addMessageListener(ncml);
			
			NettyDisconnectListenerAndInterceptor ndlai = new NettyDisconnectListenerAndInterceptor();
			ndlai.setCloseOnDisconnectMessage(true);
			ndlai.setGateway(gateway);
			gateway.addOutgoingMessageInterceptor(ndlai);
			gateway.addMessageListener(ndlai);
			
			gateway.addMessageListener(new StampyMessageListener() {
				
				@Override
				public void messageReceived(StampyMessage<?> message, HostPort hostPort) throws Exception {
					System.out.println("client received: " + message.getMessageType() + " " + message.getHeader().getHeaders());
				}
				
				@Override
				public boolean isForMessage(StampyMessage<?> message) {
					// message listener for all messages
					return true;
				}
				
				@Override
				public StompMessageType[] getMessageTypes() {
					// all message types
					return StompMessageType.values();
				}
			});
		}
	}
	
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.gateway.connect();
			
			Client producer = new Client();
			producer.gateway.connect();
			Client consumer1 = new Client();
			consumer1.gateway.connect();
			Client consumer2 = new Client();
			consumer2.gateway.connect();
			
			Thread.sleep(500);
			System.out.println("connected clients: " + server.gateway.getConnectedHostPorts().size());
			
			// connect is just a raw connect, no stampy connect...
			ConnectMessage cm = new ConnectMessage("localhost");
			producer.gateway.broadcastMessage(cm);
			consumer1.gateway.broadcastMessage(cm);
			consumer2.gateway.broadcastMessage(cm);
			
			Thread.sleep(500);
			
			System.out.println("subscribe to topic...");
			
			SubscribeMessage subscribe = new SubscribeMessage("/validation", "test");
			consumer1.gateway.broadcastMessage(subscribe);
			consumer2.gateway.broadcastMessage(subscribe);
			
			Thread.sleep(500);
			
			System.out.println("send message...");
			
			SendMessage sm = new SendMessage("/validation", null);
			sm.setBody("the message body");
			producer.gateway.broadcastMessage(sm);
			Thread.sleep(500);
			producer.gateway.broadcastMessage(sm);
			Thread.sleep(500);
			producer.gateway.broadcastMessage(sm);
			
			Thread.sleep(500);
			
			// is a server frame
//			MessageMessage mm = new MessageMessage("test", "messageId", "/validation");
//			mm.setBody("message body");
//			producer.gateway.broadcastMessage(mm);
			
			// is a server frame too
//			ErrorMessage em = new ErrorMessage();
//			producer.gateway.broadcastMessage(em);
			
			System.out.println("disconnect...");
			
			DisconnectMessage dm = new DisconnectMessage();
			consumer1.gateway.broadcastMessage(dm);
			consumer2.gateway.broadcastMessage(dm);
			producer.gateway.broadcastMessage(dm);
			
			Thread.sleep(500);
			producer.gateway.shutdown();
			consumer1.gateway.shutdown();
			consumer2.gateway.shutdown();
			server.gateway.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package belote.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import belote.model.Card;

@Component
public class BeloteSocketHandler extends TextWebSocketHandler {
	private Logger logger = Logger.getLogger(BeloteSocketHandler.class);
	private HashMap<String,CopyOnWriteArrayList<WebSocketSession>> topics = new HashMap<>();

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {
		BeloteWebSocketData data =null;
		try {
			
			 data = BeloteWebSocketData.parse(message.getPayload());
			 
		} catch (Exception e) {
			data = BeloteWebSocketData.getExceptionData(e.getMessage());
		}
		if(data.isRegister()) {
		    register(data.getTopic(),session);
		    data.setSession(session.getId());
			broadcastResigter(data.getJsonData(),session);
		}
	}
	
	private void register(JSONArray topics, WebSocketSession session) {
		topics.forEach(topic->this.register((String)topic, session));
	}

	private void broadcastResigter(JSONObject jsonData, WebSocketSession session) throws IOException {
		broadcast("register", jsonData, session);
	}

	public void broadcast(String topic, JSONObject data) {
		BeloteWebSocketData dataObj =  BeloteWebSocketData.withJson(data);
		dataObj.setType(topic);
		 CopyOnWriteArrayList<WebSocketSession> sessions = topics.get(topic);
		 if(sessions!=null && sessions.size()>0) {
			try {
				 for(WebSocketSession session : sessions) {
					 if(session.isOpen())
					    session.sendMessage(new TextMessage(dataObj.toString()));
				 }
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		 }
		 
	}
	
	public void broadcast(String topic,JSONObject data,WebSocketSession session) throws IOException {
		BeloteWebSocketData dataObj =  BeloteWebSocketData.withJson(data);
		dataObj.setType(topic);
		session.sendMessage(new TextMessage(dataObj.toString()));
		 
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// traitement lors de la connection d'un nouveau user
		super.afterConnectionEstablished(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		Iterator<String> keys = topics.keySet().iterator();
		while(keys.hasNext()) {
			topics.get(keys.next()).remove(session);
		 }
		super.afterConnectionClosed(session, status);
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		String error = exception.getMessage();
		error = error!=null? error : "error occurred";
		session.sendMessage(new TextMessage(error));
	}

	private void register(String topic, WebSocketSession session) {

		CopyOnWriteArrayList<WebSocketSession> sessions = topics.get(topic);
		 if(sessions==null) {
			 sessions = new CopyOnWriteArrayList<> ();
			 topics.put(topic, sessions);
		 }
		 if(!sessions.contains(session))
		    sessions.add(session);
	}

	public void broadcastNewGame(String id) {
		BeloteWebSocketData data = BeloteWebSocketData.getData("newGame", "game id "+id);
		broadcast("newGame", data.getJsonData() );
	}

	public void broadcastNewPlayer(String player) {
		BeloteWebSocketData data = BeloteWebSocketData.getData("newPlayer", player);
		broadcast("newPlayer", data.getJsonData() );
	}

	public void broadcastCardPlayed(Card card) {
		BeloteWebSocketData data = BeloteWebSocketData.getData("cardPlayed",card.toString());
		broadcast("cardPlayed", data.getJsonData() );
	}

	public void broadcastDistribute() {

		BeloteWebSocketData data = BeloteWebSocketData.getData("distribute","");
		broadcast("distribute", data.getJsonData());
		
	}
	

}
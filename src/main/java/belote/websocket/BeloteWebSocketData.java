package belote.websocket;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 
 * @author belz
 * belote data is a json structure : 
 * { type:'oneType' , message:'theMessage' , 'topic' : 'dataTopic' }
 */
public class BeloteWebSocketData {

	JSONObject data = new JSONObject();
	private static final String TYPE="type";
	private static final String TOPICS="topics";
	private static final String MSG="message";
	private static final String REGISTER = "register";
	private static final String SESSION = "session";
	private static final String EXCEPTION = "Exception";
	
	private BeloteWebSocketData(String type,String msg) {
		data.put(TYPE, type);
		data.put(MSG, msg);
	}
	
	private BeloteWebSocketData(JSONObject dataObj) {
		data = dataObj;
	}
	
	public String getType() {
		return data.getString(TYPE);
	}


	public String getMessage() {
		return data.getString(MSG);
	}


	public static BeloteWebSocketData parse(String data){
		BeloteWebSocketData socketData = null;
		
			JSONObject dataObj = new JSONObject(data);
			if(dataObj.has(TYPE) ) {
				socketData = new BeloteWebSocketData(dataObj);
			}else {
				throw new  IllegalArgumentException("data object must have type");
			}
		
		return socketData;
	}
     
	@Override
	public String toString() {
		return data.toString();
	}
	public static BeloteWebSocketData getData(String type, String msg) {
		return new BeloteWebSocketData(type, msg);
	}

	public boolean isRegister() {
		return getType().equals(REGISTER);
	}

	public void setSession(String session) {
		data.put(SESSION, session);
	}

	public JSONObject getJsonData() {
		return data;
	}

	public static BeloteWebSocketData getExceptionData(String msg) {
		return new BeloteWebSocketData(EXCEPTION, msg);
	}

	public static BeloteWebSocketData withJson(JSONObject data) {
		return new BeloteWebSocketData(data);
	}

	public void setType(String topic) {
		data.put(TYPE, topic);
	}

	public JSONArray getTopic() {
		return data.getJSONArray(TOPICS);
	}
}

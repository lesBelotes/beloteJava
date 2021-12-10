package belote.model;

import java.util.HashMap;
import java.util.Map;

public class CardPoint {
	
	private static Map<String,Integer> points = setMapPoint();
	private static Map<String,Integer> atoutPoints = setMapAtoutPoint();	
	
	private CardPoint() {
	}

	private static Map<String,Integer> setMapPoint() {
		
		Map<String,Integer> map = new HashMap<>();		
		map.put("7", 0);
		map.put("8", 0);
		map.put("9", 0);
		map.put("J", 2);
		map.put("Q", 3);
		map.put("K", 4);
		map.put("10", 10);
		map.put("1", 11);		
		return map;
	}
	
	private static Map<String,Integer> setMapAtoutPoint() {
		Map<String,Integer> map = new HashMap<>();		
		map.put("7", 0);
		map.put("8", 0);
		map.put("Q", 3);
		map.put("K", 4);
		map.put("10", 10);
		map.put("1", 11);
		map.put("9", 14);
		map.put("J", 20);	
		return map;
	}
	
	public static int getPoint(String value) {
		if(points == null) {
			points = setMapPoint();
		}
		return points.get(value);
	}
	
	public static int getPoint(CardValue value) {
		return getPoint(value.getAbbreviation());
	}
	
	public static int getAtoutPoint(String value) {
		if(atoutPoints == null) {
			atoutPoints = setMapAtoutPoint();
		}
		return atoutPoints.get(value);
	}
	
	public static int getAtoutPoint(CardValue value) {
		return getAtoutPoint(value.getAbbreviation());
	}
	

}

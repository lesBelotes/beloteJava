package belote.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Set;

public class RandomUtil {
	
	private RandomUtil() {
		
	}
	
	public static int getRandom(int limit) {
		Random random = null;
		int rValue = 0;
		try {
			random = SecureRandom.getInstanceStrong();
			rValue = random.nextInt(limit);			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rValue;
	}

	/**
	 * si le curentTime est deja utilisé, ajoute +1 à celui et 
	 * recommence jusqu'à ce que en avoir non usité
	 * @param keySet list des curentTime utilisé
	 * @return curentTime
	 */
	public static String generateId(Set<String> keySet) {
		double id = System.currentTimeMillis();
		String idStr = Double.toString(id);
		
		while(keySet != null && keySet.contains(idStr)) {
			id++;
			idStr = Double.toString(id);
		}
		return idStr;
	}

}

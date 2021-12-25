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
	 * si le curentTime est deja utilis�, ajoute +1 � celui et 
	 * recommence jusqu'� ce que en avoir non usit�
	 * @param keySet list des curentTime utilis�
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

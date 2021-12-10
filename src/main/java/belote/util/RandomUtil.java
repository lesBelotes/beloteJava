package belote.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomUtil {
	
	public int getRandom(int limit) {
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

}

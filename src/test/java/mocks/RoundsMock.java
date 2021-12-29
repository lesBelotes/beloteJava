package mocks;

import belote.enums.Position;
import belote.model.Round;

public class RoundsMock {
	
	private static Round roundNorth;
	
	public static Round getRoundNorth() {
		
		if(roundNorth == null) {
			roundNorth = new Round(Position.NORTH);			
		}
		return roundNorth;
	}
	
	public static void iniRounds() {
		roundNorth = null;
	}

}

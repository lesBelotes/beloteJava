package mocks;

import belote.enums.ColorEnum;
import belote.enums.ContratTypes;
import belote.enums.Position;
import belote.model.Contrat;

public class ContratsMock {
	
	private static Contrat hundredClub;
	
	private static Contrat hundredTenDiamond;
	
	
	
	/**
	 * tacker east
	 * @return
	 */
	public static Contrat getHundredClub() {
		if(hundredClub == null) {
			hundredClub = new Contrat(
					ContratTypes.HUNDRED, 
					ColorEnum.CLUB, 
					Position.EAST
					);
		}
		return hundredClub;
	}
	
	/**
	 * tacker north
	 * @return
	 */
	public static Contrat getHundredTenDiamond() {
		if(hundredTenDiamond == null) {
			hundredTenDiamond = new Contrat(
					ContratTypes.HUNDREDTEN, 
					ColorEnum.DIAMOND, 
					Position.NORTH
					);
		}
		return hundredTenDiamond;
	}
	
	public static void initContrats() {
		hundredClub = null;
		hundredTenDiamond = null;
	}

}

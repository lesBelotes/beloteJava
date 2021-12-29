package mocks;

import belote.enums.Position;
import belote.exeption.GameException;
import belote.model.Pli;

public class PliMock {
	
	private static Pli fullCardsNorth;
	private static Pli fullCardsWest;
	private static Pli fullCardsSouth;
	private static Pli fullCardsEast;
	
	
	
	public static Pli getFullCardsNorth() {
		
		if(fullCardsNorth == null) {
			fullCardsNorth = new Pli(Position.NORTH);
			try {
				fullCardsNorth.addCard(CardsMock.getAceSpade());
				fullCardsNorth.addCard(CardsMock.getAceClub());
				fullCardsNorth.addCard(CardsMock.getHeightDiamond());
				fullCardsNorth.addCard(CardsMock.getQueenHeart());
			} catch (GameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return fullCardsNorth;
	}
	
	public static Pli getFullCardsEast() {
		if(fullCardsEast == null) {
			fullCardsEast = new Pli(Position.EAST);
			try {
				fullCardsEast.addCard(CardsMock.getKingHeart());
				fullCardsEast.addCard(CardsMock.getSevanHeart());
				fullCardsEast.addCard(CardsMock.getNineClub());
				fullCardsEast.addCard(CardsMock.getJackDiamond());
			} catch (GameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return fullCardsEast;
	}
	
	public static Pli getFullCardsSouth() {
		if(fullCardsSouth == null) {
			fullCardsSouth = new Pli(Position.SOUTH);
			try {
				fullCardsSouth.addCard(CardsMock.getKingHeart());
				fullCardsSouth.addCard(CardsMock.getTenSpade());
				fullCardsSouth.addCard(CardsMock.getSevanHeart());
				fullCardsSouth.addCard(CardsMock.getTenDiamond());
			} catch (GameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fullCardsSouth;
	}
	
	public static Pli getFullCardsWest() {
		if(fullCardsWest == null) {
			fullCardsWest = new Pli(Position.WEST);
			try {
				fullCardsWest.addCard(CardsMock.getAceClub());
				fullCardsWest.addCard(CardsMock.getHeightClub());
				fullCardsWest.addCard(CardsMock.getNineClub());
				fullCardsWest.addCard(CardsMock.getTenDiamond());
			} catch (GameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fullCardsWest;
	}
	
	
	
	
	public static void initPlis() {
		fullCardsNorth = null;
		fullCardsWest = null;
		fullCardsSouth = null;
		fullCardsEast = null;
	}

}

package mocks;

import belote.model.Card;
import belote.model.CardValue;
import belote.model.ColorEnum;

public class CardsMovk {
	
	
	private static Card aceClub ;
	private static Card heightClub ;
	
	private static Card kingHeart ;
	private static Card queenHeart ;
	
	private static Card heightDiamond ;	

	private static Card aceSpade ;

	public static Card getAceClub() {
		if(aceClub == null) {
			aceClub = new Card(ColorEnum.CLUB, CardValue.ACE);			
		}
		return aceClub;
	}

	public static Card getHeightClub() {
		
		if(heightClub == null) {
			heightClub = new Card(ColorEnum.CLUB, CardValue.HEIGHT);			
		}		
		return heightClub;
	}

	public static Card getKingHeart() {
		if(kingHeart == null) {
			kingHeart = new Card(ColorEnum.HEART, CardValue.KING);			
		}
		return kingHeart;
	}

	public static Card getQueenHeart() {		
		if(queenHeart == null) {
			queenHeart = new Card(ColorEnum.HEART, CardValue.GUEEN);			
		}
		return queenHeart;
	}

	public static Card getHeightDiamond() {
		if(heightDiamond == null) {
			heightDiamond = new Card(ColorEnum.DIAMOND, CardValue.HEIGHT);			
		}
		return heightDiamond;
	}

	public static Card getAceSpade() {
		if(aceSpade == null) {
			aceSpade = new Card(ColorEnum.SPADE, CardValue.ACE);			
		}
		return aceSpade;
	}

	public static void intCards() {
		aceClub = null;
		heightClub  = null;
		kingHeart  = null;
		queenHeart  = null;
		heightDiamond  = null;
		aceSpade  = null;		
	}
	
	
	

}

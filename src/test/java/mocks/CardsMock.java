package mocks;

import belote.enums.CardValue;
import belote.enums.ColorEnum;
import belote.model.Card;

public class CardsMock {
	
	
	private static Card aceClub ;
	private static Card nineClub ;
	private static Card heightClub ;
	
	private static Card kingHeart ;
	private static Card queenHeart ;
	private static Card sevanHeart ;

	private static Card jackDiamond ;
	private static Card tenDiamond ;
	private static Card heightDiamond ;

	private static Card aceSpade ;
	private static Card qeenSpade ;
	private static Card tenSpade ;

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
	
	public static Card getNineClub() {
		if(nineClub == null) {
			nineClub = new Card(ColorEnum.CLUB, CardValue.NINE);			
		}
		return nineClub;
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
	
	public static Card getSevanHeart() {
		if(sevanHeart == null) {
			sevanHeart = new Card(ColorEnum.HEART, CardValue.SEVEN);			
		}
		return sevanHeart;
	}

	public static Card getHeightDiamond() {
		if(heightDiamond == null) {
			heightDiamond = new Card(ColorEnum.DIAMOND, CardValue.HEIGHT);			
		}
		return heightDiamond;
	}
	
	public static Card getJackDiamond() {
		if(jackDiamond == null) {
			jackDiamond = new Card(ColorEnum.DIAMOND, CardValue.JACK);			
		}
		return jackDiamond;
	}
	
	public static Card getTenDiamond() {
		if(tenDiamond == null) {
			tenDiamond = new Card(ColorEnum.DIAMOND, CardValue.TEN);			
		}
		return tenDiamond;
	}

	public static Card getAceSpade() {
		if(aceSpade == null) {
			aceSpade = new Card(ColorEnum.SPADE, CardValue.ACE);			
		}
		return aceSpade;
	}
	
	public static Card getQeenSpade() {
		if(qeenSpade == null) {
			qeenSpade = new Card(ColorEnum.SPADE, CardValue.GUEEN);			
		}
		return qeenSpade;
	}
	
	public static Card getTenSpade() {
		if(tenSpade == null) {
			tenSpade = new Card(ColorEnum.SPADE, CardValue.TEN);			
		}
		return tenSpade;
	}

	public static void intCards() {
		aceClub = null;
		nineClub = null;
		heightClub  = null;
		
		kingHeart  = null;
		queenHeart  = null;
		sevanHeart = null;		

		jackDiamond  = null;
		tenDiamond = null;
		heightDiamond  = null;
		
		aceSpade  = null;
		qeenSpade = null;
		tenSpade = null;
	}
	
	
	

}

package belote.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import belote.enums.Position;
import belote.exeption.GameException;

public class Pli {
	
	private Card[] cards;
	private Position beginner;
		
	public Pli(Position beginner, Card cardPlayed) {
		this(beginner);
		cards[0] = cardPlayed;
	}

	public Pli(Position beginner) {
		cards = new Card[4];
		this.beginner = beginner;
	}	
	
	public Position getBeginner() {
		return beginner;
	}

	public int ndCards() {		
		int nbCards = 0;
		for (Card card : cards) {
			if(card != null) {
				nbCards++;
			}			
		}
		return nbCards;
	}
	
	public void addCard(Card card) throws GameException {
		int cardAdded = ndCards();
		
		if(cardAdded>3) {
			throw new GameException("too much card");
		}		
		cards[cardAdded] = card;		
	}
	
	public List<Card> getCards() {
		List<Card> listCard = new ArrayList<>();
		
		for (Card card : cards) {
			if(card != null) {
				listCard.add(card);
			}			
		}
		
		return listCard;
	}
	
	/**
	 * 
	 * @return la couleur de laere carte jouée  
	 * @throws GameException si il n y a pas de carte encore jouée
	 */
	public Color colorAsk() throws GameException {
		
		if(ndCards() == 0) {
			throw new GameException("No card played");
		}
		Card firstCard = cards[0];
		return firstCard.getColor();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cards);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pli other = (Pli) obj;
		return Arrays.equals(cards, other.cards);
	}
	
	

}

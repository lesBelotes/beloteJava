package belote.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import belote.util.RandomUtil;

public class Deck  {
	
	private List<Card> cards;
	
	
	
	public Deck() {
		createDeck();
	}


	private void createDeck() {
		cards = new ArrayList<>();
		
		for(ColorEnum color : ColorEnum.values()) {			
			for(CardValue value : CardValue.values()) {
				cards.add(new Card(color, value));
			}			
		}
	}
	
	
	public void shuffle() {
		
		List<Card> cardsTemp = new ArrayList<>();
		
		while (!cards.isEmpty()) {
			
			RandomUtil randomUtil = new RandomUtil();

			int index = randomUtil.getRandom(cards.size());			
			cardsTemp.add(cards.remove(index));
		}
		
		cards = cardsTemp;
	}


	public List<Card> getCards() {
		return cards;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
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
		Deck other = (Deck) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		return true;
	}


	
	
	
	
	

}

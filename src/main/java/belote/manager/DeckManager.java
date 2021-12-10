package belote.manager;

import java.util.List;

import belote.model.Card;
import belote.model.ColorEnum;
import belote.model.Deck;
import belote.model.Player;
import belote.util.RandomUtil;

public class DeckManager {

	public void distribute(List<Player> players) {
		Deck deck = new Deck();		
		deck.shuffle();

		int cardsDistributed = 0;
		while (!deck.getCards().isEmpty()) {
			int cardToDistribute = nbCardToDistribute(cardsDistributed);
			cardsDistributed += cardToDistribute;
			
			for (Player player : players) {
				for (int i = 0; i < cardToDistribute; i++) {
					player.addCardToHand(deck.getCards().remove(0));
				}
			}
		}
	}

	private int nbCardToDistribute(int cardsDistributed) {

		return nbCardToDistribute(cardsDistributed,2);
	}

	private int nbCardToDistribute(int cardsDistributed, int nbCardMax) {

		RandomUtil randomUtil = new RandomUtil();
		int nbCard = randomUtil.getRandom(nbCardMax) + 1;

		cardsDistributed += nbCard;

		if(cardsDistributed > 8) {
			cardsDistributed -= nbCard;
			nbCard = nbCardToDistribute(cardsDistributed,nbCardMax-1);
		}

		return nbCard;
	}
	
	public void setPlayerAtout(List<Player> players, ColorEnum color) {
		for (Player player : players) {
			setAtout(player.getHand(), color);			
		}
	}
	
	public void setAtout(List<Card> cards, ColorEnum color) {
		for (Card card : cards) {
			card.setAtout(color.equals(card.getColor()));
		}
	}

}

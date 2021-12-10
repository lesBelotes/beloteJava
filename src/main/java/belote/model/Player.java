package belote.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String pseudo;
	private String ip;
	private List<Card> hand;
	
	public Player(String pseudo, String ip) {
		this.pseudo = pseudo;
		this.ip = ip;
		hand = new ArrayList<>();
	}

	public String getPseudo() {
		return pseudo;
	}

	public String getIp() {
		return ip;
	}
	
	public void addCardsToHand(List<Card> cards) {
		hand.addAll(cards);
	}
	
	public void addCardToHand(Card card) {
		hand.add(card);
	}

	public List<Card> getHand() {
		return hand;
	}
	
	
	
	
	
	
	
	

}

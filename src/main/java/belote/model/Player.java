package belote.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String pseudo;
	private String ip;
	private List<Card> hand;
	private boolean isInGame;
	private String id;

	public Player(String pseudo, String ip, String id) {
		super();
		this.pseudo = pseudo;
		this.ip = ip;
		this.id = id;
		isInGame = false;
		hand = new ArrayList<>();
	}
	
	public Player(String pseudo, String ip) {
		this(pseudo, ip, Double.toString(System.currentTimeMillis()));
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

	public boolean isInGame() {
		return isInGame;
	}

	public void setInGame(boolean isInGame) {
		this.isInGame = isInGame;
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Player other = (Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

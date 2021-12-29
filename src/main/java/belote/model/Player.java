package belote.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
	
	private String pseudo;
	private Set<Card> hand;
	private boolean isInGame;
	private String id;

		
	public Player(String pseudo, String id) {
		super();
		this.pseudo = pseudo;
		this.id = id;
		isInGame = false;
		hand = new HashSet<>();
	}

	public String getPseudo() {
		return pseudo;
	}
	
	public void addCardsToHand(Set<Card> cards) {
		hand.addAll(cards);
	}
	
	public void addCardToHand(Card card) {
		hand.add(card);
	}

	public Set<Card> getHand() {
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

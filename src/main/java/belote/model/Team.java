package belote.model;

import java.util.Objects;

public class Team {
	
	private Player player1;
	private Player player2;
	
	//point de equipe de la partie
	private int score;
	
	

	public Team() {
		super();
		this.score = 0;
	}

	public int getScore() {
		return score;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
	public void addPoints(int points) {
		score += points;
	}

	@Override
	public int hashCode() {
		return Objects.hash(player1, player2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(player1, other.player1) && Objects.equals(player2, other.player2);
	}
	
	
	
	
	
	
	

}

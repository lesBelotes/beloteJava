package belote.model;

import java.util.ArrayList;
import java.util.List;

import belote.enums.State;

public class Game {
	/**
	 * 2 equipes pour jouer , chaque equie contient 2 joueurs.
	 */
	private Team teamNS;
	private Team teamEW;
	
	private String id;
	private int pointMax;
	
	private State state;
	
	//round en cour
	private Round round;
	
	//liste des rounds passé
	private List<Round> rounds;

	public Game(String id) {
		teamNS = new Team();
		teamEW = new Team();		
		this.id = id;
		pointMax = 2250;
		state = State.WAITING;
		rounds = new ArrayList<>();
	}

	public Team getTeamNS() {
		return teamNS;
	}

	public Team getTeamEW() {
		return teamEW;
	}

	public String getId() {
		return id;
	}
	
	public Player getNorth() {
		return teamNS.getPlayer1();		
	}
	
	public Player getSouth() {
		return teamNS.getPlayer2();		
	}
	
	public Player getWest() {
		return teamEW.getPlayer1();	
	}
	
	public Player getEast() {
		return teamEW.getPlayer2();	
	}
	
	public void setNorth(Player player) {
		teamNS.setPlayer1(player);
	}
	
	public void setSouth(Player player) {
		teamNS.setPlayer2(player);
	}
	
	public void setWest(Player player) {
		teamEW.setPlayer1(player);
	}
	
	public void setEast(Player player) {
		teamEW.setPlayer2(player);
	}
	
	/**
	 * Ajout des point à l equipe North South
	 * @param point point a ajouter
	 */
	public void addPointToNS(int points) {
		teamNS.addPoints(points);		
	}
	
	/**
	 * Ajout des point à l equipe Est West
	 * @param point point a ajouter
	 */
	public void addPointToEW(int points) {
		teamEW.addPoints(points);
	}
	
	public int scorePointNS() {
		return teamNS.getScore();
	}	

	public int scorePointEW() {
		return teamEW.getScore();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public int getPointMax() {
		return pointMax;
	}

	/**
	 * 
	 * @return nombre de joueur présent dans la partie
	 */
	public int getNbPlayer() {
		
		return getPlayers().size();		
	}
	
	/**
	 * 
	 * @return la liste des plyer de la partie
	 */
	public List<Player> getPlayers() {
		
		List<Player> players = new ArrayList<>();
		addPlayer(players, getNorth());
		addPlayer(players, getWest());
		addPlayer(players, getSouth());
		addPlayer(players, getEast());		
		return players;
	}
	
	/**
	 * ajoute un player à une list si celui ci n est pas null
	 * @param players list dont on ajoute le joueur
	 * @param playerToAdd joueur a ajouter
	 */
	private void addPlayer(List<Player> players, Player playerToAdd) {		
		if(playerToAdd != null) {
			players.add(playerToAdd);
		}		
	}
	
	public Round getRound() {
		return round;
	}
	
	public void setRound(Round round) {
		this.round = round;
	}
	
	public List<Round> getRounds() {
		return rounds;
	}
	
	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}
	
	/**
	 * Ajoute un round à la liste des rounds
	 * @param round round à ajouter
	 */
	public void addRound(Round round) {
		rounds.add(round);
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
		Game other = (Game) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

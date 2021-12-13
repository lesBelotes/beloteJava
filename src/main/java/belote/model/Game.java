package belote.model;

public class Game {
	
	private Team teamNS;
	private Team teamEW;
	
	private String id;
	private int pointMax;
	private Player[] players;
	
	private State state;

	public Game(String id) {
		teamNS = new Team();
		teamEW = new Team();		
		this.id = id;
		pointMax = 2250;
		state = State.WAITING;
		players = new Player[4];
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
		players[0] = player;
	}
	
	public void setSouth(Player player) {
		teamNS.setPlayer2(player);
		players[2] = player;
	}
	
	public void setWest(Player player) {
		teamEW.setPlayer1(player);
		players[1] = player;	
	}
	
	public void setEast(Player player) {
		teamEW.setPlayer2(player);
		players[3] = player;
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

	public int getNbPlayer() {
		int nbPlayer = 0;		
		for (Player player : players) {
			if(player != null) {
				nbPlayer ++;
			}
		}
		return nbPlayer;		
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

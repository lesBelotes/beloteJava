package belote.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import belote.exeption.GameException;
import belote.model.Player;
import belote.util.RandomUtil;

public class PlayerManager {
	
	private Map<String,Player> players;
	
	private static PlayerManager instance;
	
	private PlayerManager() {
		players = new HashMap<>();		
	}
	
	public static synchronized PlayerManager getInstance() {
		if (instance == null)
	    {
	      instance = new PlayerManager();
	    }
	    return instance;
	}
	
	public synchronized String createPlayer(String pseudo) {
		String id = RandomUtil.generateId(players.keySet());
		players.put(id, new Player(pseudo, id));
		return id;
	}
	
	public synchronized boolean removePlayer(String idPlayer) throws GameException {
		return players.remove(idPlayer, getPlayer(idPlayer));
	}

	public Player getPlayer(String id) {
		Player player = players.get(id);
		if(player ==null)
			throw new NoSuchElementException(String.format("player with id %s not found", id));
		return player;
	}
	
	public Map<String, Player> getPlayers() {
		return players;
	}

}

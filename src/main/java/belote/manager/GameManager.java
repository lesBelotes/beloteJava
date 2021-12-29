package belote.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import belote.enums.State;
import belote.model.Game;
import belote.model.Player;
import belote.util.RandomUtil;

public class GameManager {
	
	private Map<String,Game> games;
	
	private static final String GAME_NO_FOUND = "Game no found";
	private static final String BAD_POSITION = "Bad position";
	
	private static GameManager instance;
	
	private GameManager() {
		games = new HashMap<>();
	}
	
	public static synchronized GameManager getInstance() {
		if (instance == null)
	    {
	      instance = new GameManager();
	    }
	    return instance;
	}

	public Map<String, Game> getGames() {
		return games;
	}
	/***
	 * créer une game
	 * @return l'id de la game
	 */
	public synchronized String createGame() {
		String id = RandomUtil.generateId(games.keySet());
		games.put(id, new Game(id));
		return id;		
	}
	
	public Game getNewGame() {
		String id = createGame();
		return getGame(id);		
	}
	
	/***
	 * 
	 * @param id id de la game à récupérer
	 * @return la game de l'id passé en paramettre
	 */
	public Game getGameById(String id) {
		return games.get(id);
	}
	
	/**
	 * 
	 * @param gameId id de la game à récupérer
	 * @return la game de l'id passé en paramettre
	 * @throws GameException if no game found
	 */
	public Game getGame(String gameId) {
		Game game = games.get(gameId);		
		if(game == null) {
			throw new NoSuchElementException(GAME_NO_FOUND);
		}
		return game;
	}
	
	/***
	 * ajoute un player à une partie la position du joueur dépend du nombre de joueur déjat présent
	 * 1er joueur -> north
	 * 2e joueur -> west
	 * 3e joueur -> south
	 * 4e joueur -> east
	 * @param gameId identifiant de la game dont on souhaite ajouter le player
	 * @param player joueur à ajouter
	 * @throws GameException si la partie n'existe pas ou si la position est mauvaise
	 */
	public void addPlayerToGame(String gameId, Player player) {		
		Game game = getGame(gameId);
		addPlayerToGame(game, player, game.getNbPlayer());
	}
	
	/***
	 * ajoute un player à une partie
	 * @param gameId identifiant de la game dont on souhaite ajouter le player
	 * @param player  joueur à ajouter
	 * @param position position du joueur (de 0 à 3)
	 * 0 -> north
	 * 1 -> west
	 * 2 -> south
	 * 3 -> east
	 * @throws GameException si la partie n'existe pas ou si la position est mauvaise
	 */
	public void addPlayerToGame(String gameId, Player player, int position)  {
		addPlayerToGame(getGame(gameId), player, position);		
	}
	
	/***
	 * ajoute un player à une partie
	 * @param game game dont on souhaite ajouter le player
	 * @param player player  joueur à ajouter
	 * @param position position du joueur (de 0 à 3)
	 * 0 -> north
	 * 1 -> west
	 * 2 -> south
	 * 3 -> east
	 * @throws GameException si la position est mauvaise
	 */	
	private void addPlayerToGame(Game game, Player player, int position) {
		Game gameTemp = game;
		synchronized (gameTemp) {
			switch (position) {
			case 0:
				game.setNorth(player);
				break;
			case 1:
				game.setWest(player);
				break;
			case 2:
				game.setSouth(player);
				break;
			case 3:
				game.setEast(player);
				break;
			default:
				throw new IllegalArgumentException(BAD_POSITION);
			}
			player.setInGame(true);
			
			if(gameTemp.getNbPlayer() == 4) {
				game.setState(State.START);				
			}
		}
	}

}

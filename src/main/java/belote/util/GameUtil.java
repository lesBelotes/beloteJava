package belote.util;

import java.util.ArrayList;
import java.util.List;

import belote.enums.ColorEnum;
import belote.enums.ContratTypes;
import belote.enums.Position;
import belote.model.Card;
import belote.model.ContratType;
import belote.model.Game;
import belote.model.Player;
import belote.model.Team;

public class GameUtil {
	
	private static final String BAD_POSITION = "Bad position";
	
	private GameUtil() {
		
	}
	
	/**
	 * 
	 * @param player
	 * @param game
	 * @return  l equipe du joueur
	 */
	public static Team getTeam(Player player, Game game) {
		int position = game.getPlayers().indexOf(player);
		return getTeam(position, game);		
	}

	/**
	 * 
	 * @param position position du joueur
	 * @param game
	 * @return l equipe du joueur
	 */
	public static Team getTeam(Position position, Game game) {
		return getTeam(position.getIntPosition(), game);
	}

	/**
	 * 
	 * @param position position du joueur
	 * @param game
	 * @return l equipe du joueur
	 */
	public static Team getTeam(int position, Game game) {
		
		Team team;		
		switch (position) {
		case 0:
		case 2:
			team = game.getTeamNS();
			break;			
		case 1:
		case 3:
			team = game.getTeamEW();
			break;
		default:
			throw new IllegalArgumentException(BAD_POSITION);
		}		
		return team;
	}

	/**
	 * 
	 * @param player joueur dont on veut la position
	 * @param game partie contenant le joueur
	 * @return la position du joueur
	 */
	public static Position getPosition(Player player, Game game) {		
		int index = game.getPlayers().indexOf(player);		
		return Position.values()[index];		
	}
	
	/**
	 * 
	 * @param position  position du joueur
	 * @param game contien le joueur
	 * @return le joueur de la partie par rapport à une position
	 */
	public static Player getPlayer(Position position, Game game) {		
		return getPlayer(position.getIntPosition(), game);		
	}

	/**
	 * 
	 * @param position  position du joueur
	 * @param game contien le joueur
	 * @return le joueur de la partie par rapport à une position
	 */
	public static Player getPlayer(int position, Game game) {
		Player player;		
		switch (position) {
		case 0:
			player = game.getNorth();
			break;			
		case 2:
			player = game.getSouth();
			break;			
		case 1:
			player = game.getWest();
			break;			
		case 3:
			player = game.getEast();
			break;
		default:
			throw new IllegalArgumentException(BAD_POSITION);
		}		
		return player;
	}

	/**
	 * 
	 * @param actualPos position actuel
	 * @return la position suivante
	 */
	public static Position getNext(Position actualPosition) {
		int nextIndex = actualPosition.getIntPosition();
		
		if (nextIndex <3) {
			nextIndex ++;
		}else {
			nextIndex = 0;
		}
		
		return Position.values()[nextIndex];
	}
	
	/**
	 * recupere les ContratTypes sous forme de ContratType
	 * @return la list de tous les ContratType
	 */
	public static List<ContratType> getContratTypes() {
		
		List<ContratType> contratTypes = new ArrayList<>();		
		for (ContratTypes ct :  ContratTypes.values()) {
			contratTypes.add(new ContratType(ct));			
		}		
		return contratTypes;		
	}

	/**
	 * 
	 * @return les couleurs d un jeu de carrtes
	 */
	public static List<String> getColors() {
		List<String> colors = new ArrayList<>();
		for (ColorEnum color :  ColorEnum.values()) {
			colors.add(color.name());			
		}		
		return colors;
	}

	public static Card getCard(String cardStr) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

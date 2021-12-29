package mocks;

import belote.model.Game;

public class GamesMock {
	
	private static Game gameStandard;
	
	private static Game gamePlyers;

	public static Game getGameStandard() {		
		if(gameStandard == null) {
			gameStandard = new Game("gameStandard");			
		}
		return gameStandard;
	}
	
	/**
	 * game avec tous les joueurs
	 * N -> Bob
	 * W -> Liliane
	 * S -> Sandy
	 * E -> Tapette
	 * @return
	 */
	public static Game getGamePlyers() {
		if(gamePlyers == null) {
			gamePlyers = new Game("gamePlyers");
			gamePlyers.setNorth(PlayersMock.getBob());
			gamePlyers.setWest(PlayersMock.getLiliane());
			gamePlyers.setSouth(PlayersMock.getSandy());
			gamePlyers.setEast(PlayersMock.getTapette());
			
		}
		return gamePlyers;
	}
	
	public static void iniGames() {
		gameStandard = null;
		gamePlyers = null;
	}
	
	
	
	

}

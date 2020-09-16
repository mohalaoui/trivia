package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Players {

	private final List<Player> players = new ArrayList<Player>();
	private int currentPlayer;
	
	private Players() {}
	
	public static Players getInstance() {
		return new Players();
	}
	
	public void add(Player player) {
		players.add(player);
	}
	
	public int total() {
	 	return players.size();
	}
	
	public Player currentPlayer() {
		return players.get(currentPlayer);
	}
	
	public void nextPlayer() {
		currentPlayer++;
		if (currentPlayer == players.size()) {
			resetCurrentPlayer();
		}
	}

	private void resetCurrentPlayer() {
			currentPlayer = 0;
	}
}

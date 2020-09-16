package com.adaptionsoft.games.uglytrivia;

public class Player {
	private static final String NOW_HAS = " now has ";
	private static final String GOLD_COINS = " Gold Coins.";
	private static final String NEW_LOCATION_IS = "'s new location is ";
	
	private String name;
	private boolean isInPenaltyBox;
	private int place;
	private int coins;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isInPenaltyBox() {
		return isInPenaltyBox;
	}

	public void setInPenaltyBox(boolean isInPenaltyBox) {
		this.isInPenaltyBox = isInPenaltyBox;
	}

	public int getPlace() {
		return place;
	}
	
	public int incrementPlaceWith(int number) {
		return this.place += number;
	}
	
	public int decrementPlaceWith(int number) {
		return this.place -= number;
	}

	public int getCoins() {
		return coins;
	}
	
	public void incrementCoins() {
		this.coins += 1;
		System.out.println(name + NOW_HAS + coins + GOLD_COINS);
	}
	
	public void newLocation(int roll) {
		incrementPlaceWith(roll);
		if (place >= 12) {
			decrementPlaceWith(12);
		}

		System.out.println(name + NEW_LOCATION_IS + place);
	}
}

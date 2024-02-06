package com.prakash.dto;

public class Players {
	private String name;
	private int  currPlace;
	private int[] playerPlace;

	
	public Players(String name) {
		
		this.name = name;
		playerPlace = new int[] {-1,-1};
		currPlace = 0;
		
	}
	public int[] getPlayerPlace() {
		return playerPlace;
	}
	public void setPlayerPlace(int[] playerPlace) {
		this.playerPlace = playerPlace;
	}
	public int getCurrPlace() {
		return currPlace;
	}
	public void setCurrPlace(int currPlace) {
		this.currPlace = currPlace;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

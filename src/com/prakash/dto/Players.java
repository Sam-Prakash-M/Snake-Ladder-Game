package com.prakash.dto;

public class Players {
	private String name;
	private int  currPlace;
	

	
	public Players(String name) {
		
		this.name = name;
		
		currPlace = 0;
		
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

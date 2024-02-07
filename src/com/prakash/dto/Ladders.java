package com.prakash.dto;

public class Ladders {

	
	private int topPos,bottomPos;

	public Ladders(int topPos, int bottomPos) {
		
		
		this.topPos = topPos;
		this.bottomPos = bottomPos;
	}

	public int getTopPos() {
		return topPos;
	}

	public void setTopPos(int topPos) {
		this.topPos = topPos;
	}

	public int getBottomPos() {
		return bottomPos;
	}

	public void setBottomPos(int bottomPos) {
		this.bottomPos = bottomPos;
	}


}

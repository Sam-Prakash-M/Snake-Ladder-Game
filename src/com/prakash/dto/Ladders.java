package com.prakash.dto;

public class Ladders {

	private int[] bottom , top;
	private int topPos,bottomPos;

	public Ladders(int[] top, int[] bottom,int topPos, int bottomPos) {
		
		this.top = top;
		this.bottom = bottom;
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

	public int[] getBottom() {
		return bottom;
	}

	public void setBottom(int[] bottom) {
		this.bottom = bottom;
	}

	public int[] getTop() {
		return top;
	}

	public void setTop(int[] top) {
		this.top = top;
	}
}

package com.prakash.dto;

public class Snakes {
	
	private int [] head , tail;
	private int headPos,tailPos;

	public Snakes(int[] head, int[] tail,int headPos,int tailPos) {
		
		this.head = head;
		this.tail = tail;
		this.headPos = headPos;
		this.tailPos = tailPos;
	}

	public int getHeadPos() {
		return headPos;
	}

	public void setHeadPos(int headPos) {
		this.headPos = headPos;
	}

	public int getTailPos() {
		return tailPos;
	}

	public void setTailPos(int tailPos) {
		this.tailPos = tailPos;
	}

	public int[] getHead() {
		return head;
	}

	public void setHead(int[] head) {
		this.head = head;
	}

	public int[] getTail() {
		return tail;
	}

	public void setTail(int[] tail) {
		this.tail = tail;
	}

}

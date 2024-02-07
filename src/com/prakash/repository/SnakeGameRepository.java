package com.prakash.repository;

import java.util.ArrayList;
import java.util.List;

import com.prakash.dto.Ladders;
import com.prakash.dto.Players;
import com.prakash.dto.Snakes;

public class SnakeGameRepository {
	
	private static final SnakeGameRepository SINGLE_OBJECT = new SnakeGameRepository();
	
	public static List<Snakes> SnakeList = new ArrayList<>(); 

	public static List<Ladders> laddersList = new ArrayList<>(); 
	
	public static List<Integer> minimumPath = new ArrayList<>();
	
	

	public static List<Players> playersList = new ArrayList<>(); 
	
	
	
	public static SnakeGameRepository getInstance() {
		
		return SINGLE_OBJECT;
	}

}

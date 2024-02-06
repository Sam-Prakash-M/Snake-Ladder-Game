package com.prakash.baseView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.prakash.dto.Players;
import com.prakash.repository.SnakeGameRepository;

public class BaseView {

	private BaseViewModel baseViewModel;
	private Scanner scanner = new Scanner(System.in);
    
	
	
	public BaseView() {

		this.baseViewModel = new BaseViewModel(this);
	}

	public void startTheGame() {

		System.out.println("Enter a Board Size : ");
		int size = scanner.nextInt();
		baseViewModel.setBoardSize(size);
		
		
		System.out.println("Enter a Number of Snakes");
		int noOfSnakes = scanner.nextInt();

		for (int i = 0; i < noOfSnakes; i++) {

			System.out.println("Enter a head Position of Snake  "+(i+1));
			
			int headPos = scanner.nextInt();
			int[] head = new int[2];
			baseViewModel.setCorrectPlaceInBoard(head,size,headPos);
			
			System.out.println("Enter a tail Position of Snake : "+(i+1));
			
			int tailPos = scanner.nextInt();
			int[] tail = new int[2];
			baseViewModel.setCorrectPlaceInBoard(tail,size,tailPos);
			
			baseViewModel.setSnakePlaces(head,tail,headPos,tailPos);

		}
		System.out.println("Enter a Number of Ladders : ");
		
		int noOfLadders = scanner.nextInt();
		for (int i = 0; i < noOfLadders; i++) {

			System.out.println("Enter a top Position of Ladder  : "+(i+1));
			
			int topPos = scanner.nextInt();
			int[] top = new int[2];
			baseViewModel.setCorrectPlaceInBoard(top,size,topPos);
			System.out.println("Enter a Bottom Position of Ladder  : "+(i+1));
			int bottomPos = scanner.nextInt();
			int[] bottom = new int[2];
			baseViewModel.setCorrectPlaceInBoard(bottom,size,bottomPos);
			
			baseViewModel.setLadderPlaces(top,bottom,topPos,bottomPos);

		}
		
		System.out.println("Enter a Number of Players : ");
		
		int noOfPlayers = scanner.nextInt();
		
		for(int i = 0 ; i < noOfPlayers ; i++) {
			
			System.out.println("Enter a Name of Player : "+(i+1));
			String name = scanner.next();
			baseViewModel.setPlayerDetails(name);
		}
		
		System.out.println("1) System Play : "+"\n2)Optimized Play : ");
		//int choice = scanner.nextInt();
		//if(choice == 1) {
			startPlayerByPlayer(size);
		//}
		//else {
			//baseViewModel.findMinimumWayToAcheiveDestination(size*size);
		//}
		

	}

	private void startPlayerByPlayer(int size) {
		
		List<Players> player = SnakeGameRepository.playersList;
		
		
		EntireGame : while(true) {
			for(int i = 0 ; i < player.size() ; i++) {
				
				
				if(baseViewModel.startPlaying(player.get(i),size)) {
					
					System.out.println(player.get(i).getName()+" Wins");
					break EntireGame;
				}
			}
		}
		
		
	}
}
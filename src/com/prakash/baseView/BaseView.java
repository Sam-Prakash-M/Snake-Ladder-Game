package com.prakash.baseView;

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
			
			
			
			System.out.println("Enter a tail Position of Snake : "+(i+1));
			
			int tailPos = scanner.nextInt();
			
			
			
			baseViewModel.setSnakePlaces(headPos,tailPos);

		}
		System.out.println("Enter a Number of Ladders : ");
		
		int noOfLadders = scanner.nextInt();
		for (int i = 0; i < noOfLadders; i++) {

			System.out.println("Enter a top Position of Ladder  : "+(i+1));
			
			int topPos = scanner.nextInt();
			
			
			System.out.println("Enter a Bottom Position of Ladder  : "+(i+1));
			int bottomPos = scanner.nextInt();
			
			
			
			baseViewModel.setLadderPlaces(topPos,bottomPos);

		}
		
		System.out.println("Enter a Number of Players : ");
		
		int noOfPlayers = scanner.nextInt();
		
		for(int i = 0 ; i < noOfPlayers ; i++) {
			
			System.out.println("Enter a Name of Player : "+(i+1));
			String name = scanner.next();
			baseViewModel.setPlayerDetails(name);
		}
		
		System.out.println("1) System Play : "+"\n2)Optimized Play : "+"\n3) Probability Check");
		int choice = scanner.nextInt();
		if(choice == 1) {
			startPlayerByPlayer(size);
		}
		else if(choice == 2) {
			baseViewModel.findMinimumWayToAcheiveDestination(size*size);
		}
		else {
			
			System.out.println("Enter a Position to Check : ");
			int position = scanner.nextInt();
			baseViewModel.checkProbability(position, size*size);
		}
		

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

	public void showStatus(String status) {
		
		System.out.println(status);
	}
}

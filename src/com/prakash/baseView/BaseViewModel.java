package com.prakash.baseView;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

import com.prakash.dto.Ladders;
import com.prakash.dto.Players;
import com.prakash.dto.Snakes;
import com.prakash.repository.SnakeGameRepository;

public class BaseViewModel {

	private BaseView baseview;

	public BaseViewModel(BaseView baseView) {

		this.baseview = baseView;
	}

	public void setSnakePlaces(int[] head, int[] tail, int headPos, int tailPos) {

		Snakes snake = new Snakes(head, tail, headPos, tailPos);

		SnakeGameRepository.SnakeList.add(snake);

	}

	public void setLadderPlaces(int[] top, int[] bottom, int topPos, int bottomPos) {

		Ladders ladder = new Ladders(top, bottom, topPos, bottomPos);
		SnakeGameRepository.laddersList.add(ladder);

	}

	public void setPlayerDetails(String name) {

		Players player = new Players(name);
		SnakeGameRepository.playersList.add(player);

	}

	public boolean startPlaying(Players player, int size) {

		ThreadLocalRandom randomNumber = ThreadLocalRandom.current();

		int number = randomNumber.nextInt(1, 7);
		System.out.println("Random  Number is : " + number);
		if (isPossibleToMove(number, player)) {

			int[] playerPlace = player.getPlayerPlace();
			int newPlace = player.getCurrPlace() + number;
			System.out.println(player.getName() + " Rolled a " + number + " and" + " moved from "
					+ player.getCurrPlace() + " to " + newPlace);
			player.setCurrPlace(newPlace);

			setCorrectPlaceInBoard(playerPlace, size, newPlace);

			LadderUps(player);

			snakesDown(player);

			if (playerPlace[0] == 0 && playerPlace[1] == 0) {
				return true;
			}

		}

		return false;

	}

	private void snakesDown(Players player) {

		List<Snakes> list = SnakeGameRepository.SnakeList;

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getHeadPos() == player.getCurrPlace()) {

				System.out.println(player.getName() + " Attacked by Snake and getting fallen from"
						+ player.getCurrPlace() + " to " + list.get(i).getTailPos());
				player.setCurrPlace(list.get(i).getTailPos());
				break;
			}

		}

	}

	private void LadderUps(Players player) {

		List<Ladders> list = SnakeGameRepository.laddersList;

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getBottomPos() == player.getCurrPlace()) {

				System.out.println(player.getName() + " Moves up through the ladder from" + player.getCurrPlace()
						+ " to " + list.get(i).getTopPos());
				player.setCurrPlace(list.get(i).getTopPos());
				break;
			}

		}

	}

	private boolean isPossibleToMove(int number, Players player) {

		int[] playerPlace = player.getPlayerPlace();
		int currPlace = playerPlace[0];
		if (currPlace == 0) {

			if (playerPlace[1] - number >= 0) {
				return true;
			}
			return false;
		}

		return true;
	}

	public void setBoardSize(int size) {
		SnakeGameRepository.getInstance().board = new int[size][size];

	}

	public void setCorrectPlaceInBoard(int[] array, int size, int pos) {

		int quotient = pos / size, rem = pos % size, row, col;

		row = (size - 1) - (rem % size == 0 ? (quotient - 1) : quotient);

		if (row % 2 == 0) {

			col = pos % size == 0 ? 0 : size - (pos % size);
		} else {
			col = pos % size == 0 ? (size - 1) : (pos % size - 1);
		}

		array[0] = row;
		array[1] = col;

	}

	public void findMinimumWayToAcheiveDestination(int destination) {

		Queue<List<Integer>> path = new LinkedList<>();
		
		int minPathCount = Integer.MAX_VALUE;

		List<Integer> minimumPath = SnakeGameRepository.minimumPath;

		for (int i = 1; i <= 6; i++) {

			List<Integer> currentPath = new LinkedList<>();
			int ladderUps = ladderUps(i);
			int snakeDown = snakeDown(i);
			currentPath.add(i);
			if(ladderUps > 0) {
				currentPath.set(0,ladderUps);
			}
			else if(snakeDown > 0) {
				currentPath.set(0,snakeDown);
			}
			
			
			path.offer(currentPath);

		}
    System.out.println("Path is "+path);
		while (!path.isEmpty()) {
			List<Integer> currentPath = path.poll();
			
			for (int i = 1; i <= 6; i++) {
				
				List<Integer> newPath = new LinkedList<>(currentPath);
					System.out.println("Current Path is : "+currentPath);
				int currentDestination = newPath.get(newPath.size() - 1) + i;
				if (currentDestination == destination) {
					
					newPath.add(currentDestination);
					if ( newPath.size() < minPathCount ) {
						minPathCount = newPath.size();
						minimumPath = newPath;
					}
					break;
					
				} else if (currentDestination < destination) {
					
					int ladderUps = ladderUps(currentDestination);
					int snakeDown = snakeDown(currentDestination);
					if(ladderUps > 0) {
						newPath.add(ladderUps);
					}
					else if(snakeDown > 0) {
						
						for(int j = currentPath.size() - 1 ; j >= 0 ;j--) {
							
							if(snakeDown < currentPath.get(j)) {
								newPath.remove(j);
							}
							else {
								newPath.add(snakeDown);
								break;
							}
						}
						
					}
					else {
						newPath.add(currentDestination);
					}
					
					path.offer(newPath);
					
				}
				else {
					break;
				}

			}
		}

		System.out.println(minimumPath);
		

	}

	private int snakeDown(int currentDestination) {

		List<Snakes> list = SnakeGameRepository.SnakeList;
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getHeadPos() == currentDestination) {

				return list.get(i).getTailPos();
			}
		}
		return 0;
	}

	private int ladderUps(int currentDestination) {
		List<Ladders> list = SnakeGameRepository.laddersList;

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getBottomPos() == currentDestination) {

				return list.get(i).getTopPos();
			}
		}
		return 0;
	}

}
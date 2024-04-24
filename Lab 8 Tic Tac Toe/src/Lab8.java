/*
 * Vincent Fealy
 * Lab 8
 * Tic-Tac-Toe game
 * uses multi-dimensional arrays to organize a tic tac toe board
 * Then checks for a winner in a text file
 */
import java.io.File;
import java.util.Scanner;
public class Lab8 {
		public static void main(String[] args) {
			boolean gameEnd = false;
			char[][] gameBoard = new char[3][3];
				
				System.out.println("Welcome to the Tic-Tac-Toe winner check program!\n");
				
				while(!gameEnd) { 
					Scanner sc = new Scanner(System.in);
					
					System.out.println("Please enter the name of a file to check: ");
					String userinput = sc.nextLine();
					
					try {
						Scanner sc2 = new Scanner(new File(userinput));
						//in this while loop must convert over to char
						while(sc2.hasNextLine()) {
							for(int i = 0; i < gameBoard.length; i++) {
								String temp = sc2.nextLine().replaceAll(" ", "");
								char[] curr = new char[3];
								for(int j = 0; j < temp.length(); j++) {
									curr[j] = temp.charAt(j);
								}
								for(int j = 0; j < curr.length; j++) {
									gameBoard[i][j] = curr[j];
								}
							}
						}
						
						if(checkWinner(gameBoard) == 'X') {
							System.out.println("X is the winner of this game!");
						} else if (checkWinner(gameBoard) == 'O') {
							System.out.println("O is the winner of this game!");
						} else {
							System.out.println("Nobody wins yet!");
						}
						
						
						System.out.println("Test another (y/n)? ");
						String another = sc.nextLine().toLowerCase();
						if(another.equals("n")) {
							gameEnd = true;
						}
						
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("File was invalid. Try again!");
					}
						
				}
				System.out.println("Goodbye!");
		 
			}
			
			public static char checkWinner(char[][] gameBoard) {
				for(int i = 0; i <gameBoard.length; i++) {
					if(gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2]) {
						return gameBoard[i][0];
					}
				}
				
				//Ultimatley checks for Tic-Tac-Toe
				for(int i = 0; i < gameBoard.length; i++) {
					if(gameBoard[0][i] == gameBoard[1][i] &&gameBoard[1][i] == gameBoard[2][i]) {
						return gameBoard[0][i];
					}
				}
			
				//This will check the printed board for found diagonals.
				if(gameBoard[0][0] == gameBoard[1][1] &&gameBoard [1][1] == gameBoard[2][2]) {
					return gameBoard[0][0];
				}
				
				if(gameBoard[0][2] == gameBoard[1][1] &&gameBoard[1][1] == gameBoard[2][0]) {
					return gameBoard[0][2];
				}
				return '_';
			}
		
		}


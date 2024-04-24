/*
 * Vincent Fealy
 * Project 2
 * Tic Tac toe
 */
import java.util.Scanner;
//import java.io.File;
public class TicTacToe {
	public char[][] board;
    public boolean itsX;
    public Scanner sc;

    public TicTacToe()  {



    itsX = true;
    sc = new Scanner(System.in);

        board = new char[3][3];

        for(int i = 0; i < 3; i++)  {

            for(int j = 0; j < 3; j++)
                board[i][j] = ' ';
        }
    }

        public void displayRow(int row)  {

            System.out.println(" " + board[row][0] + " | " + board[row][1] + " | " + board[row][2]);
        }

        public void gameBoard()  {

            displayRow(0);
            System.out.println(" ---------");
            displayRow(1);
            System.out.println(" ---------");
            displayRow(2);
            System.out.println("Enter the first number between 0-2 for the row, then a space followed by another number between 0-2 for the column space.");
        }

        public boolean getMove()  {

            boolean wrong = true;
            int row = 0, column = 0;

            while(wrong)  {

                row = sc.nextInt();
                column = sc.nextInt();

                if(row >= 0 && row <= 2 && column >= 0 && column <= 2)  {

                    if(board[row][column] != ' ')
                        System.out.println("A move has already been made there!");
                    else
                        wrong = false;
                }
            }

            if(itsX)
                board[row][column] = 'X';
            else
                board[row][column] = 'O';

            return winner(row,column);
        }

        public boolean winner(int lastR, int lastC)  {

            boolean winner = false;
            char symbol = board[lastR][lastC];

            int numFound = 0;
            for(int i = 0; i < 3; i++)  {
                if(board[lastR][i] == symbol)
                    numFound++;
            }

            if(numFound == 3)
                winner = true;

            numFound = 0;
            for(int r = 0; r < 3; r++)  {
                if(board[r][lastC] == symbol)
                    numFound++;
            }

            if(numFound == 3)
                winner = true;

            numFound = 0;
            for(int i = 0; i < 3; i++)  {
                if(board[i][i] == symbol)
                    numFound++;
            }

            if(numFound == 3)
                winner = true;

            numFound = 0;
            for(int i = 0; i < 3; i++)  {
                if(board[i][2-i] == symbol)
                    numFound++;
            }

            if(numFound == 3)
                winner = true;

            return winner;
        }


        public boolean boardFull()  {

            int boardFull = 0;

            for(int r = 0; r < 3; r++)  {

                for(int c = 0; c < 3; c++)  {
                    if(board[r][c] == 'X' || board[r][c] == 'O')
                        boardFull++;
                }
            }

            return boardFull == 9;

        }

        public void Tic()  {
            while(true)  {
                gameBoard();

                if(itsX)
                    System.out.println("It's X's Turn!");
                else
                    System.out.println("It's O's Turn!");

                int choice = sc.nextInt();

                if(choice == 1)  {

                    if(getMove())  {
                       
                        gameBoard();

                        if(itsX)
                            System.out.println("X Wins!");
                        else
                            System.out.println("O Wins!");

                        System.exit(0);
                    }
                    else if(boardFull())  {
                        
                        gameBoard();

                        System.out.println("Tie!");

                        System.exit(0);
                    }
                    else  {
                   
                        itsX = !itsX;
                    }
                }
            }
    }
       // catch (Exception e) {
			//e.printStackTrace();
		//	System.out.println("File was invalid. Try again!");
	//	}

    public static void main(String[] args){
                    TicTacToe game = new TicTacToe();

                    game.Tic();
                }

}

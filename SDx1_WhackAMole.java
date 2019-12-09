/*Author: TrannyCyborg
 * Assignment: Week 1 Homework 1
 * Instructor: Dr. Arvind Bhusnurmath
 * Date: 2019/12/06	*/

package wk1homework;

import java.util.*;

public class WhackAMole {
	/*Initiate instance variables called score, molesLeft, and attemptsLeft. 
	Make one more instance variable called moleGrid which is a 2-dimensional 
	array of chars	*/
	int score = 0;
	int molesLeft = 0;
	int attemptsLeft;
	char[][] moleGrid;
	
	/*WhackAMole(int numAttempts, int gridDimension) - Constructor for the game, 
	 * specifies total number of whacks allowed, and the grid dimension. After 
	 * reading through the assignment, make sure to initialize the moleGrid with 
	 * the appropriate character.*/
	public WhackAMole(int numAttempts, int gridDimension) {
		//Initiate the instance variables with the local variable value
		attemptsLeft = numAttempts;
		moleGrid = new char[gridDimension][gridDimension];
		/*Fill each element in the array with an asterix */
		for (int i = 0; i < moleGrid.length; i++) {
			for (int j = 0; j < moleGrid.length; j++) {
				moleGrid[i][j] = '*';
			}
		}
	}
	
	/*boolean place(int x, int y) – Given a location, place a mole at that location. 
	 * Return true if you can. (Also update number of moles left.)*/
	public boolean place(int x, int y) {
		if (moleGrid[x][y] == 'M') {
			return false;
		}else {
			this.moleGrid[x][y] = 'M';
			this.molesLeft += 1;
			return true;
		}
	}
	
	/*void whack(int x, int y) -  Given a location, take a whack at that location. 
	 * If that location contains a mole, the score, number of attemptsLeft, and 
	 * molesLeft is updated. If that location does not contain a mole, only attemptsLeft 
	 * is updated.*/
	public void whack(int x, int y) {
		//decrement attemptsLeft by 1
		this.attemptsLeft--;
			if (moleGrid[x][y] == 'M') { //If there is a mole then change to 'W'
				this.score++;
				this.molesLeft--;
				this.moleGrid[x][y] = 'W';
				System.out.println("You whacked a mole!");
				System.out.println("Score: " + this.score);
				System.out.println("You have " + this.attemptsLeft + " attempts left.");
			}else {
				System.out.println("You missed!"); //Inform user they missed
				System.out.println("Score: " + this.score);
				System.out.println("You have " + this.attemptsLeft + " attempts left.");
			}
		}
	/*void printGridToUser() – Print the grid without showing where the moles are. 
	 * For every spot that has recorded a “whacked mole,” print out a W, or * otherwise.*/
	public void printGridToUser() {
		for (int i = 0; i < moleGrid.length; i++) {
			System.out.println("---+---+---+---+---+---+---+---+---+---+");
			for (int j = 0; j < moleGrid.length; j++) {
				if (moleGrid[i][j] == 'M') {
					System.out.print(" * |");
				}else {
				System.out.print(" " + moleGrid[i][j] + " |");
				}
			}
			System.out.println();
		}
	}
	
	/*void printGrid() -  Print the grid completely. This is effectively dumping the 2d 
	 * array on the screen. The places where the moles are should be printed as an ‘M’. 
	 * The places where the moles have been whacked should be printed as a ‘W’. The places 
	 * that don’t have a mole should be printed as *.*/
	public void printGrid() {
		for (int i = 0; i < moleGrid.length; i++) {
			System.out.println("---+---+---+---+---+---+---+---+---+---+");
			for (int j = 0; j < moleGrid.length; j++) {
				System.out.print(" " + moleGrid[i][j] + " |");
			}
			System.out.println();
		}
	}
	/*Putting it all together - main method
	  *In order to play this game you need to create a main method. 
      *Begin by creating a 10 by 10 grid where you randomly place the moles. 
      *Place a total of 10 moles.Now allow the user (remember how to use Scanner?) 
      *to enter the x and y coordinates of where they would like to take a whack. 
      *Tell them they have a maximum of 50 attempts to get all the moles. At any 
      *point in the game, they can input coordinates of -1, -1 in order to indicate 
      *that they are giving up. If the user gives up they get to see the entire grid.  
      *The game ends if the user is able to uncover all the moles or if the user runs 
      *out of attempts. 
    */
	public static void main(String[] args) {
		//Initiate a new game with 50 attempts and a 10 x 10 grid.
		WhackAMole newGame = new WhackAMole(50, 10);
		//Populate the array at random
		Random rando = new Random();
		for (int i = 0; i < 10; i++) { 
			newGame.place(rando.nextInt(10), rando.nextInt(10));
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter coordinates between 0 and 9. Good Luck!");
		
		while (newGame.attemptsLeft > 0 && newGame.molesLeft > 0) {
			//Print the grid to the user
			newGame.printGridToUser();
			//Print the game information score, attempts left, and moles left to user
			System.out.println("Your score is: " + newGame.score);
			System.out.println("You have " + newGame.attemptsLeft + " attempts left");
			System.out.println("There are " + newGame.molesLeft + " moles left.");
			System.out.print("Enter coordinates to whack! ");
			//Get the coordinates from the user input
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			if (x == -1 && y == -1) { //allows the user to exit the game
				System.out.println("Game Over!");
				newGame.attemptsLeft = 0; //this ends the game
				newGame.printGrid();
			}else if (x > 10 || x < -1 || y < -1 || y > 10){ //error checking if user coordinates are out of bounds
				System.out.println("Bad coordinates. Try again!");
			}else {
				newGame.whack(x, y); //if coordinates are good then whack a mole!
			}
		}
		System.out.println("Game over!"); //Inform user the game is over	
	}
	
	/*REFERENCES: 
	 * Reges, S., & Stepp, M. (2014). Building Java programs: a back to basics approach. Hoboken, NJ: Pearson.*/
}

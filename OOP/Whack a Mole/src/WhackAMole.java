import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WhackAMole {
	int score;
	int molesLeft;
	int attemptsLeft;
	char[][] moleGrid;

	public WhackAMole(int numAttempts, int gridDimension){
		attemptsLeft = numAttempts;
		score = 0;
		molesLeft = 0;
		moleGrid = new char[gridDimension][gridDimension];
		for(char[] c : moleGrid)
			Arrays.fill(c, '*');
	}

	public boolean place(int x, int y){
		if (moleGrid[x-1][y-1] != 'M'){
			moleGrid[x-1][y-1] = 'M';
			molesLeft++;
			return true;
		}

		return false;
	}

	public void whack(int x, int y){
		attemptsLeft--;

		if (moleGrid[x-1][y-1] == 'M'){
			score++;
			molesLeft--;
		}else{
			moleGrid[x-1][y-1] = 'W';
		}
	}

	public void printGridToUser(){
		for (int i=0; i < moleGrid.length; i++){
			for (int j=0; j < moleGrid[i].length; j++){

				if (moleGrid[i][j] != 'W'){
					System.out.print("*\t");
				}else{
					System.out.print("W\t");
				}

			}

			System.out.print("\n");
		}
	}

	public void printGrid(){
		for (int i=0; i < moleGrid.length; i++){
			for (int j=0; j < moleGrid[i].length; j++){

				System.out.print(moleGrid[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}


	public static void main(String[] args){
		WhackAMole game = new WhackAMole(50, 10);

		//creating using the random java method a place to put the 10 moles
		Random r = new Random();
		int x, y;
		for (int i=0; i < 10; i++){
			while(true) {
				x = r.nextInt((10 - 1) + 1) + 1;
				y = r.nextInt((10 - 1) + 1) + 1;
				if (game.place(x, y))
					break;
			}
		}

		System.out.println("Warning: You have a maximum of 50 attempts to get the 10 moles!");
		System.out.println("(row, column) = (-1, -1) to quit");

		Scanner sc = new Scanner(System.in);

		int count = 1;
		x = 0;
		y = 0;

		while (count <= 50 && game.molesLeft > 0){
			System.out.print("row = ");
			x = sc.nextInt();

			System.out.print("column = ");
			y = sc.nextInt();

			if (x != -1 && y != -1) {
				game.whack(x, y);
				count++;
				game.printGridToUser();
			}else{
				break;
			}
		}

		if (x == -1 && y == -1) //print grid in case of give up
			game.printGrid();

	}
}

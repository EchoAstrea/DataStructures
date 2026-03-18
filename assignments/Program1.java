/*
 * Tessa Dalbo
 * Program 1
 * due 9/2/2025
 * This program starts an Memory Game that can allow 
 * the user to play along through user input
*/

package assignments;
import java.util.*;
import java.util.Scanner;


class Card{
	int value;
	boolean isMatched;
	boolean isFlipped;
	
	public Card(int value) {
		this.isMatched=false;
		this.isFlipped=false;
		this.value=value;
	}
}

public class Program1 {
	private int size=4;
	private Card[][] board=new Card[size][size];
	private Scanner scan = new Scanner(System.in);
	
	public static void main(String args[]) {
		Program1 game=new Program1();
		game.setBoard();
		game.playGame();
		
	}
	private void setBoard() {
		int[] values=new int[16];
		int index=0;
		for(int v=1; v<=8; v++) {
			values[index++]=v;
			values[index++]=v;
		}
		shuffle(values);
		index=0;
		for(int r=0; r<size; r++) {
			for(int c=0; c<size; c++) {
				board[r][c]=new Card(values[index]);
				index++;
			}
		}
	}
	//Shuffles the numbers each game
	private void shuffle(int[]arr) {
		Random rand= new Random();
		for(int i=arr.length-1; i>0; i--) {
			int j=rand.nextInt(i+1);
			int temp=arr[i];
			arr[i]= arr[j];
			arr[j]=temp;
			
		}
	}
	//Checks to see if you have matched all the cards
	private boolean allMatched() {
		for(int r=0; r<size; r++) {
			for(int c=0; c<size; c++) {
				if(!(board[r][c].isMatched)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private void showBoard() {
		System.out.println("Memory Game:");
		System.out.println("  1 2 3 4 ");
		for(int r=0; r<size; r++) {
			System.out.print((r+1)+" ");
			for(int c=0; c<size; c++) {
				Card card=board[r][c];
			if(card.isFlipped || card.isMatched) {
				System.out.print(card.value+" ");
			}
			else {
				System.out.print("* ");
			}
			}
			System.out.println();
		}
		System.out.println();
	}	
	
	private void clearScreen() {
		for(int i=0; i<50; i++) {
			System.out.println();
		}
	}
	
	private void playGame() {
		while(!allMatched()) {
			showBoard();
		//First Card
		System.out.println("Make sure to put a space between the row and col");
		System.out.println("Pick the First Card (row & col (1-4)): ");
		int r1 = scan.nextInt();
		int c1=scan.nextInt();
		board[r1][c1].isFlipped=true;
		showBoard();
		
		//Second Card
		System.out.println("Make sure to put a space between the row and col");
		System.out.println("Pick the Second Card (row & col 1-4)): ");
		int r2 = scan.nextInt();
		int c2=scan.nextInt();
		board[r2][c2].isFlipped=true;
		showBoard();
		
		//Check match
		if(board[r1][c1].value == board[r2][c2].value) {
			System.out.println("Match");
			board[r1][c1].isMatched=true;
			board[r2][c2].isMatched=true;
		}
		else {
			System.out.println("NO Match");
		    System.out.println("Press Enter to continue...");
		    scan.nextLine();
		    scan.nextLine();
            board[r1][c1].isFlipped = false;
            board[r2][c2].isFlipped = false;
			
		}
		clearScreen();
		}
		System.out.print("You matched all the cards. Game Over");
	}
	
	}










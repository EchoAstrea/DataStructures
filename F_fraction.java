/*
 * Tessa Dalbo
 * Program 4
 * due 10/02/2025
 *  F-fraction sequence generator that creates linked lists of fractions at different levels,
 *  implementing it two ways - DLL Lab Class and Java's Linked List
 * 
 */
package lab;

import java.util.LinkedList;
import java.util.Scanner;

public class F_fraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		boolean running=true;
		System.out.println("Fraction Sequence Generator");
		while(running) {
			System.out.print("Enter the level n: ");
			while(!scan.hasNextInt()) {
				System.out.println("Please enter an Integer");
				scan.next();
				System.out.print("Enter the level n: ");
			}
			int n=scan.nextInt();
			if(n<1) {
				System.out.println("Level must at least be 1");
				continue;
			}
			System.out.println("Using F1:");
			F1 f1=new F1();
			f1.initialize();
			f1.buildLevel(n);
			f1.display();

			
			
			System.out.println("Using F2:");
			F2 f2=new F2();
			f2.initialize();
			f2.buildToLevel(n);
			f2.display();
			
			
			System.out.println();
			System.out.println("Would you like to continue? \nPress n to Stop or Enter to Continue: ");
			scan.nextLine();
			String choice=scan.nextLine().toLowerCase();
			if(choice.equals("n")) {
				running=false;
				System.out.println("Program Done");
			}
			else {
				System.out.println("Ready to Continue:");
				
			}
		}
		scan.close();

		

	}
}



class Fraction{
	private int num;
	private int den;
	
	public Fraction(int n, int d) {
		this.num=n;
		this.den=d;
	}
	public int getNum() {
		return num;
	}
	public int getDen() {
		return den;
	}
	@Override
	public String toString() {
		return num+"/"+den;
	}
}

class F1 extends DLL<Fraction>
{
	public void initialize() {
		this.insertAtHead(new Fraction(1,1));
		this.insertAtHead(new Fraction(0,1));
	}
	
	public void buildLevel(int n) {
		for(int i=2; i<=n; i++) {
			buildSingleLevel(i);
			
		}
	}
	
	private void buildSingleLevel(int currentLevel) {
		DLLNode<Fraction> current=this.head;
		while(current!=null && current.next!=null) {
			Fraction left=current.info;
			Fraction right=current.next.info;
		
			if(left.getDen()+right.getDen()<=currentLevel) {
				int newNum=left.getNum()+right.getNum();
				int newDen=left.getDen()+right.getDen();
				
				Fraction newF=new Fraction(newNum, newDen);
				
				DLLNode<Fraction> newNode=new DLLNode<>(newF);
				
				newNode.next=current.next;
				newNode.prev=current;
				current.next.prev=newNode;
				current.next=newNode;
				current=newNode.next;
				
;			}
			else {
				current=current.next;
			}
			
	}
	}
	
	public void display() {
		System.out.print("Sequence: ");
		this.print();
	}
	
	
}

class F2 extends LinkedList<Fraction>{
	public void initialize() {
		this.add(new Fraction(0,1));
		this.add(new Fraction(1,1));
	}
	
	public void buildToLevel(int n) {
		for(int i=0; i<=n; i++) {
			buildSingleLevel(i);
			
		}
	}
	private void buildSingleLevel(int currentLevel) {
		for(int i=this.size()-2; i>=0; i--) {
			Fraction left=this.get(i);
			Fraction right=this.get(i+1);
			
			if(left.getDen()+right.getDen()<=currentLevel) {
				int newNum=left.getNum()+right.getNum();
				int newDen=left.getDen()+right.getDen();
				Fraction newF=new Fraction(newNum, newDen);
				this.add(i+1, newF);
				}
		}
	}
	public void display() {
		System.out.print("Sequence: ");
		for(Fraction f:this) {
			System.out.print(f+" ");
		}
		System.out.println();
	}
	

}

	

		



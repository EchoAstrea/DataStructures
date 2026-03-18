/*
 * Tessa Dalbo
 * Program 5
 * due 10/16/2025
 * A Java program that uses recursion to search for, count, 
 * and remove a specific character from a user-provided string
 * 
 */

package programs;
import java.util.Scanner;

public class Recursion {
	
	
	public static boolean contains(String str, char ch){
		if(str.isEmpty()) {
			return false;
		}
		if(str.charAt(0)==ch) {
			return true;
		}
		return contains(str.substring(1),ch);
	}
	
	public static int count(String str, char ch) {
		if(str.isEmpty()) {
			return 0;
		}
		int count;
		if(str.charAt(0)==ch) {
			count=1;
		}
		else {
			count=0;
		}
		return count+ count(str.substring(1), ch);
		
	}
	
	public static String remove(String str, char ch) {
		if(str.isEmpty()) {
			return "";
		}
		if(str.charAt(0)==ch) {
			return remove(str.substring(1),ch);
		}
		return str.charAt(0)+ remove(str.substring(1),ch);
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan= new Scanner(System.in);
		System.out.print("Enter a string: ");
		String strInput=scan.nextLine();
		
		System.out.println("Enter a char to search for: ");
		String charInput=scan.nextLine();
		
		if(charInput.isEmpty()) {
			System.out.println("No char entered.");
			scan.close();
			return;
		}
		
		char ch=charInput.charAt(0);
		
		System.out.println("Results:");
		boolean contains= contains(strInput, ch);
		System.out.println("Does this string have "+ch+" ?");
		System.out.println(contains);
		
		int count=count(strInput, ch);
		System.out.println("Number of occurences: ");
		System.out.println(count);
		
		String removed=remove(strInput, ch);
		System.out.println("String after removing "+ch+":");
		System.out.println(removed);
		
		scan.close();
		

	}

}

/*
 * Tessa Dalbo
 * Program 3
 * due 9/18/2025
 * This program converts decimal numbers to bases 2-27 using a stack.
* Users input a decimal number and base, and the program outputs
* the converted result using the division and stack reversal.
 */
package programs;
import java.util.Scanner;
import java.util.Stack;

public class NumberSystem {

    public static String convertToBase(int decimal, int base, Stack<Character> stack) {
        if(decimal==0) {
            return "0";
        }
        stack.clear();
        while(decimal>0) {
            int remainder=decimal%base;
            if(remainder<10) {
                stack.push((char)(remainder+'0'));
            }
            else {
                stack.push((char)(remainder-10+'A'));
            }
            decimal/=base;
        }
        String result="";
        while(!stack.isEmpty()) {
            result+=(char)stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);
        Stack<Character> stack = new Stack<Character>();
        boolean running=true;
        while (running) {
            System.out.print("Enter decimal number: ");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number.");
                scan.next();
                System.out.print("Enter decimal number: ");
            }
            int decimal = scan.nextInt();
            int base;
            while (true) {
                System.out.print("Enter base (2-27): ");
                if (!scan.hasNextInt()) {
                    System.out.println("Invalid choice. Please enter a number.");
                    scan.next();
                    continue;
                }
                base = scan.nextInt();
                if (base >= 2 && base <= 27) {
                    break;
                } else {
                    System.out.println("Invalid choice. Base must be between 2 and 27.");
                }
            }

            String result = convertToBase(decimal, base, stack);
            System.out.println("Result: " + result);

            System.out.println("Would you like to continue (y/n)?");
            scan.nextLine();
            String choice = scan.nextLine().trim().toLowerCase();

            if (choice.equals("n")) {
                running = false;
                System.out.println("Program done");
        	
        }
        }
        scan.close();
        
    }
}

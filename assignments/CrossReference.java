/*
 * Tessa Dalbo
 * Program 7
 * due 11/20/2025
 * A Java program that generates an alphabetized cross-reference index of words from a text file, 
 * using a hash table with linear probing to store each word along with the line numbers where it appears. 
 */
package programs;
import java.io.*;
import java.util.*;

class Word implements Comparable<Word>{
	String w;
	Node lines;

	Word(String word, int line){
		w = word.toLowerCase();
		lines = new Node(line);
	}

	void addLine(int line) {
		for(Node n = lines; n != null; n = n.next) {
			if(n.line == line) return;
		}
		Node temp = new Node(line);
		temp.next = lines;
		lines = temp;
	}
	
	boolean equals(String other) {
		return w.equalsIgnoreCase(other);
	}

	public String toString() {
		List<Integer> list = new ArrayList<>();
		for(Node n = lines; n != null; n = n.next) {
			list.add(n.line);
		}
		Collections.sort(list);
		String result = w;
	    for(int lineNum : list) {
	        result = result + " " + lineNum;
	    }
	    return result;
	}

	
	public int compareTo(Word o) {
		return w.compareTo(o.w);
	}
}

class Node{
	int line;
	Node next;
	
	Node(int line){
		this.line = line;
	}
}

public class CrossReference {
	static final int SIZE = 100;

	static int hash(String w) {
		int sum = 0;
		for(int i = 0; i < w.length(); i++) {
			sum += w.charAt(i);
		}
		return sum % SIZE;
	}
	
	static void insert(Word[] table, String word, int line) {
		int pos = hash(word);
		for(int i = 0; i < SIZE; i++) {
			if(table[pos] == null) {
				table[pos] = new Word(word, line);
				return;
			}
			if(table[pos].equals(word)) {
				table[pos].addLine(line);
				return;
			}
			pos = (pos + 1) % SIZE;
		}
		System.out.println("Hash table is full");
	}

	public static void main(String[] args) {
		Word[] table = new Word[SIZE];
		
		try {
			Scanner scan = new Scanner(new File("src/programs/input.txt"));
			int lineNum = 1;

			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] words = line.toLowerCase().split("[^a-z]+");
				for(String word : words) {
					if(word.length() > 0) {
						insert(table, word, lineNum);
					}
				}
				lineNum++;
			}
			scan.close();

		} catch(FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}

		int count = 0;
		for(Word w : table) {
			if(w != null) {
				count++;
			}
		}

		Word[] sortedArray = new Word[count];
		int index = 0;
		for(Word w : table) {
			if(w != null) {
				sortedArray[index++] = w;
			}
		}

		Arrays.sort(sortedArray);
		System.out.println("Cross Reference:");
		for(Word w : sortedArray) {
			System.out.println(w);
		}
	}
}
package lab;
import java.util.Scanner;
import java.io.*;

class MorseCode extends BST<Character> {
	
	public MorseCode() {
		root= new BSTNode<Character>(null);
		
		String[] letters={"A", "B", "C", "D", "E", "F", "G", "H", 
                "I", "J", "K", "L", "M", "N", "O", "P", 
                "Q", "R", "S", "T", "U", "V", "W", "X", 
                "Y", "Z"};
		
		String[] codes=
				{".-",//A
				"-...",//B
				"-.-.",//C
				"-..",//D
				".",//E
				"..-.", //F
                "--.",//G
                "....",//H
                "..",//I
                ".---",//J
                "-.-",//K
                ".-..", //L
                "--",//M
                "-.",//N
                "---",//O
                ".--.",//P
                "--.-",//Q
                ".-.", //R
                "...",//S
                "-",//T
                "..-",//U
                "...-",//V
                ".--",//W
                "-..-",//X 
                "-.--",//Y
                "--.."//Z
                };
		
		
		for(int i=0; i<letters.length; i++) {
			insertLetter(codes[i], letters[i].charAt(0));
		}
	}
	
	public void insertLetter(String code, char letter) {
		BSTNode<Character> p=root;
		
		for(int i=0; i<code.length(); i++) {
			char symbol=code.charAt(i);
			
			if(symbol=='-') {
				if(p.left==null) {
					p.left= new BSTNode<Character>();
				}
				p=p.left;
			}
			else if(symbol=='.') {
				if(p.right==null) {
					p.right= new BSTNode<Character>();
					}
					p=p.right;
				}
			}
		p.el=letter;
		}
	
	public char decode(String code) {
		BSTNode<Character> p=root;
		
		for(int i=0; i<code.length(); i++) {
			char symbol=code.charAt(i);
			
			if(symbol=='-') {
				if(p.left==null) {
					return ' ';
				}
				p=p.left;
			}else if(symbol=='.') {
				if(p.right==null) {
					return ' ';
				}
				p=p.right;
			}
		}
		if(p.el==null) {
			return ' ';
		}
		return p.el;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		MorseCode tree= new MorseCode();
		
		System.out.println("Morse Code Tree:");
		System.out.println();
		System.out.println();
		
		tree.print();
		System.out.println();
		
		Scanner scan= new Scanner(new FileInputStream("src/lab/encoded.txt"));
		
		String decoded="";
		
		while (scan.hasNextLine()) {
	        String line = scan.nextLine().trim();
	        
	        if (!line.isEmpty()) {
	            String[] words = line.split("  +");
	            for (int w = 0; w < words.length; w++) {
	                String[] codes = words[w].trim().split(" ");
	                for (String morseCode : codes) {
	                    if (!morseCode.isEmpty()) {
	                        char letter = tree.decode(morseCode);
	                        decoded += letter;
	                    }
	                }
	                
	                if (w < words.length - 1) {
	                    decoded += " ";
	                }
	            }
	        }
		}
		scan.close();
		System.out.println("Decoded message: "+decoded);
		
	}
	}






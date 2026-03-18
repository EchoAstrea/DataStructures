package lab;

import java.util.Stack;

public class Stackreverse {
    
    // VERSION 2: If we can ONLY use s and t1 (no third stack)
    public static <T> void reverseStackTwoStacks(Stack<T> s, Stack<T> t1) {
        if (s.isEmpty()) return;
        
        int size = s.size();
        
        for (int i = 0; i < size; i++) {
            // Move (size - i - 1) elements to t1
            int toMove = size - i - 1;
            for (int j = 0; j < toMove; j++) {
                t1.push(s.pop());
            }
            
            // Get and save the bottom
            T bottom = s.pop();
            
            // Move back from t1 to s
            for (int j = 0; j < toMove; j++) {
                s.push(t1.pop());
            }
            
            // Now put bottom in t1 (building reversed)
            t1.push(bottom);
        }
        
        // Move final result to s
        while (!t1.isEmpty()) {
            s.push(t1.pop());
        }
    }

    public static void main(String[] args) {

        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> h2 = new Stack<>();
        s2.push(10);
        s2.push(20);
        s2.push(30);
        s2.push(40);
        
        System.out.println("Before: " + s2);
        reverseStackTwoStacks(s2, h2);
        System.out.println("After:  " + s2);
    }
}
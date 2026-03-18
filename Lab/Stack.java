package lab;
import java.util.ArrayList;

public class Stack<T> {
	
	//private T[] pool= new T();// when you want you use a generic type use angle bracket notation
	private ArrayList<T> pool= new ArrayList<>();
	
	//implementation for push(el) for stacks
	public void push(T el) {
		pool.add(el);
	}
	
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		else {
			return pool.remove(pool.size()-1);
		}
	}
	
	public T topEl() {
		if(isEmpty()) {
			return null;}
		return pool.get(pool.size()-1);
	}
	
	public void clear() {
		pool.clear();
	}
	
	public boolean isEmpty() {
		return pool.size()==0;
		
	}
	@Override
	public String toString() {
		return pool.toString();
	}
	
	

}


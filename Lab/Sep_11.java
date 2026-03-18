package lab;

public class Sep_11 {

	<T> void printStack(Stack<T> s) {
		Stack<T> t= new Stack<>();
		while(!s.isEmpty()) {
			t.push(s.pop());
			System.out.print(t.topEl()+" ");
		}
		System.out.println();
		while(!t.isEmpty()) {
			s.push(t.pop());
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s= new Stack<>();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s);
		Sep_11 lab=new Sep_11();//if it is in static and you want to call an non static
		lab.printStack(s);
		System.out.println(s.pop()+ " "+s);
		System.out.println(s.pop()+ " "+s);
		System.out.println(s.pop()+ " "+s);
		System.out.println(s.pop()+ " "+s);
		
		
		
		
		
		
		

	}

}

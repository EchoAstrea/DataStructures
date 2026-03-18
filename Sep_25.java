package lab;
import java.util.LinkedList;

public class Sep_25 {
	public static void main(String[] args) {
		DLL<Integer> dll= new DLL<>();
		dll.insertAtHead(10);
		dll.insertAtHead(20);
		dll.insertAtHead(30);
		dll.print();
		
		System.out.println(dll.deleteFromTail());
		dll.print();
		System.out.println(dll.deleteFromTail());
		dll.print();
		System.out.println(dll.deleteFromTail());
		dll.print();
		
		
		LinkedList<Integer> lst=new LinkedList<>();
		lst.add(40);
		lst.add(50);
		lst.add(60);
		System.out.println(lst);
		lst.add(2,100);
		System.out.println(lst);
		System.out.println(lst.get(0));
		//add get and size for program
		//simply use get do not use dot notation
		
	}


}


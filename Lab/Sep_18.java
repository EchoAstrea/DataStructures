package lab;

public class Sep_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLL<Integer> sll= new SLL<>();
		sll.print();
		sll.insertAtHead(10);
		sll.insertAtHead(20);
		sll.insertAtHead(30);
		sll.print();
		System.out.println("delete: "+sll.deleteFromHead());
		sll.print();
		System.out.println("delete: "+sll.deleteFromHead());
		sll.print();
		System.out.println("delete: "+sll.deleteFromHead());
		sll.print();
		System.out.println("delete: "+sll.deleteFromHead());
		sll.print();
		
		
		
		SLL<Integer> sll2=new SLL<>();
		sll2.insertAtTail(40);
		sll2.insertAtTail(50);
		sll2.insertAtTail(60);
		sll2.print();
		System.out.println("delete: "+sll2.deleteFromTail());
		sll2.print();
		System.out.println("delete: "+sll2.deleteFromTail());
		sll2.print();
		System.out.println("delete: "+sll2.deleteFromTail());
		sll2.print();
		System.out.println("delete: "+sll2.deleteFromTail());
		sll2.print();

	}

}

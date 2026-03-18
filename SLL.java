package lab;
//Single Linked List
class SLLNode<T>{
	public T info;
	public SLLNode<T> next;
	
	public SLLNode(T el, SLLNode<T> p) {
		info=el;
		next=p;
	}
	
	public SLLNode(T el) {
		this(el,null);
	}
	

	public SLLNode() {
		this(null,null);
	}
	
	
}
public class SLL<T> {
	protected SLLNode<T> head=null, tail=null;
	
	public boolean isEmpty() {
		return head==null;
	}
//Methods:
//insertion from head	
	public void insertAtHead(T el) {
		head =new SLLNode<T>(el,head);
		if(tail==null) {
			tail=head;
		}
		}
			
//insertion from tail
	public void insertAtTail(T el) {
		if (!isEmpty()) {
		tail.next=new SLLNode<T>(el);
		tail=tail.next;
		}
		else {
			tail=head=new SLLNode<T>(el);
		}
		
	}

//deletion from head
	public T deleteFromHead() {
		if(isEmpty())//if the list is empty
			return null;
		T tmp=head.info;
		head=head.next;
		if(isEmpty()) {//if the list only has one node
			tail=null;
		}
		return tmp;
	}
	
	
//deletion from tail
	public T deleteFromTail() {
		if(isEmpty())//if the list is empty
			return null;
		T tmp=tail.info;
		if(head==tail)//if there is only one node
			head=tail=null;
		else {
			
			SLLNode<T> p;
			//for(SLLNode<T> p=head; p.next.next!=null; p=p.next); useful for homework to check if it its next to the last node
			for(p=head; p.next!=tail; p=p.next);//as long as the pointer does not point to the tail indicating the last node
			tail=p;
			tail.next=null;
		}
		return tmp;
	}

	
	public void print() {
		for(SLLNode<T> p=head; p!=null; p=p.next)
			System.out.print(p.info +" ");
		System.out.println();
	}

}
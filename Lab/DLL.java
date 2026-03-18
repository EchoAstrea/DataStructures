package lab;

 class DLLNode<T> {
	public T info;
	public DLLNode<T> next, prev;
	public DLLNode(T t, DLLNode<T> n, DLLNode<T> p) {
		info=t;
		next=n;
		prev=p;
	}
	public DLLNode(T t, DLLNode<T> n) {
		this(t, n, null);
	}
	
	public DLLNode(T t) {
		this(t, null, null);
	}
	
	public DLLNode() {
		this(null, null, null);
	}

}
 public class DLL<T>{
	 protected DLLNode<T> head=null, tail=null;
	 
	 public boolean isEmpty() {
		 return head==null;
	 }
	 //assign a pointer to a object- use new
	 public void insertAtHead(T t) {
		head= new DLLNode<T>(t,head);
		if(head.next==null) {//if (tail==null)
			tail=head;
		}
		else {
			head.next.prev=head;
		}
	 }
	 
	 public T deleteFromTail() {
		 if(isEmpty()) {
			 return null;
		 }
		 T el=tail.info;
		 if(head==tail) {// or: if tail.prev==null
			 head=tail=null;
		 }
		 else {
			 tail=tail.prev;
			 tail.next=null;
		 }
		 return el;
		 

	 }
	 public void print() {
		 for(DLLNode<T> p=head; p!=null; p=p.next) {// for tail p=tail; p=p.prev
			 System.out.print(p.info+" ");
		 }
		 System.out.println();
	 }
	 
	 
				
	 
 }

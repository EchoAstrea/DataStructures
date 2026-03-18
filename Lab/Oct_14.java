package lab;

public class Oct_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<Integer> bst= new BST<>();
		bst.insert(20);
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(30);
		bst.insert(40);
		
		bst.print();
		System.out.println("Search: "+bst.search(30));
		System.out.println("Search: "+bst.search(31));
		
		
		
		BST<L> l = new  BST<L>();
		L l1=new L(10, "abc");
		L l2=new L(10, "abc");
		L l3=l1;
		l.insert(l1);
		l.print();
		
		System.out.println("Search: "+l.search(l1));
		System.out.println("Search: "+l.search(l2));
		System.out.println("Search: "+l.search(l3));
		
		

	}
}
	
	
	class L implements Comparable<L>{
		int id;
		String s;
		public L(int n, String ss) {
			id=n;
			s=ss;
		}
		public String toString() {
			return id+" "+s;
		}
		public int compareTo(L l) {
			if(id==l.id) {
				return 0;
			}
			else if(id<l.id) {
				return -1;
			}
			else {
				return 1;
			}
		}
		
		public boolean equals(Object l) {
			//(L l)
			//return id==l.id;
			return id==((L)l).id;//use this version for stacks and trees
		}
		
	}



package lab;

class BSTNode<T extends Comparable<? super T>>{
	protected T el;
	protected BSTNode<T> left, right;
	
	BSTNode(T t, BSTNode<T> lt, BSTNode<T> rt){
		el=t;
		left=lt;
		right=rt;
	}
	BSTNode(T t){
		el=t;
		left=right=null;
	}
	BSTNode(){
		el=null;
		left=right=null;
	}
}

public class BST<T extends Comparable<? super T>>{
	protected BSTNode<T> root=null;//make null at very start
	
	//insert
	public void insert(T el) {
		// p: pointer to traverse the tree
		// prev: keeps track of the parent node
		BSTNode<T> p=root, prev=null;
		// traverse down the tree to find correct intersection position
		while(p!=null) {//find a place for inserting new node
			prev=p;// save current node as parent before moving on
			
			//Compare the new element with the current node's element
			if(el.compareTo(p.el)<0) {//if the element is less than p.el than make it left
				p=p.left;
			}
			else {
				p=p.right;
			}
		}
		
		// At this point: p is null (insertion spot found)
	    // prev points to the parent where new node should be attached
		
		//Case 1: Tree is empty
		if(root==null) {//if you have not starting node/ start at null
			// create first node as root
			root= new BSTNode<T>(el);
		}
		//Case 2: Insert as left child
		else if(el.compareTo(prev.el)<0) {//If the new element is less than the previous node's element, it creates a new node as the left child of prev.
			// new element is less than parent, insert on left
			prev.left=new BSTNode<T>(el);
		}
		// Case 3: Insert as right child
		else {
			// new element is greater than or equal to parent, insert on right
			prev.right= new BSTNode<T>(el);//it creates a new node as the right child of prev.
		}
	}
	
	
	//search
	public T search(T el) {
		//start at the root of the tree
		BSTNode<T> p=root;
		//traverse tree until p becomes null or we traverse all the data
		while(p!=null) {
			//check if the element we are looking for is found
			if(el.equals(p.el)) {//if (el.compareTo(p.el)==0)
				return p.el; // element found
			}
			//if the search element is less than the current node's amount/root element
			else if (el.compareTo(p.el)==-1) {
				p=p.left; // move to the left of the subtree
			}
			// if the search element is greater than the current node's amount/root node
			else {
				p=p.right; // move to the right of the subtree
			}
		}
		//element not found in the tree
		return null;
	}
	
	//delete
	
	
	
	public void print(BSTNode<T> p, int depth) {
		if(p!=null) {
			// Step 1: Print the right subtree first.
	        // Reason: We want the right children to appear ABOVE the parent in the sideways view
			print(p.right,depth+1);
			// Step 2: Print spaces to indent based on depth level.
	        // Reason: Each level of depth moves the node further to the right visually.
	        // This makes the printed output reflect the structure of the tree.
			for(int i=1; i<=depth; i++) {
				System.out.print("    ");
			}
			// Step 3: Print the current node's element (the actual data).
	        // Reason: After spacing, we show which node is at this level.
			System.out.println(p.el);
			// Step 4: Print the left subtree last.
	        // Reason: Left children appear BELOW the parent in the sideways display.
			print(p.left,depth+1);
		}
		
	}
	// Public method to start the printing process.
	// It calls the recursive print function starting from the root node at depth 0.
	public void print() {
		print(root, 0);
	}
	
}





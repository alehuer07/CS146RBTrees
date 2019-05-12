package myRBT;

/**
 * 
 * @author alehu
 *
 */
public class RedBlackTree<E extends Comparable<E>> {
	private RBNode<E> root;

	public RedBlackTree() {
		this.root = null;
	}

//	public static void main(String[] args)
//	{
//		RedBlackTree<Integer> testRBT = new RedBlackTree<>();
//		testRBT.insert(6);
//		testRBT.insert(9);
//		testRBT.insert(1);
//		testRBT.insert(2);
//		testRBT.insert(7);
//		RBNode<Integer> node7 = testRBT.search(7);
//		testRBT.printTree();
//		System.out.println("\ndone");
//	}
	
	
	/**
	 * Checks if a specified node is a leaf
	 * 
	 * @param node - the node to be checked
	 * @return - true if the node is a leaf
	 */
	public boolean isLeaf(RBNode<E> node) {
		if (node.equals(root) && node.getLeftChild() == null && node.getRightChild() == null)
			return true;
		if (node.equals(root))
			return false;
		if (node.getLeftChild() == null && node.getRightChild() == null) {
			return true;
		}
		return false;
	}

	/**
	 * Initial call to Visits the tree in pre-order
	 */
	public void printTree() { // preorder: visit, go left, go right
		RBNode<E> currentNode = this.root;
		printTree(currentNode);
	}

	/**
	 * Recursive visit and printing of the tree in Preorder
	 * 
	 * @param node - the node to start with
	 */
	public void printTree(RBNode<E> node) {
		
		if(node == null)
		{
			return;
		}
		if (node.isLeaf()) {
			return;
		}
		if(node .getData() != null)
		{
			System.out.println(node.getData() + "");
		}
		
		
		printTree(node.getLeftChild());
		printTree(node.getRightChild());
	}

	// place a new node in the RB tree with data the parameter and color it red.
	/**
	 * Creating a new node with the specified data and adding it to the tree.
	 * 
	 * @param data - data to be added to the tree
	 */
	public void addNode(RBNode<E> cursor, E data) { // this < that <0. this > that >0
		RBNode<E> nodeToAdd = new RBNode<E>(null, this) ;
		//if the root is null(RedBlackTree is empty)
		
		if(root == null)
		{
			nodeToAdd = new RBNode<E>(data, this); 
			nodeToAdd.setRed(false);
			root = nodeToAdd;	// set the nodeToAdd to the root
			//setup the nodeToAdd
			setUpNode(nodeToAdd);
			
			fixTree(nodeToAdd);
			
		}
		else 
		{
			//Base Case
			//if the cursor is empty(no data/pointing to a dummy node)
			if (isEmpty(cursor)) 
			{
				//get the parent of the cursor and add the node to the parent
				RBNode<E> parent = cursor.getParent();
				nodeToAdd = new RBNode<E>(data, this);
				if (nodeToAdd.compareTo(parent) < 0) 	//if nodeToAdd is a leftChild
				{
					parent.setLeftChild(nodeToAdd);
				} 
				else 
				{
					parent.setRightChild(nodeToAdd);	//nodeToAdd is a rightChild
				}
	
				nodeToAdd.setParent(parent);	//nodeToAdd's parent is parent(Node)
				//setup the nodeToAdd
				setUpNode(nodeToAdd);
				
				fixTree(nodeToAdd);
				
				
			}
			//if the data is smaller than the cursor
			else if (data.compareTo(cursor.getData()) < 0) 
			{
				cursor = cursor.getLeftChild();		//move the cursor to the left
				addNode(cursor, data);
			} 
			else 
			{
				cursor = cursor.getRightChild();	//move the cursor to the right
				addNode(cursor, data);
			}
		}

		

	}
	/**
	 * Calls addNode to insert a node
	 * 
	 * @param data - data to insert
	 */
	public void insert(E data) {
		RBNode<E> cursor = root;
		addNode(cursor, data);
	}
	
	/**
	 * Give a specified node, dummy nodes and properly set the child/parent relationship
	 * @param nodeToSetup - node to setup
	 */
	private void setUpNode(RBNode<E> nodeToSetup) {
		nodeToSetup.setLeftChild(new RBNode<E>(null, this));
		nodeToSetup.getLeftChild().setRed(false);
		nodeToSetup.getLeftChild().setParent(nodeToSetup);
		nodeToSetup.setRightChild(new RBNode<E>(null, this));
		nodeToSetup.getRightChild().setRed(false);
		nodeToSetup.getRightChild().setParent(nodeToSetup);
	}


	/**
	 * LookUp a node whose data matches the specified String
	 * 
	 * @param data - data to be looked up
	 * @return - the node that contains the specified String
	 */
	public RBNode<E> lookup(RBNode<E> cursor, E data) {
		
		if(cursor.getData() == null)
		{
			//System.out.println("COULDNT FIND THE NODE");
			return null;
		}
		if(cursor == null || cursor.getData().equals(data))
		{
			return cursor;
		}
		
		
		if(data.compareTo(cursor.getData()) < 0)
		{
			return lookup(cursor.getLeftChild(), data);
		}
		
		return lookup(cursor.getRightChild(), data);
	}
	
	/**
	 * This method calls lookup
	 * @param data
	 */
	public RBNode<E> search(E data){
		RBNode<E> cursor = root;
		RBNode<E> foundNode = lookup(cursor, data);
		return foundNode;
	}

	/**
	 * Finds the sibling of a specified node
	 * 
	 * @param node - the node to be used to get the sibling
	 * @return - the sibling node
	 */
	public RBNode<E> getSibling(RBNode<E> node) {
		if(isLeftChild(node.getParent(), node))
		{
			return node.getParent().getRightChild();
		}
		else {
			return node.getParent().getLeftChild();
		}
	}

	/**
	 * Finds the aunt of a specified node
	 * 
	 * @param node - the node to be used to get the aunt
	 * @return - the aunt node
	 */
	public RBNode<E> getAunt(RBNode<E> node) {
		
		return getSibling(node.getParent());
	}

	/**
	 * Finds the grandparent of a specified node
	 * 
	 * @param n - the node to be used to get the grandparent
	 * @return - the grandparent node
	 */
	public RBNode<E> getGrandparent(RBNode<E> n) {
		return n.getParent().getParent();
	}

	/**
	 * Rotate left at the specified node
	 * 
	 * @param n - node to rotate left
	 */
	public void rotateLeft(RBNode<E> n) {
		RBNode<E> y = n.getRightChild();
		n.setRightChild(y.getLeftChild());
		
		if(y.getLeftChild() != null)
		{
			y.getLeftChild().setParent(n);
		}
		y.setParent(n.getParent());
		
		if(n.getParent() == null)
		{
			this.root = y;
		}
		
		else if(n == n.getParent().getLeftChild())
		{
			n.getParent().setLeftChild(y);
		}
		else {
			n.getParent().setRightChild(y);
		}
		y.setLeftChild(n);
		n.setParent(y);
	}

	/**
	 * Rotate right at the specified node
	 * 
	 * @param x - node to rotate right
	 */
	public void rotateRight(RBNode<E> x) {
		RBNode<E> y = x.getLeftChild();
		x.setLeftChild(y.getRightChild());
		
		if(y.getRightChild()!= null)	//might not need this condition
		{
			y.getRightChild().setParent(x);
		}
		y.setParent(x.getParent());
		
		if(x.getParent() == null)
		{
			this.root = y;
		}
		
		else if(x == x.getParent().getRightChild())
		{
			x.getParent().setRightChild(y);
		}
		else {
			x.getParent().setLeftChild(y);
		}
		y.setRightChild(x);
		x.setParent(y);
	}

	/**
	 * Recursive method used to traverse the tree to make it a RBT (BIG)
	 * 
	 * @param current - the current pointer node
	 */
	public void fixTree(RBNode<E> current) {
	
		
		//if the current is the root node, make it black and quit
		if(current == root)
		{
			current.setRed(false);
			return;
		}
		//if the parent is black, quit
		if(!current.getParent().isRed())
		{
			return;
		}
		
		RBNode<E> parent = current.getParent();
		RBNode<E> aunt = this.getAunt(current);
		RBNode<E> grandparent = this.getGrandparent(current);
		
		//if the current node is red and the parent is red, the tree is unbalanced
		if(current.isRed() && parent.isRed())
		{
			//if the aunt is red, then re-color and fix again
			if(aunt.isRed())
			{
				parent.setRed(false);
				aunt.setRed(false);
				grandparent.setRed(true);
				fixTree(grandparent);
			}	
			//else if the aunt node is empty or black, look at the cases
			else if(this.isEmpty(aunt) || !aunt.isRed() )
			{
				//if grandparent - parent(is left child) - current(is right child)
				if(this.isLeftChild(grandparent, parent) && !this.isLeftChild(parent, current))
				{
					this.rotateLeft(parent);
					this.fixTree(parent);
				}
				//if grandparent - parent(is right child) - current(is left child)
				if(!this.isLeftChild(grandparent, parent) && this.isLeftChild(parent, current))
				{
					this.rotateRight(parent);
					this.fixTree(parent);
				}
				//if grandparent - parent(is left child) - current(is left child)
				if(this.isLeftChild(grandparent, parent) && this.isLeftChild(parent, current))
				{
					parent.setRed(false);
					grandparent.setRed(true);
					this.rotateRight(grandparent);
					//quit
				}
				//if grandparent - parent(is right child) - current(is right child)
				if(!this.isLeftChild(grandparent, parent) && !this.isLeftChild(parent, current))
				{
					parent.setRed(false);
					grandparent.setRed(true);
					this.rotateLeft(grandparent); // MUST ROTATE LEFT
					//quit
				}	
			}
		}
		
		
		
	}

	/**
	 * Checks to see if a node does not contain a key
	 * 
	 * @param n - the node to be checked
	 * @return - true if empty
	 */
	public boolean isEmpty(RBNode<E> n) {
		if (n.getData() == null) {
			return true;
		}
		return false;
	}

	/**
	 * Compares two nodes and determines if the child node is to the left of the
	 * specified parent node
	 * 
	 * @param parent - the parent node
	 * @param child  - the child node
	 * @return - true if the child is a left child
	 */
	public boolean isLeftChild(RBNode<E> parent, RBNode<E> child) {
		if (child.compareTo(parent) < 0) {// child is less than parent
			return true;
		}
		return false;
	}

	/**
	 * Prints out the key for given node
	 * 
	 * @param n - node visited
	 */
	public void visit(RBNode<E> n) {
		System.out.println(n.getData());
	}

	/**
	 * Executes a pre-order visit of the tree starting at the root
	 * 
	 * @param v
	 */
	public void preOrderVisit(Visitor<E> v) {
		preOrderVisit(root, v);
	}

	/**
	 * PreOrderVisit
	 * 
	 * @param n
	 * @param v
	 */
	private void preOrderVisit(RBNode<E> n, Visitor<E> v) {
		if (n == null) {
			return;
		}
		v.visit(n);
		preOrderVisit(n.getLeftChild(), v);
		preOrderVisit(n.getRightChild(), v);
	}

	/**
	 * @return the root
	 */
	public RBNode<E> getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(RBNode<E> root) {
		this.root = root;
	}

}

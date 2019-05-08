package myRBT;

/**
 * 
 * @author alehu
 *
 */
public class RedBlackTree <E extends Comparable<E>> 
{
	private RBNode<E> root;
	
	public RedBlackTree()
	{
		this.root = null;
	}
	
	/**
	 * Checks if a specified node is a leaf
	 * 
	 * @param n - the node to be checked
	 * @return - true if the node is a leaf
	 */
	public boolean isLeaf(RBNode<String> n) {
		if (n.equals(root) && n.getLeftChild() == null && n.getRightChild() == null)
			return true;
		if (n.equals(root))
			return false;
		if (n.getLeftChild() == null && n.getRightChild() == null) {
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
		System.out.print(node.getData());
		if (node.isLeaf()) {
			return;
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
	public void addNode(String data) { // this < that <0. this > that >0
		// fill

	}

	/**
	 * Calls addNode to insert a node
	 * 
	 * @param data - data to insert
	 */
	public void insert(String data) {
		addNode(data);
	}

	/**
	 * LookUp a node whose data matches the specified String
	 * 
	 * @param k - string to be looked up
	 * @return - the node that contains the specified String
	 */
	public RBNode<E> lookup(String k) {
		// fill
		return null;
	}

	/**
	 * Finds the sibling of a specified node
	 * 
	 * @param n - the node to be used to get the sibling
	 * @return - the sibling node
	 */
	public RBNode<E> getSibling(RBNode<E> n) {
		//
		return null;
	}

	/**
	 * Finds the aunt of a specified node
	 * 
	 * @param n - the node to be used to get the aunt
	 * @return - the aunt node
	 */
	public RBNode<E> getAunt(RBNode<E> n) {
		//
		return null;
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
		//
	}

	/**
	 * Rotate right at the specified node
	 * 
	 * @param n - node to rotate right
	 */
	public void rotateRight(RBNode<E> n) {
		//
	}

	/**
	 * Recursive method used to traverse the tree to make it a RBT (BIG)
	 * 
	 * @param current - the current pointer node
	 */
	public void fixTree(RBNode<E> current) {
		//
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
	public boolean isLeftChild(RBNode<String> parent, RBNode<String> child) {
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

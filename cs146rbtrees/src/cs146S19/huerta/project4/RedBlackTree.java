package cs146S19.huerta.project4;

public class RedBlackTree<Key extends Comparable<Key>> {
	private static RedBlackTree.Node<String> root;

	//----------Node Class----------
	public static class Node<Key extends Comparable<Key>> { // changed to static

		Key key;
		Node<String> parent;
		Node<String> leftChild;
		Node<String> rightChild;
		boolean isRed;
		int color;

		/**
		 * Constructor for a Node
		 * @param data - data to be held by the Node
		 */
		public Node(Key data) {
			this.key = data;
			leftChild = null;
			rightChild = null;
		}

		/**
		 * Comparing the data inside two Nodes
		 * @param n - node to be compared to
		 * @return - negative if this is before, zero if this and n are the same, and positive if this comes after
		 */
		public int compareTo(Node<Key> n) { // this < that <0
			return key.compareTo(n.key); // this > that >0
		}

		/**
		 * Determines if this node is a leaf
		 * @return - true if node is a leaf
		 */
		public boolean isLeaf() {
			if (this.equals(root) && this.leftChild == null && this.rightChild == null)
				return true;
			if (this.equals(root))
				return false;
			if (this.leftChild == null && this.rightChild == null) {
				return true;
			}
			return false;
		}
	}
	//----------End Node Class----------

	/**
	 * Checks if a specified node is a leaf
	 * @param n - the node to be checked
	 * @return - true if the node is a leaf
	 */
	public boolean isLeaf(RedBlackTree.Node<String> n) {
		if (n.equals(root) && n.leftChild == null && n.rightChild == null)
			return true;
		if (n.equals(root))
			return false;
		if (n.leftChild == null && n.rightChild == null) {
			return true;
		}
		return false;
	}

	//----------Visitor Interface that defines visit()----------
	public interface Visitor<Key extends Comparable<Key>> {
		/**
		 * This method is called at each node.
		 * 
		 * @param n - the visited node
		 */
		void visit(Node<Key> n);
	}
	//----------End Visitor Interface----------
	
	/**
	 * Prints out the key for given node
	 * @param n - node visited
	 */
	public void visit(Node<Key> n) {
		System.out.println(n.key);
	}

	/**
	 * Initial call to Visits the tree in pre-order
	 */
	public void printTree() { // preorder: visit, go left, go right
		RedBlackTree.Node<String> currentNode = root;
		printTree(currentNode);
	}

	/**
	 * Recursive visit and printing of the tree in Preorder
	 * @param node - the node to start with
	 */
	public void printTree(RedBlackTree.Node<String> node) {
		System.out.print(node.key);
		if (node.isLeaf()) {
			return;
		}
		printTree(node.leftChild);
		printTree(node.rightChild);
	}

	// place a new node in the RB tree with data the parameter and color it red.
	/**
	 * Creating a new node with the specified data and adding it to the tree.
	 * @param data - data to be added to the tree
	 */
	public void addNode(String data) { // this < that <0. this > that >0
		// fill

	}

	/**
	 * Calls addNode to insert a node
	 * @param data - data to insert
	 */
	public void insert(String data) {
		addNode(data);
	}

	/**
	 * LookUp a node whose data matches the specified String
	 * @param k - string to be looked up
	 * @return - the node that contains the specified String
	 */
	public RedBlackTree.Node<String> lookup(String k) {
		// fill
		return null;
	}

	/**
	 * Finds the sibling of a specified node
	 * @param n - the node to be used to get the sibling
	 * @return - the sibling node
	 */
	public RedBlackTree.Node<String> getSibling(RedBlackTree.Node<String> n) {
		//
		return null;
	}

	/**
	 * Finds the aunt of a specified node
	 * @param n - the node to be used to get the aunt
	 * @return - the aunt node
	 */
	public RedBlackTree.Node<String> getAunt(RedBlackTree.Node<String> n) {
		//
		return null;
	}

	/**
	 * Finds the grandparent of a specified node
	 * @param n - the node to be used to get the grandparent
	 * @return - the grandparent node
	 */
	public RedBlackTree.Node<String> getGrandparent(RedBlackTree.Node<String> n) {
		return n.parent.parent;
	}

	/**
	 * Rotate left at the specified node
	 * @param n - node to rotate left
	 */
	public void rotateLeft(RedBlackTree.Node<String> n) {
		//
	}

	/**
	 * Rotate right at the specified node
	 * @param n - node to rotate right
	 */
	public void rotateRight(RedBlackTree.Node<String> n) {
		//
	}

	/**
	 * Recursive method used to traverse the tree to make it a RBT (BIG)
	 * @param current - the current pointer node
	 */
	public void fixTree(RedBlackTree.Node<String> current) {
		//
	}

	/**
	 * Checks to see if a node does not contain a key
	 * @param n - the node to be checked
	 * @return - true if empty
	 */
	public boolean isEmpty(RedBlackTree.Node<String> n) {
		if (n.key == null) {
			return true;
		}
		return false;
	}

	/**
	 * Compares two nodes and determines if the child node is to the left of the specified parent node
	 * @param parent - the parent node
	 * @param child - the child node
	 * @return - true if the child is a left child
	 */
	public boolean isLeftChild(RedBlackTree.Node<String> parent, RedBlackTree.Node<String> child) {
		if (child.compareTo(parent) < 0) {// child is less than parent
			return true;
		}
		return false;
	}

	/**
	 * Executes a pre-order visit of the tree starting at the root
	 * @param v
	 */
	public void preOrderVisit(Visitor<String> v) {
		preOrderVisit(root, v);
	}

	/**
	 * PreOrderVisit
	 * @param n
	 * @param v
	 */
	private static void preOrderVisit(RedBlackTree.Node<String> n, Visitor<String> v) {
		if (n == null) {
			return;
		}
		v.visit(n);
		preOrderVisit(n.leftChild, v);
		preOrderVisit(n.rightChild, v);
	}
}

package myRBT;
/**
 * 
 * @author alehu
 *
 */
public class RBNode <E extends Comparable<E>> {
	private RedBlackTree<E> rbt;
	private E data;
	private RBNode<E> parent;
	private RBNode<E> leftChild;
	private RBNode<E> rightChild;
	private boolean isRed;
	

	/**
	 * Constructor for a Node
	 * 
	 * @param data - data to be held by the Node
	 */
	public RBNode(E data, RedBlackTree<E> rbt) {
		this.data = data;
		this.leftChild = new RBNode<E>(null, rbt);
		this.leftChild.setRed(false);
		this.rightChild = new RBNode<E>(null, rbt);
		this.leftChild.setRed(false);
		this.rbt = rbt;
	}

	/**
	 * Comparing the data inside two Nodes
	 * 
	 * @param n - node to be compared to
	 * @return - negative if this is before, zero if this and n are the same, and
	 *         positive if this comes after
	 */
	public int compareTo(RBNode<E> n) { // this < that <0
		return data.compareTo(n.getData()); // this > that >0
	}

	/**
	 * Determines if this node is a leaf
	 * 
	 * @return - true if node is a leaf
	 */
	public boolean isLeaf() {
		if (this.equals(rbt.getRoot()) && this.leftChild == null && this.rightChild == null)
			return true;
		if (this.equals(rbt.getRoot()))
			return false;
		if (this.leftChild == null && this.rightChild == null) {
			return true;
		}
		return false;
	}

	/**
	 * @return the rbt
	 */
	public RedBlackTree<E> getRbt() {
		return rbt;
	}

	/**
	 * @param rbt the rbt to set
	 */
	public void setRbt(RedBlackTree<E> rbt) {
		this.rbt = rbt;
	}

	/**
	 * @return the key
	 */
	public E getData() {
		return data;
	}

	/**
	 * @param data the key to set
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * @return the parent
	 */
	public RBNode<E> getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(RBNode<E> parent) {
		this.parent = parent;
	}

	/**
	 * @return the leftChild
	 */
	public RBNode<E> getLeftChild() {
		return leftChild;
	}

	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(RBNode<E> leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @return the rightChild
	 */
	public RBNode<E> getRightChild() {
		return rightChild;
	}

	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(RBNode<E> rightChild) {
		this.rightChild = rightChild;
	}

	/**
	 * @return the isRed
	 */
	public boolean isRed() {
		return isRed;
	}

	/**
	 * @param isRed the isRed to set
	 */
	public void setRed(boolean isRed) {
		this.isRed = isRed;
	}


	

}

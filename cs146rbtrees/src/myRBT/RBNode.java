package myRBT;
/**
 * 
 * @author alehu
 *
 */
public class RBNode <E extends Comparable<E>> {
	private RedBlackTree<E> redBlackTreeIn;
	private E data;
	private RBNode<E> parent;
	private RBNode<E> leftChild;
	private RBNode<E> rightChild;
	private boolean isRed;
	private int color;	//black == 1, red ==0?
	

	/**
	 * Constructor for a Node
	 * 
	 * @param data - data to be held by the Node
	 */
	public RBNode(E data, RedBlackTree<E> rbt) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.isRed = true;
		this.redBlackTreeIn = rbt;
		this.color = 0;
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
		if (this.equals(redBlackTreeIn.getRoot()) && this.leftChild == null && this.rightChild == null)
			return true;
		if (this.equals(redBlackTreeIn.getRoot()))
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
		return redBlackTreeIn;
	}

	/**
	 * @param rbt the rbt to set
	 */
	public void setRbt(RedBlackTree<E> rbt) {
		this.redBlackTreeIn = rbt;
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
		if(this.isRed){
			this.color = 0;
		}
		else {
			this.color = 1;
		}
	}

	/**
	 * @return the redBlackTreeIn
	 */
	public RedBlackTree<E> getRedBlackTreeIn() {
		return redBlackTreeIn;
	}

	/**
	 * @param redBlackTreeIn the redBlackTreeIn to set
	 */
	public void setRedBlackTreeIn(RedBlackTree<E> redBlackTreeIn) {
		this.redBlackTreeIn = redBlackTreeIn;
	}

	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}
	


	

}

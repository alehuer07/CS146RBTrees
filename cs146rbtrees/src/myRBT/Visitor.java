package myRBT;

/**
 * @author alehu
 *
 */
public interface Visitor <E extends Comparable<E>>
{
	/**
	 * This method is called at each node.
	 * 
	 * @param n - the visited node
	 */
	void visit(RBNode<E> n);

}

package cs146S19.huerta.project4;

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
	public void visit(RBNode<E> n);


}

package myRBT;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class RedBlackTreeTester {

	@Test
	void test() {
		RedBlackTree<String> rbt = new RedBlackTree<>();
        rbt.insert("D");
        rbt.insert("B");
        rbt.insert("A");
        rbt.insert("C");
        rbt.insert("F");
        rbt.insert("E");
        rbt.insert("H");
        rbt.insert("G");
        rbt.insert("I");
        rbt.insert("J");
        assertEquals("DBACFEHGIJ", makeString(rbt));
        String str=     "Color: 1, Key:D Parent: \n"+
                        "Color: 1, Key:B Parent: D\n"+
                        "Color: 1, Key:A Parent: B\n"+
                        "Color: 1, Key:C Parent: B\n"+
                        "Color: 1, Key:F Parent: D\n"+
                        "Color: 1, Key:E Parent: F\n"+
                        "Color: 0, Key:H Parent: F\n"+
                        "Color: 1, Key:G Parent: H\n"+
                        "Color: 1, Key:I Parent: H\n"+
                        "Color: 0, Key:J Parent: I\n";
		assertEquals(str, makeStringDetails(rbt));
            
	}
	//add tester for spell checker
	
	
	
	public <E extends Comparable<E>> String makeString(RedBlackTree<E> t)
    {
		class MyVisitor<T extends Comparable<T>> implements Visitor<T> 
		{
			String result = "";
			public void visit(RBNode<T> n)
			{
				if(n.getData() != null)
				result = result + n.getData();
			}
		};
		MyVisitor<E> visitor = new MyVisitor<E>();
		t.preOrderVisit(visitor);
		return visitor.result;
	}
	
	public <E extends Comparable<E>> String makeStringDetails(RedBlackTree<E> t)
    {
		class MyVisitor<T extends Comparable<T>> implements Visitor<T> 
		{
			String result = "";
			public void visit(RBNode<T> n)
			{
				
				
				if((n.getData() != null))
				{
					int color = n.getColor();
					T data = n.getData();
					RBNode<T> parent = n.getParent();
					T parentData;
					if(parent == null) {
						parentData = (T)"";
					}
					else {
						parentData = parent.getData();
					}
					
					result = result + "Color: " + color + ", Key:" + data + " Parent: " + parentData + "\n";
				}
			}
		};
		MyVisitor<E> v = new MyVisitor<E>();
		t.preOrderVisit(v);
		return v.result;
	}
	 
	 
	

	 
	
	
	

}

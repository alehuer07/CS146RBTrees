package myRBT;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class RedBlackTreeTester {

	@Test
	void testRedBlackTree() {
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
		String str = "Color: 1, Key:D Parent: \n" + "Color: 1, Key:B Parent: D\n" + "Color: 1, Key:A Parent: B\n"
				+ "Color: 1, Key:C Parent: B\n" + "Color: 1, Key:F Parent: D\n" + "Color: 1, Key:E Parent: F\n"
				+ "Color: 0, Key:H Parent: F\n" + "Color: 1, Key:G Parent: H\n" + "Color: 1, Key:I Parent: H\n"
				+ "Color: 0, Key:J Parent: I\n";
		assertEquals(str, makeStringDetails(rbt));

	}
	
	@Test
	void testDictionary() {
		RedBlackTree<String> rbDictionary = new RedBlackTree<String>();
		RedBlackTree<String> rbWords = new RedBlackTree<String>();
		File dictionaryFile = new File("C:\\Users\\alehu\\Desktop\\LocalRepos\\CS146RBTrees\\cs146rbtrees\\src\\myRBT\\dictionary.txt");
		File poemFile = new File("C:\\Users\\alehu\\Desktop\\LocalRepos\\CS146RBTrees\\cs146rbtrees\\src\\myRBT\\sonnet18.txt");
		
		Long startTime;
		long endTime;
		Scanner scanner1;
		Scanner scanner2;
		try {
			//putting words into the dictionary
			scanner1 = new Scanner(dictionaryFile);
			startTime = System.currentTimeMillis();
			while(scanner1.hasNext())
			{
				String string = scanner1.nextLine();
				//System.out.println(string);
				rbDictionary.insert(string);
			}
			endTime = System.currentTimeMillis();
			scanner1.close();
			double totalTime = (double)(endTime - startTime);
			System.out.println("The time to create the RedBlackTree is: " + totalTime + "ms");
			//rbDictionary.printTree();
			
			//reading the poem and looking up words in rbDictionary
			scanner2 = new Scanner(poemFile);
			startTime = System.currentTimeMillis();
			while(scanner2.hasNext())
			{
				String string = (String)scanner2.next();
				
				//System.out.println(string);
				RBNode<String> node = rbDictionary.search(string);
				if(node == null)
				{
					rbWords.insert(string);
				}
				
			}
			endTime = System.currentTimeMillis();
			scanner2.close();
			totalTime = (double)(endTime - startTime);
			System.out.println("The time to read the poem is: " + totalTime + "ms");
			
			System.out.println("The words that are not in the dictionary, but are in the poem");
			rbWords.printTree();
				
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("File was not found: " + fnf.getMessage());
		}
		catch(IOException io)
		{
			System.out.println("IOException: " + io.getMessage());
		}
		
		
		
		
		
		
	}
	
	
	
	
	// add tester for spell checker

	public <E extends Comparable<E>> String makeString(RedBlackTree<E> t) {
		class MyVisitor<T extends Comparable<T>> implements Visitor<T> {
			String result = "";

			public void visit(RBNode<T> n) {
				if (n.getData() != null)
					result = result + n.getData();
			}
		}
		;
		MyVisitor<E> visitor = new MyVisitor<E>();
		t.preOrderVisit(visitor);
		return visitor.result;
	}

	public <E extends Comparable<E>> String makeStringDetails(RedBlackTree<E> t) {
		class MyVisitor<T extends Comparable<T>> implements Visitor<T> {
			String result = "";

			public void visit(RBNode<T> n) {

				if ((n.getData() != null)) {
					int color = n.getColor();
					T data = n.getData();
					RBNode<T> parent = n.getParent();
					T parentData;
					if (parent == null) {
						parentData = (T) "";
					} else {
						parentData = parent.getData();
					}

					result = result + "Color: " + color + ", Key:" + data + " Parent: " + parentData + "\n";
				}
			}
		}
		;
		MyVisitor<E> v = new MyVisitor<E>();
		t.preOrderVisit(v);
		return v.result;
	}

}

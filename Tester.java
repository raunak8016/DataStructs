package Assignment2;

import Assignment2.MyLinkedListInterface.LinkedListListEmptyException;
import Assignment2.MyLinkedListInterface.LinkedListValueExistsException;
import Assignment2.MyLinkedListInterface.MyLinkedListNode;

public class Tester {

	public static void main(String[] args) throws LinkedListValueExistsException, LinkedListListEmptyException {
		// TODO Auto-generated method stub
		/*MyLinkedList<String> test = new MyLinkedList<String>();
		MyLinkedList<String> tester = new MyLinkedList<String>();
		MyLinkedListNode<String> test1 = new MyLinkedListNode<String>("5");
		System.out.println("Head: " + test.getHeadNode());
		System.out.println("Length: " + test.length());
		test.appendToTail("3");
		System.out.println("Head: " + test.getHeadNode());
		System.out.println("Length: " + test.length());
		test.appendToTail("4");
		System.out.println("Head: " + test.getHeadNode());
		System.out.println("Length: " + test.length());
		test.appendToTail(test1);
		System.out.println("Head: " + test.getHeadNode());
		System.out.println("Length: " + test.length());
		System.out.println(test.toString());
		System.out.println(test.searchByValue("6"));
		System.out.println(test.searchByValue("6"));

		for (int i = 1; i<2; i++) {
			System.out.println("hi");
		}*/
		
		Stack tester = new Stack();
		tester.push(3);
		tester.push(5);
		tester.push(6);
		System.out.println(tester.toString());
		System.out.println(tester.peek());
		System.out.println(tester.toString());
		tester.pop();
		System.out.println(tester.toString());
		System.out.println(tester.size());


	}

}

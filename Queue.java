package Assignment2;

import Assignment2.MyLinkedListInterface.LinkedListListEmptyException;
import Assignment2.MyLinkedListInterface.LinkedListValueExistsException;
import Assignment2.MyLinkedListInterface.MyLinkedListNode;

public class Queue {
	private Stack stack1;
	
	public Queue() {
		stack1 = new Stack();
	}
	
	
	public void setStack(Stack stack) {
		this.stack1 = stack;
	}
	
	public void push(int add) throws LinkedListValueExistsException {
		this.stack1.getList().appendToTail(add);
	}
	
	public int peek() throws LinkedListListEmptyException {
		int ret = stack1.getList().getHeadNode().getValue();
		return ret;
	}
	
	public void pop() throws Exception {
		int ret = stack1.getList().getHeadNode().getValue();
		if (stack1.getList().getHeadNode() != null) stack1.getList().deleteByValue(ret);
		else throw new Exception("Empty List");
	}
	
	public int size() {
		return stack1.getList().length();
	}
	
	public String toString() {
		String ret = " -\n";
		MyLinkedListNode<Integer> index = list.getHeadNode();
		while (index.getNext() != null) {
			ret += "|" + index.getValue().toString() + "|\n";
			ret += " -\n";
			index = index.getNext();
		}
		ret += "|" + index.getValue().toString() + "|\n";
		ret += " -";
		return ret;
	}

}

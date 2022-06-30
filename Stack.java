package Assignment2;

import Assignment2.MyLinkedListInterface.LinkedListListEmptyException;
import Assignment2.MyLinkedListInterface.LinkedListValueExistsException;
import Assignment2.MyLinkedListInterface.MyLinkedListNode;

public class Stack {
		private int top;
		private MyLinkedList<Integer> list;
		
		public Stack() {
			top = 0;
			list = new MyLinkedList<Integer>();
		}
		
		public int getTop() {
			return this.top;
		}
		
		public MyLinkedList<Integer> getList() {
			return this.list;
		}
		
		public void setList(MyLinkedList<Integer> list1) {
			list = list1;
		}
		
		public void push(int add) throws LinkedListValueExistsException {
			MyLinkedList<Integer> list1 = new MyLinkedList<Integer>();
			list1.appendToTail(add);
			list1.getHeadNode().setNext(list.getHeadNode());
			this.setList(list1);
		}
		
		public int peek() throws LinkedListListEmptyException {
			int ret = list.getHeadNode().getValue();
			return ret;
		}
		
		public void pop() throws LinkedListListEmptyException {
			int ret = list.getHeadNode().getValue();
			if (list.getHeadNode() != null) list.deleteByValue(ret);
			else throw new LinkedListListEmptyException("Empty List");
		}
		
		public int size() {
			return list.length();
		}
		
		public void reverse() {
			
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

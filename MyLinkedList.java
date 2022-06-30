/**
 * @author Raunak Sandhu
 * id - 30117897
 * 
 * This class was for the implementation of the methods of the linked list data structure
 * 
 */

package Assignment2;

import Assignment2.MyLinkedListInterface.MyLinkedListNode;

public class MyLinkedList<ElementType> implements MyLinkedListInterface<ElementType> {
    
    private MyLinkedListNode<ElementType> head;

    public MyLinkedList(){
         head = null;		// constructor set head to null when LL initialized
    }

    public MyLinkedListNode<ElementType> getHeadNode() {
        return this.head;	// return the head node of the LinkedList for this method
    }

    public void appendToTail(ElementType value) throws LinkedListValueExistsException { 
        MyLinkedListNode<ElementType> new_link = new MyLinkedListNode<ElementType>(value);	// initialize node with value = value
    	if (head == null) head = new_link; 					// if LL is empty (i.e. head == null) then make the head equal new_link
    	else if (head.getValue() == value) throw new LinkedListValueExistsException("Repeated Head Error"); // if head has the same value as value input throw exception
    	else {												// if head is not null and head.getValue()!=value then enter this condition
    		MyLinkedListNode<ElementType> index = head;		// set the index equal to head node
	    	while (index.getNext() != null) {				// iterate through the LL to get to the end
	    		index = index.getNext();					// move nodes
	    		if (index.getValue() == value) throw new LinkedListValueExistsException("Repeated Value Error");	// if any nodes are equal throw exception
	    	}
			index.setNext(new_link);	// add the new node as the last node
    	}
	    	
    }

    public void appendToTail(MyLinkedListNode<ElementType> node) throws LinkedListValueExistsException {
		// Write some assignment code here!
		// Note - It is a good idea not to make changes to the .next value of the input node here
    	
    	if (head == null) head = node;				// if LL is empty make head equal to input node
    	else if (head.getValue() == node.getValue()) throw new LinkedListValueExistsException("Repeated Head Error");	// throw exception if head and node share the same value
    	else {
    		MyLinkedListNode<ElementType> index = head;		// index = head node
	    	while (index.getNext() != null) {	// use index to iterate through LL until the end
	    		index = index.getNext();		// move to next node
	    		if (index.getValue() == node.getValue()) throw new LinkedListValueExistsException("Repeated Value Error");	// if value is shared throw exception
	    	}
			index.setNext(node);	// last node will setNext to the input node
    	}

    }

    public int length() {
    	MyLinkedListNode<ElementType> index = head;		// set index node to head
    	int counter = 1;	// declare counter for length
    	if (head == null) return 0;		// if LL is empty return 0
    	else {
	    	while (index.getNext() != null) {	// iterate through LL until there is no next node
	    		index = index.getNext();	// go to next node
	    		counter++;	// add to counter for each jump
	    	}
			return counter;
    	}
    }

    public void deleteByValue(ElementType value) throws LinkedListListEmptyException {
        // Write some assignment code here!
    	if (head != null) {
    		MyLinkedListNode<ElementType> index = head;		// index node to head
        	if (index.getValue() == value) {	// if head value and value are the same
        		head = new MyLinkedListNode<ElementType>(index.getNext().getValue(), index.getNext().getNext()); // declare new head as the second element of LL
        	}
    		MyLinkedListNode<ElementType> previous = index;		// declare previous node, which will act as previous.getNext() = index
        	while (index.getNext().getNext() != null) {		// iterate through LL
	    		index = index.getNext();	// go to next node
	    		if (index.getValue() == value) {	// if node has delete value 
	    			previous.setNext(index.getNext());	// then go to previous and skip over the delete node
	    		}
	    		previous = previous.getNext();	// go to next node
	    	}
        	if (index.getNext().getValue() == value) { // check for last node
        		previous.setNext(null);	 // end LL at previous node
        	}
        	
    	}
    	else {
    		throw new LinkedListListEmptyException("Empty List");	// if head is null return empty list exception
    	}
    }

    public MyLinkedListNode<ElementType> searchByValue(ElementType value) throws LinkedListListEmptyException {
        // Write some assignment code here!
        if (head == null) throw new LinkedListListEmptyException("Empty list");	// if LL is empty throw exception
        else {
        	MyLinkedListNode<ElementType> index = head;	// index node starts at head
	    	while (index.getNext() != null) {	// iterate through LL
	    		if (index.getValue() == value) return index;	// if value of index is equal to value input return index node
	    		index = index.getNext();	// go to next node
	    	}
	    	if (index.getValue() == value) return index;	// if value of last node is equal to value input return node
	    	else return null;	// no node with value equal to input value return null
        }
    }   

    public String toString() {
        // Write some assignment code here!
    	if (head == null) return null;	// if LL is empty return null
        else {
        	String ret = "";	// declare return string
        	MyLinkedListNode<ElementType> index = head;		// index node equal to head
	    	while (index.getNext() != null) {	// iterate through LL to end
	    		ret += index.getValue() + " -> ";	// for each node add value to return string
	    		index = index.getNext();	// go to next node
	    	}
	    	ret += index.getValue();	// last node add value to return string
	    	return ret;	// return string
        }

    }
}
/**
 * @author Raunak Sandhu
 * id - 30117897
 * 
 * This class was for the implementation of Floyd's algorithm using two methods and also the removeSharedLinkedListNodes method
 * The concert example was used to test these methods.
 * 
 */

package Assignment2;

import java.util.ArrayList;
import Assignment2.MyLinkedListInterface.MyLinkedListNode;

class TangledList {

    public static void removeSharedLinkedListNodes(MyLinkedList<String> list0, MyLinkedList<String> list1) {
        // Write some assignment code here!
    	int list0_len = list0.length();		// calculate length of input list0

    	int list1_len = list1.length();		// calculate length of input list1

    	if (list0_len < list1_len) {		// swap lists and lengths if list1 is longer than list0
    		MyLinkedList<String> temp = list1;	// create temp list
    		int temp_len = list1_len;		// create temp length
    		list1 = list0;			// swap lists
    		list0 = temp;			// swap lists
    		list1_len = list0_len;	// swap lengths
    		list0_len = temp_len;	// swap lengths
    	}

    	int length_diff = list0_len - list1_len;	// take difference, will now be >=0
    	
    	MyLinkedListNode<String> head_0 = list0.getHeadNode();	// list0 head node
    	MyLinkedListNode<String> head_1 = list1.getHeadNode();	// list 1 head node
    	
    	for (int i = 1; i<= length_diff; i++) {	// iterate through length difference so lists are same length afterwards
    		head_0 = head_0.getNext();	// go to next node
    	}
    	
    	int step_counter = 0;	// step counter
    	// at least one value is unique between LL's so don't need to check first node
		while ((head_0.getNext() != null) && (head_0 != head_1)) {		// iterate through list0 or until lists share a node
			head_0 = head_0.getNext();	// next node
    		head_1 = head_1.getNext();	// next node
    		step_counter ++;	// increment counter
    	}
		
		if (head_0 == head_1) {	// if they are equal
			head_1 = list1.getHeadNode(); // reset head1
			
			for (int i = 0; i< step_counter-1; i++) { // iterate through until shared node
				head_1 = head_1.getNext();		// next node
			}
			head_1.setNext(null);	// end list1 before shared node
		}

		
    }

    public static int detectCycleAndPeriod(MyLinkedList<String> list0) {
        // Write some assignment code here!
    	MyLinkedListNode<String> tort = list0.getHeadNode();		// tortoise as head node	
    	MyLinkedListNode<String> hare = list0.getHeadNode();		// hare as head nose
    	if (hare.getNext().getNext() != null) {		// make sure there is room for hare to jump two nodes
    		tort = tort.getNext();	// next node
			hare = hare.getNext().getNext();		// next next node
    	}
    	while ((hare.getNext().getNext() != null) && (hare != tort)) {	// iterate through if hare has room to jump two nodes and hare does not equal tort
			tort = tort.getNext();	// next node
			hare = hare.getNext().getNext();	// next next node
		}
    	if (tort == hare) {	// check if while loop ended because of a cycle
    		int period = 1;	// period = 1
    		tort = tort.getNext();	// next node
    		while (tort != hare) {	// circle tort to check period
    			tort = tort.getNext();	// next node
    			period ++;	// increment period for each jump
    		}
    		return period;	
    	} 
    	else {	
    		return -1;		// if no cycle return -1
    	}

    }

    public static void removeCycle(MyLinkedList<String> list0, int period) {
        // Write some assignment code here!
    	MyLinkedListNode<String> tort = list0.getHeadNode();	// tort as head node
    	MyLinkedListNode<String> hare = list0.getHeadNode();	// hare as head node
    	for (int i = 1; i <= period; i++) {		// jump period number of steps with hare
    		hare = hare.getNext();	// next node
    	}
    	while (hare != tort) {		// iterate through until hit first node where hare = tort
    		hare = hare.getNext();	// next node
    		tort = tort.getNext();	// next node
    	}
    	for (int j = 1; j <= period - 1; j++) { // when equal traverse cycle until last unique node
    		hare = hare.getNext();	// next node
    	}	
    	hare.setNext(null); // end LL before cycle repeat nodes
    }
    public static void removeLinkedListCycles(MyLinkedList<String> list0) {
        int period = detectCycleAndPeriod(list0);    
        if(period != -1) {		// added test
        	removeCycle(list0, period);
        	System.out.println(list0.toString());
        }
    }

    // Code to setup one test case for eliminating shared nodes from two linked lists
    public static void createAndTestSharedNode() {
        // Your assignment submission should have more specific error handling
        try{
        MyLinkedList<String> stage0 = new MyLinkedList<String>();
        stage0.appendToTail("Arkells");
        stage0.appendToTail("Bruno Mars");
        stage0.appendToTail("Coldplay");
        stage0.appendToTail("David Bowie");
        stage0.appendToTail("Earth, Wind & Fire");
        
        MyLinkedList<String> stage1 = new MyLinkedList<String>();
        stage1.appendToTail("Foo Fighters");
        stage1.appendToTail("Gorillaz");



        MyLinkedListNode<String> node;
        node = stage0.searchByValue("Coldplay");
        stage1.appendToTail(node);

        System.out.println("Shared Nodes: Stage 0 Lineup");
        System.out.println(stage0.toString());
        System.out.println("Shared Nodes: Stage 1 Lineup");
        System.out.println(stage1.toString());
        System.out.println("\n");

        removeSharedLinkedListNodes(stage0, stage1);

        System.out.println("Shared Nodes Fixed: Stage 0 Lineup");
        System.out.println(stage0.toString());
        System.out.println("Shared Nodes Fixed: Stage 1 Lineup");
        System.out.println(stage1.toString());
        System.out.println("\n");

        } catch (Exception e) {}
    }
    
    // Code to setup one test case for eliminating cycles from a linked list
    public static void createAndTestCycle() {
        // Your assignment submission should have more specific error handling
        try {
        MyLinkedList<String> stage0 = new MyLinkedList<String>();
        stage0.appendToTail("Arkells");
        stage0.appendToTail("Bruno Mars");
        stage0.appendToTail("Coldplay");
        stage0.appendToTail("David Bowie");
        stage0.appendToTail("Earth, Wind & Fire");
        stage0.appendToTail("Foo Fighters");
        stage0.appendToTail("Gorillaz");
        
        MyLinkedListNode<String> loopToNode;
        loopToNode = stage0.searchByValue("Coldplay");

        MyLinkedListNode<String> tail;
        tail = stage0.searchByValue("Gorillaz");
        if(tail != null)
            tail.setNext(loopToNode);


        System.out.println("Cyclic Nodes: Stage 0 Lineup");
        MyLinkedListNode<String> currentNode;
        currentNode = stage0.searchByValue("Arkells");

        // If we use the toString method it will never terminate. 
        // Most linked list operations on this list will not work, so be careful!
        for(int i = 0; i<10 & currentNode != null; i++) { 
            System.out.println("Element: " + currentNode.toString());
            currentNode = currentNode.getNext();
        }
        System.out.println("\n");

        removeLinkedListCycles(stage0);
        
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        //Feel free to set up different tests, your code should be general, and will be tested against other cases
        createAndTestSharedNode();
        createAndTestCycle();
    }
}
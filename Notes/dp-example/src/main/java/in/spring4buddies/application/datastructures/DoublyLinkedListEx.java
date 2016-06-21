package in.spring4buddies.application.datastructures;

import java.util.NoSuchElementException;

class Node1 {

	public int data; // data in Node.
	public Node1 next; // points to next Node in list.
	public Node1 previous; // points to previous Node in list.

	public Node1(int data) {
		this.data = data;
	}

	public void displayNode() {
		System.out.print(data + " ");
	}
}

public class DoublyLinkedListEx {
	private Node1 first; // ref to first link on LinkedList
	private Node1 last; // ref to last link on LinkedList

	public DoublyLinkedListEx() {
		first = null;
	}

	public void insertFirst(int data) { // insert at front of list
		Node1 newNode = new Node1(data); // creation of new node.
		if (first == null) // means LinkedList is empty.
			last = newNode; // newNode <--- last
		else
			first.previous = newNode; // newNode <-- old first
		newNode.next = first; // newNode --> old first
		first = newNode; // first --> newNode
	}

	public Node1 deleteFirst() {

		if (first == null) { // means LinkedList in empty, throw exception.
			throw new NoSuchElementException(
					"LinkedList doesn't contain any Nodes.");
		}

		Node1 tempNode = first;
		if (first.next == null) // if only one item
			last = null; // null <-- last
		else
			first.next.previous = null; // null <-- old next
		first = first.next; // first --> old next
		return tempNode;
	}

	public void displayFrwd() {
		System.out.print("Displaying in forward direction [first--->last] : ");
		Node1 tempDisplay = first; // start at the beginning of linkedList
		while (tempDisplay != null) { // Executes until we don't find end of
										// list.
			tempDisplay.displayNode();
			tempDisplay = tempDisplay.next; // move to next Node
		}
		System.out.println("");
	}

	public void displayBckwrd() {
		System.out.print("Displaying in backward direction [last-->first] : ");
		Node1 tempDisplay = last; // start at the end of linkedList
		while (tempDisplay != null) {// Executes until we don't find start of
										// list.
			tempDisplay.displayNode();
			tempDisplay = tempDisplay.previous; // move to previous Node
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		DoublyLinkedListEx linkedList = new DoublyLinkedListEx(); // creation of
																	// Linked
																	// List

		linkedList.insertFirst(11);
		linkedList.insertFirst(21);
		linkedList.insertFirst(59);
		linkedList.insertFirst(14);
		linkedList.insertFirst(39);

		linkedList.displayFrwd(); // display DoublyLinkedList
		linkedList.displayBckwrd();

		System.out.print("Deleted Nodes: ");
		Node1 deletedNode = linkedList.deleteFirst(); // delete Node
		deletedNode.displayNode(); // display deleted Node.
		deletedNode = linkedList.deleteFirst(); // delete Node.
		deletedNode.displayNode(); // display deleted Node.

		System.out.println();// sysout used to format output

		linkedList.displayFrwd(); // display DoublyLinkedList
		linkedList.displayBckwrd();

	}
}

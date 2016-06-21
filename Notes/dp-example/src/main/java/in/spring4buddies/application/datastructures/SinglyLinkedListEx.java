package in.spring4buddies.application.datastructures;

import java.util.NoSuchElementException;

class Node {

	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;
	}

	public void displayNode() {
		System.out.print(data + " ");
	}
}

public class SinglyLinkedListEx {

	private Node first;

	public SinglyLinkedListEx() {
		first = null;
	}

	public void insertFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = first;
		first = newNode;
	}

	public Node deleteFirst() {
		if (first == null) {
			throw new NoSuchElementException(
					"LinkedList doesn't contain any Nodes.");
		}
		Node tempNode = first;
		first = first.next;
		return tempNode;
	}

	public void insertLast(int data) {
		Node newNode = new Node(data);

		if (first == null) {
			first = newNode;
			return;
		}

		Node tempNode = first;
		while (tempNode.next != null) {
			tempNode = tempNode.next;
		}
		tempNode.next = newNode;
	}

	/**
	 * Deletes last Node from Singly LinkedList
	 */
	public Node deleteLast() {

		// Case1: when there is no element in LinkedList
		if (first == null) { // means LinkedList in empty, throw exception.
			throw new NoSuchElementException(
					"LinkedList doesn't contain any Nodes.");
		}

		// Case2: when there is only one element in LinkedList
		if (first.next == null) {
			Node tempNode = first;
			first = first.next;
			return tempNode;
		}

		// Case3: when there are atLeast two elements in LinkedList
		Node previous = null;
		Node current = first;

		while (current.next != null) {
			previous = current;
			current = current.next; // move to next node.
		}

		previous.next = null;
		return current;
	}

	public void displayLinkedList() {
		System.out.print("Displaying LinkedList [first--->last]: ");
		Node tempDisplay = first;
		while (tempDisplay != null) {
			tempDisplay.displayNode();
			tempDisplay = tempDisplay.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SinglyLinkedListEx linkedList = new SinglyLinkedListEx();

		linkedList.insertFirst(11);
		linkedList.insertFirst(21);
		linkedList.insertFirst(59);
		linkedList.insertFirst(14);
		linkedList.insertFirst(39);

		linkedList.displayLinkedList(); // display LinkedList

		System.out.print("Deleted Nodes: ");
		Node deletedNode = linkedList.deleteFirst(); // delete Node
		deletedNode.displayNode(); // display deleted Node.

		deletedNode = linkedList.deleteFirst(); // delete Node.
		deletedNode.displayNode(); // display deleted Node.

		System.out.println();// sysout used to format output
		linkedList.displayLinkedList(); // Again display LinkedList

	}
}

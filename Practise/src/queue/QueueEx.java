package queue;

import java.util.NoSuchElementException;

public class QueueEx {

	protected int queue[];
	protected int front, rear, size, count;

	public QueueEx(int size) {
		this.size = size;
		count = 0;
		queue = new int[size];
		front = 0;
		rear = 0;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == size;
	}

	public int peek() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		return queue[front];
	}

	public void enqueue(int element) {
		if (isFull())
			System.out.println("Queue is full");
		if (rear == size)
			rear = 0;
		queue[rear++] = element;
		System.out.println("enqueue = " + element);
		count++;
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		int element = queue[front++];
		if (front == size)
			front = 0;
		count--;
		System.out.println("dequeue = " + element);
		return element;
	}

	public void display() {
		System.out.print("\nDisplay Queue = ");
		for (int i : queue) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QueueEx queueEx = new QueueEx(5);
		queueEx.display();
		queueEx.enqueue(10);
		queueEx.enqueue(20);
		queueEx.enqueue(30);
		queueEx.display();
		queueEx.dequeue();
		queueEx.display();
		queueEx.enqueue(40);
		queueEx.enqueue(50);
		queueEx.display();
		queueEx.dequeue();
		queueEx.dequeue();
		queueEx.display();
		queueEx.dequeue();
		queueEx.dequeue();
		queueEx.display();
		queueEx.dequeue();
		queueEx.display();
	}
}
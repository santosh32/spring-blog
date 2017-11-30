package queue;

public class DynamicQueueEx {

	private int capacity = 2;
	int queue[];
	int front = 0;
	int rear = -1;
	int size = 0;

	public DynamicQueueEx() {
		queue = new int[this.capacity];
	}

	public void enqueue(int item) {

		if (isQueueFull()) {
			System.out.println("Queue is full, increase capacity...");
			increaseCapacity();
		}
		rear++;
		if (rear >= queue.length && size != queue.length) {
			rear = 0;
		}
		queue[rear] = item;
		size++;
		System.out.println("Adding: " + item);
	}

	public void dequeue() {
		if (isQueueEmpty()) {
			System.out
					.println("Underflow ! Unable to remove element from Queue");
		} else {
			front++;
			if (front > queue.length - 1) {
				System.out.println("removed: " + queue[front - 1]);
				front = 0;
			} else {
				System.out.println("removed: " + queue[front - 1]);
			}
			size--;
		}
	}

	public boolean isQueueFull() {
		boolean status = false;
		if (size == queue.length) {
			status = true;
		}
		return status;
	}

	public boolean isQueueEmpty() {
		boolean status = false;
		if (size == 0) {
			status = true;
		}
		return status;
	}

	private void increaseCapacity() {

		// create new array with double size as the current one.
		int newCapacity = this.queue.length * 2;
		int[] newArr = new int[newCapacity];
		// copy elements to new array, copy from rear to front
		int tmpFront = front;
		int index = -1;
		while (true) {
			newArr[++index] = this.queue[tmpFront];
			tmpFront++;
			if (tmpFront == this.queue.length) {
				tmpFront = 0;
			}
			if (size == index + 1) {
				break;
			}
		}
		// make new array as queue
		this.queue = newArr;
		System.out.println("New array capacity: " + this.queue.length);
		// reset front & rear values
		this.front = 0;
		this.rear = index;
	}

	public static void main(String a[]) {

		DynamicQueueEx queue = new DynamicQueueEx();
		queue.enqueue(4);
		queue.dequeue();
		queue.enqueue(56);
		queue.enqueue(2);
		queue.enqueue(67);
		queue.dequeue();
		queue.enqueue(24);
		queue.enqueue(98);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(435);
		queue.dequeue();
		queue.dequeue();
	}
}
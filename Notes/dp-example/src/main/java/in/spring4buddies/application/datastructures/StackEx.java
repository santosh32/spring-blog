package in.spring4buddies.application.datastructures;

public class StackEx {

	protected int stack[];
	protected int top, size, count;

	public StackEx(int n) {
		size = n;
		stack = new int[size];
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == size - 1;
	}

	public void push(int element) {
		if (isFull())
			System.out.println("Stack is full");
		stack[++top] = element;
		System.out.println("push = " + element);
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		int element = stack[top--];
		System.out.println("pop = " + element);
		return element;
	}

	public void display() {
		System.out.print("\nDisplay Stack = ");
		for (int i : stack) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackEx stackEx = new StackEx(5);
		stackEx.display();
		stackEx.push(10);
		stackEx.push(20);
		stackEx.push(30);
		stackEx.display();
		stackEx.pop();
		stackEx.display();
		stackEx.push(40);
		stackEx.push(50);
		stackEx.display();
		stackEx.pop();
		stackEx.pop();
		stackEx.display();
		stackEx.pop();
		stackEx.pop();
		stackEx.display();
		stackEx.pop();
		stackEx.display();
	}
}

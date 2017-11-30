package stack;

public class StackEx {

	private int size;
	private int[] stack;
	private int top;

	public StackEx(int size) {
		this.size = size;
		this.stack = new int[size];
		this.top = -1;
	}

	public void push(int entry) throws Exception {
		if (this.isStackFull()) {
			throw new Exception("Stack is already full. Can not add element.");
		}
		System.out.println("Adding: " + entry);
		this.stack[++top] = entry;
	}

	public int pop() throws Exception {
		if (this.isStackEmpty()) {
			throw new Exception("Stack is empty. Can not remove element.");
		}
		int entry = this.stack[top--];
		System.out.println("Removed entry: " + entry);
		return entry;
	}

	public int peek() {
		return stack[top];
	}

	public boolean isStackEmpty() {
		return (top == -1);
	}

	public boolean isStackFull() {
		return (top == size - 1);
	}

	public static void main(String[] args) {
		StackEx stack = new StackEx(5);
		try {
			stack.push(4);
			stack.push(8);
			stack.push(3);
			stack.push(89);
			stack.pop();
			stack.push(34);
			stack.push(45);
			stack.push(78);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
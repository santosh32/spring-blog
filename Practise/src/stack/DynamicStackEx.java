package stack;

public class DynamicStackEx {

	private int size;
	private int[] stack;
	private int top;

	public DynamicStackEx(int size) {
		this.size = size;
		this.stack = new int[size];
		this.top = -1;
	}

	public void push(int entry) {
		if (this.isStackFull()) {
			System.out.println(("Stack is full. Increasing the capacity."));
			this.increaseStackCapacity();
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

	public long peek() {
		return stack[top];
	}

	private void increaseStackCapacity() {

		int[] newStack = new int[this.size * 2];
		for (int i = 0; i < size; i++) {
			newStack[i] = this.stack[i];
		}
		this.stack = newStack;
		this.size = this.size * 2;
	}

	public boolean isStackEmpty() {
		return (top == -1);
	}

	public boolean isStackFull() {
		return (top == size - 1);
	}

	public static void main(String[] args) {
		DynamicStackEx stack = new DynamicStackEx(2);
		for (int i = 1; i < 10; i++) {
			stack.push(i);
		}
		for (int i = 1; i < 4; i++) {
			try {
				stack.pop();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
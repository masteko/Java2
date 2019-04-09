package stack;

import java.util.ArrayList;

public class NewStack implements StackInterface {
	private ArrayList<Object> stack;
	
	public NewStack() {
		stack = new ArrayList<>();
	}

	@Override
	public void push(Object element) {
		stack.add(0, element);		
	}

	@Override
	public Object pop() {
		return stack.remove(0);
	}

	@Override
	public Object[] getStackArray() {
		return stack.toArray();
	}
	
	public static void main(String[] args) {
		NewStack ns = new NewStack();
		ns.push(1);
		ns.push(2);
		ns.push(3);
		
		Object[] arr = ns.getStackArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}

package stack;

import java.util.ArrayList;

public class Stack<E> extends ArrayList
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1863628370692508347L;

	public void push(E element) {
		this.add(0, element);
	}
	
	public Object pop() {
		return this.remove(0);
	}
	
	public static void main(String[] args) {
		//man hat auch alle ArrayList methoden...
		Stack<String> stack = new Stack<>();
		stack.push("Hallo");
		stack.push("Welt");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}

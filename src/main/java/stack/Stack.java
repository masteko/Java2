package stack;

import java.util.ArrayList;

@SuppressWarnings("all") //unterdrueckt alle Warnings
public class Stack extends ArrayList
{
 
	public void push(Object element) {
		this.add(0, element);
	}
	
	public Object pop() {
		return this.remove(0);
	}
	
	public static void main(String[] args) {
		//man hat auch alle ArrayList methoden...
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.toString());
		stack.forEach(s -> System.out.println(s));
		System.out.println("");
		
		System.out.println(stack.pop());
		System.out.println(stack.toString());
	}

}

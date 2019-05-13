package de.fhws.Aufgabe17;

import java.util.ArrayList;


public class NewStack<E> implements StackInterface<E> {
	private ArrayList<E> stack;
	
	public NewStack() {
		stack = new ArrayList<>();
	}

	@Override
	public void push(E element) {
		stack.add(0, element);		
	}

	@Override
	public E pop() {
		return stack.remove(0);
	}

	@Override
	public E[] getStackArray() {
		return (E[]) stack.toArray();
	}
	
	public static void main(String[] args) {
		NewStack<String> ns = new NewStack<>();
		ns.push("Hallo");
		ns.push("Welt");
		
		System.out.println(ns.pop());
		System.out.println(ns.pop());
	}
}

package de.fhws.Aufgabe17;

public interface StackInterface<E> {
	public void push(E element);
	public E pop();
	public E[] getStackArray();
}

package misc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;

public class Array<E> implements Iterable<E>{
	Node<E> root;
	
	@Override
	public Iterator<E> iterator() {
		return new ListIterator<E>(this);
	}
	
	public void add(E el) {
		if (root == null) {
			root = new Node<E>(el);
		} else {
			root.add(el);
		}
	}
	
	@Override
	public String toString() {
		String result = "";
		if (root != null)  {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			
			ps.println(root);
			
			ps.flush();
			ps.close();
			
			result = baos.toString();
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	private class ListIterator<E> implements Iterator<E> {
		Array<E>.Node<E> current;
		
		private ListIterator(Array<E> arr) {
			this.current = arr.root;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			E data = current.element;
			current = current.next;
			return data;
		}
		
	}
	
	private class Node<E> {
		E element;
		Node<E> next;
		
		private Node() {};
		
		private Node(E element) {
			this.element = element;
		}
		
		private void add(E element) {
			if (next == null) {
				next = new Node<E>(element);
			} else {
				next.add(element);
			}
		}
	}
	
	public static void main(String[] args) {
		Array<String> arr = new Array<>();
		arr.add("Hallo");
		arr.add("Ciao");
		arr.add("Bye");
		
		//System.out.println(arr);
		
		for (String s : arr) {
			System.out.println(s);
		}
	}
}

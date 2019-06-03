package misc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Array<E> implements Iterable<E>, List<E>{
	Node<E> root;
	int size;
	
	public Array() {
		size = 0;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ListIterator(this);
	}
	
	public boolean add(E el) {
		if (root == null) {
			root = new Node<E>(el);
		} else {
			root.add(el);
		}
		size++;
		return true;
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
	
	private class ListIterator implements Iterator<E> {
		Array.Node<E> current;
		
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
	
	private static class Node<E> {
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
		arr.add("Bye");
		arr.add("asd");
		arr.add("fddf");
		arr.add(6, "Ciao");
		
		System.out.println(arr.get(3));
				
		//System.out.println(arr);
		
		for (String s : arr) {
			//System.out.println(s);
		}
	}

	@Override
	public void add(int index, E element) {
		int i = 0;
		Node<E> tmp = this.root;
		Node<E> prev = null;
		
		while (i != index && tmp != null) {
			prev = tmp;
			tmp = tmp.next;
			i++;
		}
		
		if (prev != null) {
			Node<E> n = new Node<E>(element);
			n.next = tmp;
			prev.next = n;
		} else {
			add(element);
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		this.root = null;
	}

	@Override
	public boolean contains(Object o) {
		Node<E> tmp = this.root;
		
		while (tmp != null) {
			if (tmp.element == o) {
				return true;
			}
			tmp = tmp.next;
		}
		
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		int i = 0;
		Node<E> tmp = this.root;
		
		while(i != index && tmp != null) {
			tmp = tmp.next;
			i++;
		}
		
		return tmp.element;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public java.util.ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {	
		return size;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		Node<E> tmp = this.root;
		E[] result = (E[]) new Object[size()];
		int i = 0;
		
		while (tmp != null) {
			result[i] = tmp.element;
			i++;
			tmp = tmp.next;
		}
		
		return result;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}

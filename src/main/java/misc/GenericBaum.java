package misc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.Iterator;

public class GenericBaum<E extends Comparable<E>> {
	Node root;
	
	public static void main(String[] args) {
		GenericBaum<String> gb = new GenericBaum<>();
		gb.add("Hallo");
		gb.add("Anton");
		gb.add("Berta");
		gb.add("Gud");
		gb.add("Xaver");
		gb.add("Gustav");
		gb.add("Björn");
		gb.add("Salary");
		System.out.println(gb);
	}
	
	public void add(E item) {
		Node newNode = new Node(item);

		if (root == null) {
			root = newNode;
		} else {
			insert(root, newNode);
		}
	}
	
	private void insert(Node currN, Node newN) {
		if (currN.content.compareTo(newN.content) >= 0) {
			if(currN.left == null) {
				newN.parent = currN;
				currN.left = newN;
			} else {
				insert(currN.left, newN);
			}
		} else {
			if (currN.right == null) {
				newN.parent = currN;
				currN.right = newN;
			} else {
				insert(currN.right, newN);				
			}
		}
	}
	
	private void printElement(Node e, PrintStream ps) {
		if(e.left != null) {
			printElement(e.left, ps);
		}
		ps.println(e);
		if(e.right != null) {
			printElement(e.right, ps);
		}
	}
	
	@Override
	public String toString() {
		if (root != null) {
			try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PrintStream ps = new PrintStream(baos);) {
				for (Node n : root) {
					ps.println(n);
				}
				ps.flush();
				return baos.toString();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	class Node implements Iterable<Node> {
		E content;
		Node parent;
		Node left;
		Node right;
		
		private Node(E content) {
			this.content = content;
		}
	
		@Override
		public String toString() {
			return content.toString();
		}

		@Override
		public Iterator<GenericBaum<E>.Node> iterator() {
			return new NodeIterator(this);
		}
		
		class NodeIterator implements Iterator<GenericBaum<E>.Node> {
			Node current;
			boolean goRight = true;
			boolean first = true;
			
			private NodeIterator(Node current) {
				this.current = current;
				
				if (this.current != null) {
					while (this.current.left != null) {
						this.current = this.current.left;
					}
				}
			}

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public GenericBaum<E>.Node next() {
		        Node r = current;

		        if(current.right != null) {
		            current = current.right;
		            while (current.left != null)
		                current = current.left;
		            return r;
		        }

		        while(true) {
		            if(current.parent == null) {
		                current = null;
		                return r;
		            }
		            if(current.parent.left == current) {
		                current = current.parent;
		               return r;
		            }
		            current = current.parent;
		        }
			}
		}
	}

}

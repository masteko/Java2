package de.fhws.Aufgabe19;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Baum {
	Element root;
	
	public static void main(String[] args) {
		Baum b = new Baum();
		b.add("Hallo");
		b.add("Anton");
		b.add("Berta");
		b.add("Gud");
		b.add("Xaver");
		b.add("Gustav");
		b.add("Björn");
		b.add("Salary");
		b.print();
	}
	
	public void add(String name) {
		Element e = new Element(name);
		if (root == null) {
			root = e;
		} else {
			einfuegen(root, e);
		}
	}
	
	public void print() {
		System.out.println(this);
	}
	
	private void printElement(Element e, PrintStream ps) {
		if(e.left != null) {
			printElement(e.left, ps);
		}
		ps.println(e);
		if(e.right != null) {
			printElement(e.right, ps);
		}
	}

	private void einfuegen(Element prev, Element e) {
		if (prev.name.compareTo(e.name) > 0) {
			if (prev.left == null) {
				prev.left = e;
			} else {
				einfuegen(prev.left, e);
			}
		} else {
			if(prev.right == null) {
				prev.right = e;
			} else {
				einfuegen(prev.right, e);
			}
		}
	}
	
	@Override
	public String toString() {
		if (root != null) {
			try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PrintStream ps = new PrintStream(baos);) {
				printElement(root, ps);			
				ps.flush();
				return baos.toString();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	class Element {
		String name;
		Element left;
		Element right;
		
		private Element(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
	}
}

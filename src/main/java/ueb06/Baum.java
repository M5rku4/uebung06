package ueb06;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Baum<T extends Comparable<T>> {
	private class Element {
		T value;
		Element left, right;
		Element(T value) { this.value = value; }
	}

	private Element root;

	/**
	 * Fügt ein Element in den Baum ein.
	 */
	void add(T value) {
		if (root == null) {
			root = new Element(value);
			return;
		}

		Element it = root;
		while (it != null) {
			int c = it.value.compareTo(value);

			if (c == 0)
				return;
			else if (c < 0) {
				if (it.left == null) {
					it.left = new Element(value);
					return;
				} else {
					it = it.left;
				}
			} else {
				if (it.right == null) {
					it.right = new Element(value);
					return;
				} else {
					it = it.right;
				}
			}
		}
	}

	/**
	 *  Wie `add`, aber rekursiv zu implementieren.
	 */
	void addRek(T value) {
		if(root == null)
			root = new Element(value);
		else
			addRekH(value, root);
	}

	void addRekH(T value, Element pos){
		if(value.compareTo(pos.value) > 0){
			if(pos.right == null)
				pos.right = new Element(value);
			else {
				addRekH(value, pos.right);
				return;
			}
		} else {
			if(pos.left == null)
				pos.left = new Element(value);
			else {
				addRekH(value, pos.left);
				return;
			}
		}
	}

	/**
	 * Gibt `true` zurück, wenn der Wert `value` im Baum enthalten ist.
	 */
	boolean contains(T value) {
		if (root == null)
			return false;

		Element it = root;
		while (it != null) {
			int c = it.value.compareTo(value);
			if (c == 0)
				return true;
			else if (c < 0)
				it = it.left;
			else
				it = it.right;
		}

		return false;
	}

	/**
	 * Wie `contains`, aber rekursiv zu implementieren.
	 */
	boolean containsRek(T value) {
		return containsH(value, root);
	}

	boolean containsH(T value, Element pos){
		if(pos.value.equals(value))
			return true;
		else if(pos.value.compareTo(value) > 0 && pos.right != null)
			return containsH(value, pos.right);
		else if(pos.value.compareTo(value) < 0 && pos.left != null)
			return containsH(value, pos.left);
		else
			return false;
	}

	/**
	 * Gibt eine Stringrepraesentation des Baums zurück, wobei das Format
	 * eine aufsteigende sortierte Liste darstellt, z.B. [] oder [2, 3, 4].
	 * Abstrakt betrachtet ist dies die sog. Infixschreibweise, bei der fuer
	 * ein Element zuerst der linke Teilbaum, dann der Wert, dann der rechte
	 * Tb. ausgegeben wird.
	 */
	public String toString() {
		Stack<Element> agenda = new Stack<>();

		// Tiefenabstieg nach links
		Element it = root;
		while (it != null) {
			agenda.push(it);
			it = it.left;
		}

		StringBuilder sb = new StringBuilder();

		while (!agenda.empty()) {
			Element e = agenda.pop();
			sb.append(e.value);

			// Tiefenabstieg nach links
			it = e.right;
			while (it != null) {
				agenda.push(it);
				it = it.left;
			}

			if (agenda.size() > 0)
				sb.append(", ");
		}

		return "[" + sb.toString() + "]";
	}

	/**
	 * Zusatzaufgabe: Wie `toString`, nur rekursiv zu implementieren.
	 */
	String toStringRek() {
		throw new UnsupportedOperationException();
	}
}

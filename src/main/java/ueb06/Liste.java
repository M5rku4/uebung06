package ueb06;

class Liste<T> {
	private class Element {
		T value;
		Element next;
		Element(T value) { this.value = value; }
	}

	private Element first;

	/**
	 * Hängt ein Element hinten an die Liste an.
	 */
	void add(T value) {
		if (first == null) {
			first = new Element(value);
			return;
		}

		Element it = first;
		while (it.next != null)
			it = it.next;

		it.next = new Element(value);
	}

	/**
	 * Wie `add`, aber rekursiv zu implementieren.
	 */
	void addRek(T value) {
		if(first == null) {
			first = new Element(value);
			return;
		}

		Element pos = first;
		addRekH(value, pos);
	}

	void addRekH(T value, Element pos){
		if(pos.next == null)
			pos.next = new Element(value);
		else
			addRekH(value, pos.next);
	}

	/**
	 * Gibt `true` zurück, wenn der Wert `value` in der Liste enthalten ist.
	 */
	boolean contains(T value) {
		if (first == null)
			return false;
		Element it = first;

		while (it != null) {
			if (it.value.equals(value))
				return true;
			it = it.next;
		}

		return false;
	}

	/**
	 * Wie `contains`, nur rekursiv zu implementieren.
	 */
	boolean containsRek(T value) {
		return containsH(value, first);
	}

	boolean containsH(T value, Element pos){
		if(pos.value.equals(value))
			return true;
		else if(pos.next != null)
			return containsH(value, pos.next);
		else
			return false;
	}
	/**
	 * Gibt eine Stringrepraesentation der Liste zurück, z.B. [] oder [1, 2, 3]
	 */
	public String toString() {
		if (first == null)
			return "[]";

		StringBuilder sb = new StringBuilder("[");
		sb.append(first.value);

		Element it = first.next;
		while (it != null) {
			sb.append(", ").append(it.value);
			it = it.next;
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Zusatzaufgabe: Wie `toString`, nur rekursiv zu implementieren.
	 */
	String toStringRek() {
		throw new UnsupportedOperationException();
	}
}

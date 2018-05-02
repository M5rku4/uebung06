package ueb06;

class Arrays {
	/**
	 * Gibt eine Stringrepraesentation des Arrays zurueck, z.B. [] oder [1, 2, 3]
	 */
	static <T> String toString(T[] array) {
		if(array.length == 0)
			return "[]";
		else
			return "[" + addString(array, 0) + "]";

	}

	static <T> String addString(T[] array, int pos){
		if (pos +1 > array.length -1){
			return array[pos].toString();
		} else {
			return array[pos].toString() + ", " + addString(array, pos +1);
		}
	}

	/**
	 * Gib zurück, ob ein Objekt in dem Array enthalten ist; verwendet `equals`
	 */
	static <T> boolean contains(T[] array, T object) {
		return containsH(array, object, 0);
	}
	static <T> boolean containsH(T[] array, T object, int pos){
		if(array[pos].equals(object))
			return true;
		else if(!(pos+1 > array.length-1))
			return containsH(array, object, pos+1);
		else
			return false;
	}
}

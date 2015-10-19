package aufgabenblatt1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList<T> {

	private int numberOfElements = 0;
	private T[] list;

	private static final int INDEX_LOWER_BOUND = 0;
	private static final int DEFAULT_SIZE = 0;

	public ArrayList() {
		this(DEFAULT_SIZE);
	}

	/**
	 * Constructor
	 */
	public ArrayList(int size) {
		numberOfElements = 0;
		list = (T[]) new Object[size];
		//list = (T[]) Array.newInstance(Object.class, size);
	}

	/**
	 * Method to add a item to the list
	 * 
	 * @param item
	 *            Item you want to add to the list
	 */
	public void add(T item) {
		if (numberOfElements == list.length) {
			resize(list.length + 1);
		}
		list[list.length - 1] = item;
		numberOfElements++;
	}

	/**
	 * Method to get the content at a specific index
	 * 
	 * @param index
	 *            Index of the list you want to return
	 * @return Returns the content of the list at the specific index
	 * @throws IndexOutOfBoundsException
	 */
	public T get(int index) throws IndexOutOfBoundsException {
		checkIndex(index, numberOfElements - 1);
		return (T) list[index];
	}

	/**
	 * Method to remove a specific item in your list
	 * 
	 * @param item
	 *            Item that you want to remove
	 */
	public void remove(T item) {
		removeAtIndex(getIndexOf(item));
	}

	/**
	 * Method to remove a item at a specific index
	 * 
	 * @param index
	 *            Index of your list
	 */
	public void removeAtIndex(int index) {
		numberOfElements--;
		checkIndex(index, numberOfElements);
		for (int i = 0; i < list.length; i++) {
			if (i > index) {
				list[i - 1] = list[i];
			}
		}
		list = Arrays.copyOfRange(list, 0, numberOfElements);

	}

	/**
	 * Getter
	 * 
	 * @return Returns the number of elements in your list
	 */
	public int getNumberOfElements() {
		return numberOfElements;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < list.length; i++) {
			result = result + list[i];
		}
		return result;
	}

	/**
	 * Method to find the smallest element in your list
	 * 
	 * @return Returns the smallest element
	 */
	// public T getSmallestElement() {
	// T smallestElement = list[0];
	// for (int i = 1; i < list.length; i++) {
	// if (smallestElement.compareTo(list[i]) > 0) {
	// smallestElement = list[i];
	// }
	// }
	// return smallestElement;
	// }

	/**
	 * Method to check if your index is available in your list
	 * 
	 * @param lowerBound
	 *            Lower bound of your list
	 * @param upperBound
	 *            Upper bound of your list
	 * @throws IndexOutOfBoundsException
	 */
	private void checkIndex(int lowerBound, int upperBound)
			throws IndexOutOfBoundsException {
		if ((lowerBound < INDEX_LOWER_BOUND) || (lowerBound > upperBound)) {
			throw new IndexOutOfBoundsException("Index " + lowerBound
					+ " is out of Bounds!");
		}
	}

	/**
	 * Method to resize your existing list
	 * 
	 * @param size
	 *            The new size of your list
	 */
	private void resize(int size) {
		T[] tmp = (T[]) new Object[size];
		for (int i = 0; i < numberOfElements; i++) {
			tmp[i] = list[i];
		}
		list = tmp;
	}

	/**
	 * Getter
	 * 
	 * @return
	 */
	public int getSize() {
		return list.length;
	}

	/**
	 * Method to find the index of your item
	 * 
	 * @param item
	 *            Item your want to find
	 * @return Returns the index of your item
	 */
	public int getIndexOf(T item) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	public int sum() throws Exception {
		int result = 0;
		if (!(list[0] instanceof Integer)) {
			throw new Exception("list does not contain integer");
		}
		for (int i = 0; i < list.length; i++) {
			result += (int) list[i];
		}
		return result;
	}
}

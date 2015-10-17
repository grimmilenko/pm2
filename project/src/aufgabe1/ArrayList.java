package aufgabe1;

public class ArrayList<T> {

	private int numberOfElements;
	private T[] list;

	private static final int INDEX_LOWER_BOUND = 0;

	/**
	 * Default-Constructor
	 */
	public ArrayList() {
		numberOfElements = 0;
		list = (T[]) new Object[0];
	}

	/**
	 * Method to add a item to the list
	 * 
	 * @param item
	 *            Item you want to add to the list
	 */
	public void add(T item) {
		resize(list.length * 2);
		for (int i = 0; i <= numberOfElements; i++) {

		}
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

	}

	/**
	 * Method to remove a item at a specific index
	 * 
	 * @param index
	 *            Index of your list
	 */
	public void removeAtIndex(int index) {
		checkIndex(index, numberOfElements - 1);

	}

	/**
	 * Getter
	 * 
	 * @return Returns the number of elements in your list
	 */
	public int getNumberOfElements() {
		return list.length;
	}

	@Override
	public String toString() {
		return "";
	}

	/**
	 * Method to find the smallest element in your list
	 * 
	 * @return Returns the smallest element
	 */
	public T getSmallestElement() {
		return (T) list[0];
	}

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
}

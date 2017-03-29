

package recursiveList;

import java.util.ArrayList;

public class RecursiveMethodsList<T extends Comparable<T>> {

	private ArrayList<T> elements = new ArrayList<>();

	// do NOT change this method
	public void add(T newElement) {
		if (newElement == null)
			throw new IllegalArgumentException("No way will I add null to the "
					+ "elements field- not a chance!!!");
		else
			elements.add(newElement);
	}

	public boolean isNonDecreasing() {
		return nonDecreasingHelper(0);
	}

	public T elementAfter(T element) {
		if (element == null)
			throw new IllegalArgumentException("");
		return elementAfterHelper(0, element);
	}

	public RecursiveMethodsList<T> elementsBetweenValues(T lowerValue,
			T upperValue) {
		if (lowerValue == null || upperValue == null)
			throw new IllegalArgumentException();
		RecursiveMethodsList<T> list = new RecursiveMethodsList<T>();
		return elementsBetweenHelper(lowerValue, upperValue, list, 0);
	}

	public void replaceWithOtherList(RecursiveMethodsList<T> otherList,
			int startingPos) {
		if (otherList == null)
			throw new IllegalArgumentException();
		else if (startingPos < 0 || startingPos >= elements.size()
				|| elements.size() - startingPos < otherList.elements.size())
			return;
		else
			replaceHelper(otherList, startingPos, 0);
	}

	public String toString() {
		return toStringHelper(0);
	}

	private boolean nonDecreasingHelper(int n) {
		if (n < elements.size() - 1) {
			if (elements.get(n).compareTo(elements.get(n + 1)) < 0
					|| elements.get(n).compareTo(elements.get(n + 1)) == 0)
				return true && nonDecreasingHelper(n + 1);
			else
				return false;
		}
		return true;
	}

	private T elementAfterHelper(int n, T element) {
		if (elements.size() < 2)
			return null;
		if (n < elements.size() - 1) {
			if (elements.get(n).compareTo(element) == 0)
				return elements.get(n + 1);
			else
				return elementAfterHelper(n + 1, element);
		}
		return null;
	}

	private RecursiveMethodsList<T> elementsBetweenHelper(T lower, T upper,
			RecursiveMethodsList<T> list, int n) {
		if (n < elements.size()) {
			if (elements.get(n).compareTo(lower) >= 0
					&& elements.get(n).compareTo(upper) <= 0)
				list.add(elements.get(n));
			return elementsBetweenHelper(lower, upper, list, n + 1);
		}
		return list;
	}

	private String toStringHelper(int n) {
		if (n < elements.size() - 1)
			return elements.get(n) + ", " + toStringHelper(n + 1);
		else if (n == elements.size() - 1)
			return "" + elements.get(n);
		return "";
	}

	private void replaceHelper(RecursiveMethodsList<T> otherList, int pos,
			int n) {
		if (n < otherList.elements.size()) {
			elements.set(pos, otherList.elements.get(n));
			replaceHelper(otherList, pos + 1, n + 1);
		}
	}

}

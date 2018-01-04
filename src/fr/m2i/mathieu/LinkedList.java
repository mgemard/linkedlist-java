package fr.m2i.mathieu;

public class LinkedList<E> {
	private int size = 0;
	private Node<E> first = null;
	private Node<E> last = null;

	// add at the end
	public void push(E e) {
		if (first == null) {
			first = new Node<E>(null, e, null);
		} else {
			Node<E> newNode;
			if (last == null) {
				newNode = new Node<E>(first, e, null);
				first.next = newNode;
			} else {
				newNode = new Node<E>(last, e, null);
				last.next = newNode;
			}
			last = newNode;
		}
		++size;
	}

	// add at the beginning
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(null, e, first);
		if (first != null) {
			first.previous = newNode;
		}
		first = newNode;
		++size;
	}

	// get first element
	public E getFirst() {
		return first.value;
	}

	// get last element
	public E getLast() {
		if (last == null) {
			return null;
		}
		return last.value;
	}

	// remove the first element
	public void removeFirst() {
		if (first != null) {
			first = first.previous;
			--size;
		}
	}

	// remove the last element
	public void pop() {
		if (first == null) {
			return;
		} else if (last == null) {
			first = null;
			--size;
		} else {
			last.previous = null;
		}
	}

	// remove the element at the specified position
	public void remove(int index) {
		LinkedListIterator it = iterator();
		while (it.hasNext()) {
			if (it.position == index) {
				if (it.position == 0) {
					if (it.current.next == null) {
						first = null;
					} else {
						first = first.next;
						if (first.next == null) {
							last = null;
						}
					}
				} else if (it.current.next == null) {
					last = null;
					it.current.previous.next = null;
				} else {
					it.current.next = it.current.previous;
					it.current.previous = it.current.next;
				}
				break;
			}
			it.next();
		}

	}

	// return the number of element
	public int size() {
		return size;
	}

	// check if contains the specified element
	public boolean contains(E e) {
		LinkedListIterator it = iterator();
		while (it.hasNext()) {
			if (it.current.value.equals(e)) {
				return true;
			}
			it.next();
		}
		return false;
	}

	// toString
	public String toString() {
		LinkedListIterator it = iterator();
		if (it.current == null) {
			return "";
		}
		String myString = "";
		myString += it.current.value;
		while (it.hasNext()) {
			it.next();
			myString += " " + it.current.value;
		}
		return myString;
	}

	private class Node<E> {
		E value;
		Node<E> previous;
		Node<E> next;

		Node(Node<E> previous, E element, Node<E> next) {
			this.value = element;
			this.next = next;
			this.previous = previous;
		}
	}

	private class LinkedListIterator implements Iterator<E> {

		Node<E> current;
		int position = 0;

		public LinkedListIterator() {
			current = first;
		}

		@Override
		public boolean hasNext() {
			return current.next != null;
		}

		@Override
		public E next() {
			current = current.next;
			++position;
			return current.value;
		}

		public E previous() {
			current = current.previous;
			--position;
			return current.value;
		}
	}

	public LinkedListIterator iterator() {
		return new LinkedListIterator();
	}

}

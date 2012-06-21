package jp.ac.keio.sfc.ht.cpsf.hiropon.linkedlist;

public class MyLinkedList implements CpsfSimpleList {

	private DoublyLinkedList head;
	private int size;

	public MyLinkedList() {
		head = null;
		size = 0;
	}

	@Override
	public Object get(int index) {
		if (!inRange(index))
			throw new IndexOutOfBoundsException();
		else {
			DoublyLinkedList list = moveElements(index);
			return list.element;
		}
	}

	@Override
	public void add(Object o) {
		if (size == 0) {
			head = new DoublyLinkedList();
			head.previous = head;
			head.next = head;
			head.element = o;
		} else {
			DoublyLinkedList list = new DoublyLinkedList();
			list.previous = head.previous;
			list.next = head;
			head.previous.next = list;
			head.previous = list;
			list.element = o;
		}
		size++;
	}

	@Override
	public void remove(int index) {
		if (!inRange(index))
			throw new IndexOutOfBoundsException();
		else {
			DoublyLinkedList list = moveElements(index);
			if(index == 0)
				head = head.next;
			list.previous.next = list.next;
			list.next.previous = list.previous;
			list = null;
			size--;
		}
	}

	@Override
	public int size() {
		return size;
	}

	private boolean inRange(int index) {
		if (index >= 0 && index < size)
			return true;
		else
			return false;
	}

	private DoublyLinkedList moveElements(int index) {
		DoublyLinkedList list = this.head;
		for (int i = 0; i < index; i++) {
			list = list.next;
		}
		return list;
	}

	private class DoublyLinkedList {
		DoublyLinkedList previous, next;
		Object element;
	}

}

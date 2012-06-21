package jp.ac.keio.sfc.ht.cpsf.hiropon.linkedlist;

import java.util.Collection;

public class HiroponLinkedList<E> implements HiroponSimpleList<E> {

	private DoublyLinkedList head;
	private int size;

	public HiroponLinkedList() {
		this.head = null;
		size = 0;
	}

	public HiroponLinkedList(Collection<? extends E> c) {
		this.addAll(c);
	}

	@Override
	public boolean add(E e) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		if (this.head == null) {
			this.head = doublyLinkedList;
			doublyLinkedList.next = doublyLinkedList;
			doublyLinkedList.previous = doublyLinkedList;
		} else {
			doublyLinkedList.next = this.head;
			doublyLinkedList.previous = this.head.previous;
			this.head.previous.next = doublyLinkedList;
			this.head.previous = doublyLinkedList;
		}
		doublyLinkedList.element = e;
		this.size++;
		return true;
	}

	@Override
	public void add(int index, E element) {
		if (index < 0 || index >= this.size)
			throw new IndexOutOfBoundsException();
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		if (this.head == null) {
			this.head = doublyLinkedList;
			doublyLinkedList.next = doublyLinkedList;
			doublyLinkedList.previous = doublyLinkedList;
		} else {
			DoublyLinkedList list = this.head;
			for (int i = 0; i < index; i++)
				list = list.next;
			if (list.equals(this.head))
				this.head = doublyLinkedList;
			doublyLinkedList.next = list;
			doublyLinkedList.previous = list.previous;
			list.previous.next = doublyLinkedList;
			list.previous = doublyLinkedList;
		}
		doublyLinkedList.element = element;
		this.size++;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		Object[] elements = c.toArray();
		for (int i = 0; i < c.size(); i++) {
			this.add((E) elements[i]);
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		Object[] elements = c.toArray();
		HiroponLinkedList<E> hiroponLinkedList = new HiroponLinkedList();
		for (int i = 0; i < c.size(); i++) {
			hiroponLinkedList.add(index + i, (E) elements[i]);
		}
		return false;
	}

	@Override
	public void addFirst(E e) {
		this.add(0, e);
	}

	@Override
	public void addLast(E e) {
		this.add(e);
	}

	@Override
	public void clear() {
		this.head = null;
		size = 0;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		DoublyLinkedList list = this.head;
		for (int i = 0; i < index; i++)
			list = list.next;
		return (E) list.element;
	}

	@Override
	public E getFirst() {
		return (E) this.head.element;
	}

	@Override
	public E getLast() {
		return (E) this.head.previous.element;
	}

	@Override
	public int indexOf(Object o) {
		DoublyLinkedList list = this.head;
		for (int i = 0; i < this.size; i++) {
			if (o.equals(list.element))
				return i;
			list = list.next;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		DoublyLinkedList list = this.head.previous;
		for (int i = this.size - 1; i >= 0; i--) {
			if (o.equals(list.element))
				return i;
			list = list.previous;
		}
		return -1;
	}

	@Override
	public E remove() {
		return this.remove(0);
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		DoublyLinkedList list = this.head;
		for (int i = 0; i < index; i++)
			list = list.next;
		E tmp = (E) list.element;
		if (list.equals(this.head))
			this.head = this.head.next;
		list.previous.next = list.next;
		list.next.previous = list.previous;
		if (size == 1)
			this.head = null;
		size--;
		return (E) list.element;
	}

	@Override
	public boolean remove(Object o) {
		return this.removeFirstOccurrence(o);
	}

	@Override
	public E removeFirst() {
		return this.remove(0);
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		DoublyLinkedList list = this.head;
		for (int i = 0; i < size; i++) {
			if (o.equals(list.element)) {
				if (list.equals(this.head))
					this.head = this.head.next;
				list.previous.next = list.next;
				list.next.previous = list.previous;
				if (size == 1)
					this.head = null;
				size--;
				return true;
			}
			list = list.next;
		}
		return false;
	}

	@Override
	public E removeLast() {
		if (size == 0)
			throw new IndexOutOfBoundsException();
		DoublyLinkedList list = this.head.previous;
		list.previous.next = this.head;
		this.head.previous = list.previous;
		if (size == 1)
			this.head = null;
		size--;
		return (E) list.element;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		DoublyLinkedList list = this.head.previous;
		for (int i = size - 1; i >= 0; i--) {
			if (o.equals(list.element)) {
				if (list.equals(this.head))
					this.head = this.head.next;
				list.previous.next = list.next;
				list.next.previous = list.previous;
				if (size == 1)
					this.head = null;
				size--;
				return true;
			}
			list = list.previous;
		}
		return false;
	}

	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		DoublyLinkedList list = this.head;
		for (int i = 0; i < index; i++)
			list = list.next;
		E tmp = (E) list.element;
		list.element = element;
		return tmp;
	}

	@Override
	public int size() {
		return size;
	}

	private class DoublyLinkedList {
		DoublyLinkedList previous, next;
		Object element;
	}

}

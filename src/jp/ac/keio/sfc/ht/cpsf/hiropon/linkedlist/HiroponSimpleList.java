package jp.ac.keio.sfc.ht.cpsf.hiropon.linkedlist;

import java.util.Collection;

public interface HiroponSimpleList<E> {

	public boolean add(E e);

	public void add(int index, E element);

	public boolean addAll(Collection<? extends E> c);

	public boolean addAll(int index, Collection<? extends E> c);

	public void addFirst(E e);

	public void addLast(E e);

	public void clear();

	public E get(int index);

	public E getFirst();

	public E getLast();

	public int indexOf(Object o);

	public int lastIndexOf(Object o);

	public E remove();

	public E remove(int index);

	public boolean remove(Object o);

	public E removeFirst();

	public boolean removeFirstOccurrence(Object o);

	public E removeLast();

	public boolean removeLastOccurrence(Object o);

	public E set(int index, E element);

	public int size();

}

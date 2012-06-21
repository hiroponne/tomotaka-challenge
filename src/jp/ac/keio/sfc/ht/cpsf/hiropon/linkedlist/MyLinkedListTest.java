package jp.ac.keio.sfc.ht.cpsf.hiropon.linkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {

	MyLinkedList mll;

	@Before
	public void setUp() throws Exception {
		mll = new MyLinkedList();
	}

	@Test
	public void testGet() {
		this.testAdd();
		for (int i = 0; i < 10; i++) {
			System.out.print(mll.get(i) + ",");
		}
		System.out.println();
	}

	@Test
	public void testAdd() {
		for (int i = 0; i < 10; i++) {
			mll.add(i);
		}
	}

	@Test
	public void testRemove() {
		testAdd();
		mll.remove(0);
		mll.remove(3);
		mll.remove(6);
		for (int i = 0; i < 7; i++) {
			System.out.print(mll.get(i) + ",");
		}
		System.out.println();
	}

	@Test
	public void testSize() {
		testAdd();
		System.out.println(mll.size());
	}

}

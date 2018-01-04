package fr.m2i.mathieu;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

	LinkedList<Integer> linkedList;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		linkedList = new LinkedList<Integer>();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLinkedList() {
		assertTrue("list size initialisation is not empty", linkedList.size() == 0);
	}

	@Test
	void testPushOneGetFirst() {
		Integer firstInt = 1;
		linkedList.push(firstInt);
		assertTrue("did not insert at beginning", linkedList.getFirst().equals(firstInt));
	}

	@Test
	void testPushOneGetLast() {
		linkedList.push(1);
		assertNull("did not insert at beginning", linkedList.getLast());
	}

	@Test
	void testPushTwoGetFirst() {
		Integer firstInt = 1;
		linkedList.push(firstInt);
		linkedList.push(2);
		assertTrue("did not insert at beginning", linkedList.getFirst().equals(firstInt));
	}

	@Test
	void testPushTwoGetLast() {
		Integer lastInt = 2;
		linkedList.push(1);
		linkedList.push(lastInt);
		assertTrue("did not insert at beginning", linkedList.getLast().equals(lastInt));
	}

	@Test
	void testNoEleAddFirst() {
		Integer firstInt = 1;
		linkedList.addFirst(firstInt);
		assertTrue("did not insert at beginning", linkedList.getFirst().equals(firstInt));
	}

	@Test
	void testOneEleAddFirst() {
		Integer firstInt = 2;
		linkedList.push(1);
		linkedList.addFirst(firstInt);
		assertTrue("did not insert at beginning", linkedList.getFirst().equals(firstInt));
	}

	@Test
	void testOneEleRemoveFirstGetFirst() {
		Integer firstInt = 1;
		linkedList.push(firstInt);
		assertTrue("did not remove first elem correctly", linkedList.getFirst().equals(firstInt));
	}

	@Test
	void testOneEleRemoveFirstGetLast() {
		linkedList.push(1);
		assertNull("did not remove first elem correctly", linkedList.getLast());
	}

	@Test
	void testTwoEleRemoveFirstGetFirst() {
		Integer firstInt = 1;
		linkedList.push(2);
		linkedList.addFirst(firstInt);
		assertTrue("did not remove first elem correctly", linkedList.getFirst().equals(firstInt));
	}

	@Test
	void testTwoEleRemoveFirstGetLast() {
		Integer lastInt = 1;
		linkedList.push(2);
		linkedList.push(lastInt);
		assertTrue("did not remove first elem correctly", linkedList.getLast().equals(lastInt));
	}

	@Test
	void testPop() {
		Integer lastInt = 3;
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(lastInt);
		linkedList.pop();
		assertTrue("pop failed", linkedList.getLast().equals(lastInt));
	}

	@Test
	void testOneEleRemove() {
		Integer myIntToDelete = 2;
		linkedList.push(myIntToDelete);
		linkedList.remove(0);
		assertFalse("element has not been removed", linkedList.contains(myIntToDelete));
	}

	@Test
	void testTwoEleRemove() {
		Integer myIntToDelete = 2;
		linkedList.push(1);
		linkedList.push(myIntToDelete);
		linkedList.remove(1);
		assertFalse("element has not been removed", linkedList.contains(myIntToDelete));
	}

	@Test
	void testThreeEleRemove() {
		Integer myIntToDelete = 1;
		linkedList.push(myIntToDelete);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.remove(0);
		assertFalse("element has not been removed", linkedList.contains(myIntToDelete));
	}

	@Test
	void testSize() {
		linkedList.push(1);
		assertTrue("list has not one element", linkedList.size() == 1);
	}

	@Test
	void testContains() {
		Integer myElem = 2;
		linkedList.push(1);
		linkedList.push(myElem);
		linkedList.push(3);
		assertTrue("the list does not contain the element", linkedList.contains(myElem));
	}

	@Test
	void testNoEleToString() {
		assertTrue("toString does not produce the correct result", linkedList.toString().equals(""));
	}

	@Test
	void testOneEleToString() {
		Integer a = 1;
		linkedList.push(a);
		assertTrue("toString does not produce the correct result", linkedList.toString().equals(String.valueOf(a)));
	}

	@Test
	void testTwoEleToString() {
		Integer a = 2;
		Integer b = 1;
		linkedList.push(a);
		linkedList.push(b);
		assertTrue("toString does not produce the correct result", linkedList.toString().equals(a + " " + b));
	}

}

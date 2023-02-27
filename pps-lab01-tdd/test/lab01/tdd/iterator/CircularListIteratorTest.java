package lab01.tdd.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularListIteratorTest {
    private CircularListIterator circularList;

    @BeforeEach
    void setUp() {
        circularList = new CircularListIteratorImpl();
    }

    @Test
    void testAdd() {
        circularList.add(1);
        assertEquals(1, circularList.size());
    }

    @Test
    void testSize() {
        circularList.add(1);
        circularList.add(2);
        assertEquals(2, circularList.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(circularList.isEmpty());
        circularList.add(1);
        assertFalse(circularList.isEmpty());
    }

    @Test
    void testForwardIterator() {
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);

        assertEquals(1, circularList.forwardIterator().next());
        assertEquals(2, circularList.forwardIterator().next());
        assertEquals(3, circularList.forwardIterator().next());
        assertEquals(1, circularList.forwardIterator().next());
    }

    @Test
    void testBackwardIterator() {
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);

        assertEquals(3, circularList.backwardIterator().next());
        assertEquals(2, circularList.backwardIterator().next());
        assertEquals(1, circularList.backwardIterator().next());
        assertEquals(3, circularList.backwardIterator().next());
    }
}
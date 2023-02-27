package lab01.tdd.filtered;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularListFilteredTest {
    CircularListFiltered circularList;

    @BeforeEach
    void setUp() {
        circularList = new CircularListFilteredImpl();
    }

    @Test
    void testAdd() {
        circularList.add(1);
        assertEquals(1, circularList.size());
    }

    @Test
    void testSize() {
        assertEquals(0, circularList.size());
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
    void testFilteredNext() {
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(1, circularList.filteredNext(i  -> i.equals(1)).get());
    }
}
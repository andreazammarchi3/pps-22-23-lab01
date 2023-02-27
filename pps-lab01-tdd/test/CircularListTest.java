import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularList circularList;

    @BeforeEach
    void setUp() {
        circularList = new CircularListImpl();
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
    void testNext() {
        assertEquals(Optional.empty(), circularList.next());

        circularList.add(1);
        circularList.add(2);
        circularList.add(3);

        assertEquals(1, circularList.next().get());
        assertEquals(2, circularList.next().get());
        assertEquals(3, circularList.next().get());
        assertEquals(1, circularList.next().get());
    }

    @Test
    void testPrevious() {
        assertEquals(Optional.empty(), circularList.previous());

        circularList.add(1);
        circularList.add(2);
        circularList.add(3);

        assertEquals(3, circularList.previous().get());
        assertEquals(2, circularList.previous().get());
        assertEquals(1, circularList.previous().get());
        assertEquals(3, circularList.previous().get());
    }

    @Test
    void testReset() {
        circularList.add(1);
        circularList.add(2);

        circularList.next();
        circularList.reset();
        assertEquals(1, circularList.next().get());
    }

}

import mkonyukhov.aston.MyCollection;
import mkonyukhov.aston.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {
    private MyCollection<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
    }

    @Test
    void testConstructorWithCollection() {
        List<Integer> initialList = Arrays.asList(1, 2, 3, 4, 5);

        MyLinkedList<Integer> list = new MyLinkedList<>(initialList);

        assertEquals(initialList.size(), list.size());

        for (int i = 0; i < initialList.size(); i++) {
            assertEquals(initialList.get(i), list.get(i));
        }
    }

    @Test
    void testAddAndGet() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testAddAtIndex() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(1, 10);

        assertEquals(4, list.size());
        assertEquals(1, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(1);

        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void testAddAll() {
        List<Integer> anotherList = new ArrayList<>(Arrays.asList(4, 5, 6));
        list.add(1);
        list.add(2);
        list.addAll(anotherList);

        assertEquals(5, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(4, list.get(2));
        assertEquals(5, list.get(3));
        assertEquals(6, list.get(4));
    }

    @Test
    void testSizeAndIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }
}


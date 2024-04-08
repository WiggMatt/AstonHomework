import mkonyukhov.aston.MyCollections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCollectionsTest {
    @Test
    void testBubbleSort() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2, 4, 7, 6));

        MyCollections.bubbleSort(numbers);

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Assertions.assertEquals(expected, numbers);
    }

    @Test
    void testBubbleSortWithEmptyList() {
        List<Integer> emptyList = new ArrayList<>();

        MyCollections.bubbleSort(emptyList);

        Assertions.assertTrue(emptyList.isEmpty());
    }
}

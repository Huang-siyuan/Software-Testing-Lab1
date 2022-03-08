import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RadixSortTest {

    private static RadixSort radixSort;
    private ArrayList<Integer> expected;
    private ArrayList<Integer> actual;

    @BeforeEach
    void setUp() {
        radixSort = new RadixSort();
    }

    @Test
    @DisplayName("Test 1 for sort")
    void sort1() {
        actual = new ArrayList<>(Arrays.asList(1, 4, 5, 123, 120, 114, 514));
        expected = (ArrayList<Integer>) actual.clone();
        expected.sort(Comparator.naturalOrder());
        radixSort.radixSort(actual);
        assertArrayEquals(actual.toArray(), expected.toArray());
    }

    @Test
    @DisplayName("Test 2 for sort")
    void sort2() {
        actual = new ArrayList<>(Arrays.asList(944, 268, 409, 964, 278, 149, 668, 27, 931, 663, 983, 20));
        expected = (ArrayList<Integer>) actual.clone();
        expected.sort(Comparator.naturalOrder());
        radixSort.radixSort(actual);
        assertArrayEquals(actual.toArray(), expected.toArray());
    }

}

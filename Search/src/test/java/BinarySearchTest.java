import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BinarySearchTest {

    @org.junit.jupiter.api.Test
    void iterativeSearch() {
    }

    @Test
    void search() {
        int[] array = {2, 6, 4, 9};
        Arrays.sort(array);
        Assertions.assertEquals(0, BinarySearch.search(array, 2));
        Assertions.assertEquals(1, BinarySearch.search(array, 4));
        Assertions.assertEquals(2, BinarySearch.search(array, 6));
        Assertions.assertEquals(3, BinarySearch.search(array, 9));
        Assertions.assertEquals(-1, BinarySearch.search(array, 1));
        Assertions.assertEquals(-2, BinarySearch.search(array, 3));
        Assertions.assertEquals(-3, BinarySearch.search(array, 5));
        Assertions.assertEquals(-4, BinarySearch.search(array, 8));
        Assertions.assertEquals(-5, BinarySearch.search(array, 12));
    }

    @Test
    void searchChars() {
        char[] chars = { 'a', 'z', 'y', 'd'};
        Arrays.sort(chars);
        Assertions.assertEquals(0, BinarySearch.search(chars, 'a'));
    }
}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class SortedShiftedArrayTest {
    private List<Integer> list;

    @BeforeEach
    void setUp() {
        int[] array = {1, -6, 5, 0};
        list = Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    @Test
    void findMinimumNoShift() {
        int index = Search.findMinimum(Search.sortAscendingAndRightShift(list, 0));
        Assertions.assertEquals(0, index);
        Assertions.assertEquals(-6, list.get(index));
    }

    @Test
    void findMinimumWithShift() {
        list = Search.sortAscendingAndRightShift(list, 2);
        Assertions.assertEquals(5, list.get(1));
        final int index = Search.findMinimum(list);
        Assertions.assertEquals(2, index);
        Assertions.assertEquals(-6, list.get(index));
    }
}
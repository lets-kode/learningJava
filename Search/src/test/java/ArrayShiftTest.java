import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayShiftTest {
    private List<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>();
        list.add(2);
        list.add(0);
        list.add(-2);
        list.add(5);
    }

    @Test
    void sortAndZeroShift() {
        List<Integer> result = Search.sortAscendingAndRightShift(list, 0);
        Assertions.assertEquals(-2, result.get(0));
        Assertions.assertEquals(0, result.get(1));
        Assertions.assertEquals(2, result.get(2));
        Assertions.assertEquals(5, result.get(3));
    }

    @Test
    void sortAndPositiveShift() {
        List<Integer> result = Search.sortAscendingAndRightShift(list, 2);
        Assertions.assertEquals(2, result.get(0));
        Assertions.assertEquals(0, result.get(result.size() - 1));
    }

    @Test
    void sortAndNegativeShift() {
        List<Integer> result = Search.sortAscendingAndRightShift(list, -3);
        Assertions.assertEquals(5, result.get(0));
        Assertions.assertEquals(2, result.get(result.size() - 1));
    }
}

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearch {
    public static <E extends Comparable<E>> int search(@NotNull List<E> elements, E element) {
        int start = 0, end = elements.size() - 1;
        while (start <= end) {
            final int mid = (start + end) / 2;
            final int comparisonResult = element.compareTo(elements.get(mid));
            if (comparisonResult == 0) {
                return mid;
            } else if (comparisonResult > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (-1 - start);
    }

    public static int search(int[] arr, int value) {
        return search(Arrays.stream(arr).boxed().collect(Collectors.toList()), value);
    }

    public static int search(char[] arr, char value) {
        final List<Character> list = new ArrayList<>();
        for (char c : arr) {
            list.add(c);
        }
        return search(list, value);
    }
}

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class BinarySearch {
    public static <E extends Comparable<E>> int search(@NotNull List<E> elements, E element) {
        return search(elements, element, (BiFunction<E, E, Integer>) Comparable::compareTo);
    }

    public static <E> int search(
            @NotNull List<E> elements,
            @NotNull E element,
            @NotNull Comparator<? super E> comparator) {
        return search(elements, element, (BiFunction<E, E, Integer>) comparator::compare);
    }

    private static <E> int search(
            @NotNull List<E> elements,
            @NotNull E element,
            @NotNull BiFunction<E, E, Integer> function) {
        int start = 0, end = elements.size() - 1;
        while (start <= end) {
            final int mid = (start + end) / 2;
            final int comparisonResult = function.apply(element, elements.get(mid));
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

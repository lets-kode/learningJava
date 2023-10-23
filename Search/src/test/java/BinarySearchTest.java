import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    @Test
    void searchWithComparator() {
        final Student tom1 = new Student("Tom", 7.89f);
        final Student tom2 = new Student("Tom", 9.09f);
        final Student jerry = new Student("Jerry", 9.49f);
        List<Student> list = new ArrayList<>();
        list.add(tom1);
        list.add(tom2);
        list.add(jerry);

        final Comparator<Student> comparator = (o1, o2) -> {
            final int result = Float.compare(o2.getGpa(), o1.getGpa());
            if (result == 0) {
                return o2.getName().compareTo(o1.getName());
            }
            return result;
        };
        list.sort(comparator);

        Assertions.assertEquals(0, BinarySearch.search(list, jerry, comparator));
        Assertions.assertEquals(1, BinarySearch.search(list, tom2, comparator));
        Assertions.assertEquals(2, BinarySearch.search(list, tom1, comparator));
        Assertions.assertEquals(-1, BinarySearch.search(
                list,
                new Student("Jerry", 9.7f),
                comparator));
        Assertions.assertEquals(-3, BinarySearch.search(
                list,
                new Student("Jerry", 8.7f),
                comparator));
        Assertions.assertEquals(-4, BinarySearch.search(
                list,
                new Student("Mich", 6.7f),
                comparator));
    }

    private static class Student {
        private final String name;
        private final float gpa;

        public Student(String name, float gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        public String getName() {
            return name;
        }

        public float getGpa() {
            return gpa;
        }
    }
}
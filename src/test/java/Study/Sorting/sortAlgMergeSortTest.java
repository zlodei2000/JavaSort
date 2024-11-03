package Study.Sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class sortAlgMergeSortTest {

    @Test
    void sortAlgFunc() {
        Integer[] array = {5, 3, 4, 1, 2};
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        sortAlgMergeSort alg = new sortAlgMergeSort(5);
        ArrayList<Integer> sortedList = alg.sortAlgFunc(list);
        assertEquals(sortedList, Arrays.asList(sortedArray));

        sortAlgMergeSort alg2 = new sortAlgMergeSort(3);
        assertThrows(IllegalArgumentException.class, () -> alg2.sortAlgFunc(list));
    }

    @Test
    void getAlgName() {
        sortAlgMergeSort alg = new sortAlgMergeSort(10);
        assertEquals("Merge sort", alg.getAlgName());
    }

    @Test
    void getMaxListSize() {
        sortAlgMergeSort alg = new sortAlgMergeSort(10);
        assertEquals(10, alg.getMaxListSize());
    }
}

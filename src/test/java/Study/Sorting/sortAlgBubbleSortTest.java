package Study.Sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class sortAlgBubbleSortTest {

    @Test
    void sortAlgFunc() {
        Integer[] array = {5, 3, 4, 1, 2};
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        sortAlgBubbleSort alg = new sortAlgBubbleSort(5);
        ArrayList<Integer> sortedList = alg.sortAlgFunc(list);
        assertEquals(sortedList, Arrays.asList(sortedArray));

        sortAlgBubbleSort alg2 = new sortAlgBubbleSort(3);
        assertThrows(IllegalArgumentException.class, () -> alg2.sortAlgFunc(list));
    }

    @Test
    void getAlgName() {
        sortAlgBubbleSort alg = new sortAlgBubbleSort(10);
        assertEquals("Bubble sort", alg.getAlgName());
    }

    @Test
    void getMaxListSize() {
        sortAlgBubbleSort alg = new sortAlgBubbleSort(10);
        assertEquals(10, alg.getMaxListSize());
    }
}

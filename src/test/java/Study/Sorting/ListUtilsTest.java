package Study.Sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ListUtilsTest {

    @Test
    void printList() {
        Integer[] array = {1, 2, 3, 4, 5};
        assertDoesNotThrow(() -> ListUtils.printList(new ArrayList<>()));
        assertDoesNotThrow(() -> ListUtils.printList(new ArrayList<>(Arrays.asList(array))));
    }

    @Test
    void inputList() {
        assertThrows(NegativeArraySizeException.class, () -> ListUtils.inputList(-1, new Scanner("1")));
        ArrayList<Integer> list = ListUtils.inputList(1, new Scanner("2"));
        assertEquals(1, list.size());
        assertEquals(2, list.get(0));
    }

    @Test
    void inputIntMinMax() {
        int i = ListUtils.inputIntMinMax(0,5, new Scanner("4"), "");
        assertEquals(4, i);
    }
}

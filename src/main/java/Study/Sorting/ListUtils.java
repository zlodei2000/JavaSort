package Study.Sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class ListUtils {
    static void printList(ArrayList<Integer> list) {
        if(list != null) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static ArrayList<Integer> inputList(int size, Scanner in){
        if(size > 0) {
            ArrayList<Integer> list = new ArrayList<>(size);
            System.out.printf("Enter %d elements\n", size);
            for (int i = 0; i < size; i++) {
                System.out.printf("Element %d ", i);
                list.add(userSafeIntInput("<Integer>:",in));
            }
            return list;
        }else{
            System.out.println("List size must be a positive integer");
            throw new NegativeArraySizeException("List size must be a positive integer");
        }
    }

    static int inputIntMinMax(int min, int max, Scanner in, String msg)
    {
        if(min > max){
            int tmp = max;
            max = min;
            min = tmp;
        }
        int res = min -1;
        while(res < min || res > max){
                res  = userSafeIntInput(msg, in);
        }
        return res;
    }
    private static int userSafeIntInput(String msg, Scanner in) {
        int i;
        while (true) {
            System.out.print(msg);
            try {
                i = Integer.parseInt(in.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
        return i;
    }
}

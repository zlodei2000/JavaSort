package Study.Sorting;

import java.util.ArrayList;
import java.util.Collections;


public class SortingAlgs {

    static ArrayList<Integer> sortListMergeSort(ArrayList<Integer> listSource, int maxListSize) throws IllegalArgumentException {
        if(listSource.size()> maxListSize){
            throw new IllegalArgumentException("Array to sort is too big for Merge sort");// кинуть исключение здесь
        }
        ArrayList<Integer> list = new ArrayList<> (listSource);
        Collections.sort(list);
        return list;
    }
    static ArrayList<Integer> sortListBubbleSort(ArrayList<Integer> listSource, int maxListSize) throws IllegalArgumentException {
        if(listSource.size()> maxListSize){
            throw new IllegalArgumentException("Array to sort is too big for Bubble sort");// кинуть исключение здесь
        }
        ArrayList<Integer> list = new ArrayList<> (listSource);
        for (int out = list.size() - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(list.get(in) > list.get(in + 1)) {
                    int tmp = list.get(in);
                    list.set(in, list.get(in + 1));
                    list.set(in + 1, tmp);
                }
            }
        }
        return list;
    }
}

package Study.Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class sortAlgMergeSort implements sortAlgInterface {
    private final int maxListSize;

    public sortAlgMergeSort(int maxListSize) {
        this.maxListSize = maxListSize;
    }
     public ArrayList<Integer> sortAlgFunc(ArrayList<Integer> listSource) throws IllegalArgumentException {
        if(listSource.size()> this.maxListSize){
            throw new IllegalArgumentException("Array to sort is too big for Merge sort");// кинуть исключение здесь
        }
        ArrayList<Integer> list = new ArrayList<> (listSource);
        Collections.sort(list);
        return list;
    }
    public String getAlgName() {
        return "Merge sort";
    }
    public int getMaxListSize() {
        return maxListSize;
    }
}

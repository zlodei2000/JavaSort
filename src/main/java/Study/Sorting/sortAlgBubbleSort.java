package Study.Sorting;

import java.util.ArrayList;

public class sortAlgBubbleSort implements sortAlgInterface{
    private final int maxListSize;

    public sortAlgBubbleSort(int maxListSize) {
        this.maxListSize = maxListSize;
    }

    public ArrayList<Integer> sortAlgFunc(ArrayList<Integer> listSource) throws IllegalArgumentException {
        if(listSource.size()> this.maxListSize){
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
    public String getAlgName() {
        return "Bubble sort";
    }
    public int getMaxListSize() {
        return maxListSize;
    }
}

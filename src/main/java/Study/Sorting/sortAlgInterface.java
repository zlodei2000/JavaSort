package Study.Sorting;

import java.util.ArrayList;

public interface sortAlgInterface     {
    ArrayList<Integer> sortAlgFunc(ArrayList<Integer> listSource) throws IllegalArgumentException;
    String getAlgName();
    int getMaxListSize();
}

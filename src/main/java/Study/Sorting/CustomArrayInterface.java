package Study.Sorting;

public interface CustomArrayInterface <T> {
    T get(int index);
    void remove(int index);
    boolean add(T item);
    int size();
}

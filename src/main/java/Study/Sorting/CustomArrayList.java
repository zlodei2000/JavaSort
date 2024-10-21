package Study.Sorting;

public class CustomArrayList<T> implements CustomArrayInterface<T> {
    private T[] array;
    private int size;
    private int memCapacity;
    private static final int GRANULARITY = 16;

    public CustomArrayList(){
        array = (T[]) new Object[GRANULARITY];
        size = 0;
        memCapacity = GRANULARITY;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = index; i < size - 1; i++){
            array[i] = array[i+1];
        }
        array[size - 1] = null;
        size--;
    }

    @Override
    public boolean add(T item) {
        if(item == null)
            return false;
        else {
            if(size == memCapacity){
                T[] newarray =  (T[]) new Object[GRANULARITY + memCapacity];
                System.arraycopy(array, 0, newarray, 0, size);
                array = newarray;
                memCapacity += GRANULARITY;
            }
            array[size] = (T) item;
            size++;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }
}

import java.util.Arrays;

public class Array<T> {
    private final Object[] arr;

    public Array(int size) {
        arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 0;
        }
    }

    public void setValue(int index, T value) {
        if (index >= arr.length)
            throw new IllegalArgumentException("Index out of bound");
        arr[index] = value;
    }

    public T getValue(int index) {
        if (index >= arr.length)
            throw new IllegalArgumentException("Index out of bound");
        return (T) arr[index];
    }

    public void removeValue(int index) {
        if (index >= arr.length)
            throw new IllegalArgumentException("Index out of bound");
        arr[index] = null;
    }

    @Override
    public String toString() {
        return "Array{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}

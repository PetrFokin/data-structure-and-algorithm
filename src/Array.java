import java.util.Arrays;

/**
 * Array is a physical linear data structure.
 * <p>
 * Time complexity:
 * - Insertion at the beginning O(n)
 * - Insertion at the middle O(n)
 * - Insertion at the end O(1)
 * - Access by index from either position O(1)
 * - Search element O(n)
 * - Deletion O(n)
 * <p>
 * When to use:
 * - Need access the elements using the index.
 * - Know the size of the array before defining the memory.
 * - Array takes less memory compare than linked list.
 */
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

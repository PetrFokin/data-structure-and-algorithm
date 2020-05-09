package stack.array;

import java.util.Arrays;

/**
 * Stack is abstract liner data structure. Where all elements are ordered by LIFO.
 * Time complexity:
 * - Insertion O(1)
 * - Access O(1)
 * - Deletion O(1)
 * When use:
 * - Get things out in the reverse order than you put them in.
 * Examples:
 * - Traversing the tree/graph - Depth-first walk.
 * - Runtime memory management (Java Stack).
 * <p>
 * This implementation is based on array data structure.
 */
public class Stack<T> {

    private Object[] arr;
    private int currentIndex = -1;

    public Stack(int capacity) {
        arr = new Object[capacity];
    }

    public void push(T value) {
        if (currentIndex == arr.length - 1)
            throw new UnsupportedOperationException("Stack is full");
        currentIndex++;
        arr[currentIndex] = value;
    }

    public T peek() {
        return (T) arr[currentIndex];
    }

    public T pop() {
        T value = (T) arr[currentIndex];
        arr[currentIndex] = null;
        currentIndex--;
        return value;
    }

    public boolean isFull() {
        return currentIndex == arr.length - 1;
    }

    public boolean isEmpty() {
        return currentIndex == -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}

package stack.array;

import java.util.Arrays;

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

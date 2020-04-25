package queue.array;

import java.util.Arrays;

public class Queue<T> {

    private Object[] arr;
    private int top = 0;
    private int end = 0;

    public Queue(int capacity) {
        arr = new Object[capacity];
    }

    public void offer(T value) {
        if (end == arr.length)
            throw new UnsupportedOperationException("Queue is full");
        arr[end] = value;
        end++;
    }

    public T peek() {
        return (T) arr[top];
    }

    public T pop() {
        T value = (T) arr[top];
        for (int i = 0; i < end - 1; i++) {
            arr[i] = arr[i + 1];
            arr[i + 1] = null;
        }
        end--;
        return value;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}

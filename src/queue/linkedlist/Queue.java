package queue.linkedlist;

import static java.lang.String.valueOf;

/**
 * Queue is an abstract liner data structure. Where all elements are ordered by FIFO.
 * Time complexity:
 * - Insertion O(1)
 * - Taking O(1)
 * - Deletion O(1)
 * When use:
 * - Get things out in the order that you put them in.
 * Examples:
 * - Traversing tree/graph - breadth-first walk.
 * <p>
 * This implementation is based on linked list data structure.
 */
public class Queue<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public void offer(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
        }

        if (tail != null) {
            tail.next = node;
        }

        tail = node;
        size++;
    }

    public T peek() {
        if (size == 0)
            throw new UnsupportedOperationException("Queue is empty");

        return head.value;
    }

    public T pop() {
        if (size == 0)
            throw new UnsupportedOperationException("Queue is empty");

        Node<T> node = head;
        head = node.next;
        size--;
        return node.value;
    }

    public int size() {
        return size;
    }

    private class Node<T> {
        private Node<T> next = null;
        private T value;

        private Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return valueOf(value);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Queue: ");
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(currentNode);
            stringBuilder.append(" ");
            currentNode = currentNode.next;
        }
        return stringBuilder.toString();
    }
}

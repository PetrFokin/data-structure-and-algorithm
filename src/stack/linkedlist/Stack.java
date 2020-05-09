package stack.linkedlist;

import static java.lang.String.valueOf;

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
 * This implementation is based on linked list data structure.
 */
public class Stack<T> {

    private Node<T> head = null;
    private int size = 0;

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        size++;
    }

    public T peek() {
        return head.value;
    }

    public T pop() {
        Node<T> node = head;
        head = node.next;
        size--;
        return node.value;
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
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(currentNode);
            stringBuilder.append(" ");
            currentNode = currentNode.next;
        }
        return stringBuilder.toString();
    }
}

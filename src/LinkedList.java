import static java.lang.String.valueOf;

public class LinkedList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public void addElement(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
        }

        if (tail != null) {
            tail.next = node;
            node.next = head;
            node.before = tail;
        }

        tail = node;
        head.before = tail;

        size++;
    }

    public void addElement(int index, T value) {
        if (index < 0)
            throw new UnsupportedOperationException("Index of new element is negative");
        if (index >= size) {
            addElement(value);
        } else {
            if (index == 0) {
                addToHead(value);
            } else {
                Node<T> tempNode;
                if (index < size / 2) {
                    tempNode = findFromHead(index);
                } else {
                    tempNode = findFromTail(index);
                }
                Node<T> newNode = new Node<>(value);
                newNode.next = tempNode;
                newNode.before = tempNode.before;
                newNode.before.next = newNode;
                tempNode.before = newNode;
                size++;
            }
        }
    }

    public T getElement(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("Index out of bound LinkedList");
        Node<T> node;
        if (index < size / 2) {
            node = findFromHead(index);
        } else {
            node = findFromTail(index);
        }
        return node.value;
    }

    public T removeElement(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("Index out of bound LinkedList");

        Node<T> node;
        if (index == 0) {
            node = head;
            head = node.next;
            node.next.before = tail;
            size--;
            return node.value;
        }

        if (index == size - 1) {
            node = tail;
            tail = node.before;
            node.before.next = head;
            size--;
            return node.value;
        }

        if (index < size / 2) {
            node = findFromHead(index);
        } else {
            node = findFromTail(index);
        }

        Node<T> nodeBeforeRemoved = node.before;
        Node<T> nodeNextRemoved = node.next;
        nodeBeforeRemoved.next = nodeNextRemoved;
        nodeNextRemoved.before = nodeBeforeRemoved;

        size--;
        return node.value;
    }



    private Node<T> findFromHead(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    private void addToHead(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        newNode.before = tail;
        head.before = newNode;
        head = newNode;
        size++;
    }

    private Node<T> findFromTail(int index) {
        Node<T> node = tail; //10
        for (int i = size - 1; i > index; i--) { //11
            node = node.before; //9
        }

        return node;
    }

    public int findElement(T value) {
        int index = -1;
        if (size == 0)
            return index;

        Node currentNode = head;

        for (int i = 0; i < size; i++) {  //10
            if (currentNode.value == value) {
                index = i; //10
                break;
            } else {
                currentNode = currentNode.next;  //null
            }
        }

        return index;
    }

    /*private Node<T> findByIndex(int index, int start, int end) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }*/


    private static class Node<T> {
        private T value;
        private Node<T> before = null;
        private Node<T> next = null;

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
        StringBuilder stringBuilder = new StringBuilder("LinkedList: ");
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(currentNode);
            stringBuilder.append(" ");
            currentNode = currentNode.next;
        }
        return stringBuilder.toString();
    }
}

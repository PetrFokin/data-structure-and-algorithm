

import java.util.ArrayDeque;
import java.util.Queue;

import static java.lang.String.valueOf;

public class BinarySearchTree {
    private Node root = null;
    private int size = 0;
    private int min;

    public void add(Integer value) {
        root = addElement(root, value);
        size++;
    }

    private Node addElement(Node node, Integer value) {
        if (node == null) {
            node = new Node(value);
        } else if (value <= node.value) {
            node.left = addElement(node.left, value);
        } else {
            node.right = addElement(node.right, value);
        }

        return node;
    }

    public boolean contains(Integer value) {
        return contains(root, value);
    }

    public int size() {
        return size;
    }

    public void remove(Integer value) {
        if (root == null)
            return;
        remove(root, value);
    }

    private Node remove(Node node, Integer value) {
        if (node == null)
            return node;
        else if (value < node.value)
            node.left = remove(node.left, value);
        else if (value > node.value)
            node.right = remove(node.right, value);
        else {
            Node left = node.left;
            Node right = node.right;
            if (left == null && right == null)
                node = null;
            else if (left == null)
                return node.right;
            else if (right == null)
                return node.left;
            else {
                Node minNode = findMinNode(node.right);
                Integer minValue = minNode.value;
                remove(node, minValue);
                node.value = minValue;
            }
        }
        return node;
    }

    private Node findMinNode(Node node) {
        Node left = node.left;
        if (left != null)
            return findMinNode(left);
        else
            return node;
    }

    private boolean contains(Node node, Integer value) {
        if (node == null)
            return false;
        else if (node.value.equals(value))
            return true;
        else if (value <= node.value)
            return contains(node.left, value);
        else
            return contains(node.right, value);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        traversTree(root, stringBuilder);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void traversTree(Node node, StringBuilder stringBuilder) {
        if (node != null) {
            stringBuilder.append(node.value).append(", ");
            traversTree(node.left, stringBuilder);
            traversTree(node.right, stringBuilder);
        }
    }

    public static class Node {
        private Integer value;
        private Node left = null;
        private Node right = null;

        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return valueOf(value);
        }
    }
}

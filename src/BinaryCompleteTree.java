import java.util.ArrayDeque;
import java.util.Queue;

import static java.lang.String.valueOf;

public class BinaryCompleteTree<V> {

    private Node<V> root;
    private int size = 0;

    public void addValue(V value) {
        if (root == null) {
            root = new Node<>(value);
            size++;
        } else {
            Queue<Node<V>> queue = new ArrayDeque<>();
            queue.offer(root);
            insertValueInEmptyPlace(value, queue);
            size++;
        }
    }

    public boolean remove(V value) {
        if (root == null || value == null)
            return false;
        if (root.value.equals(value)) {
            if (size > 1) {
                replaceWithDeepestNode(root);
                return true;
            } else {
                root = null;
                size--;
                return true;
            }
        } else {
            Queue<Node<V>> queue = new ArrayDeque<>();
            queue.offer(root);
            Node<V> node = findNode(value, queue);
            if (node == null)
                return false;
            replaceWithDeepestNode(node);
            return true;
        }
    }

    /*public V removeWithReBalance(V value) {
        if (root == null || value == null)
            return null;
        if (root.value.equals(value)) {
            V removedValue = root.value;
            if (root.right != null) {
                reBalanceTree(root);
                root = root.left;
                size--;
                return removedValue;
            } else {
                root = root.left;
                size--;
                return removedValue;
            }
        } else {
            Queue<Node<V>> queue = new ArrayDeque<>();
            queue.offer(root);
            Node<V>[] arr = findNodes(value, queue);
            if (arr.length == 0)
                return null;
            Node<V> node = arr[1]; //node with searched value which will be removed
            Node<V> prevNode = arr[0]; //prev Node is needed for reset reference to next left node of removed node
            if (node != null) {
                V removedValue = node.value;
                if (node.right != null) {
                    reBalanceTree(node);
                    prevNode.left = node.left;
                    size--;
                    return removedValue;
                } else {
                    prevNode.left = node.left;
                    size--;
                    return removedValue;
                }
            } else {
                return null;
            }
        }
    }*/

    private void replaceWithDeepestNode(Node<V> node) {
        Queue<Node<V>> queue = new ArrayDeque<>();
        queue.offer(root);
        Node<V>[] arr = findDeepestNode(queue);
        node.value = arr[1].value; //reset by deepest value
        arr[0].left = arr[0].right;
        arr[0].right = null;
        size--;
    }

    /*private void reBalanceTree(Node<V> node) {
        Queue<Node<V>> nodes = new ArrayDeque<>();
        Queue<V> values = new ArrayDeque<>();
        nodes.offer(node.right);
        fillValue(nodes, values);

        while (true) {
            V value = values.poll();
            if (value == null)
                break;
            Queue<Node<V>> queue = new ArrayDeque<>();
            queue.offer(node.left);
            insertValueInEmptyPlace(value, queue);
        }
    }*/

    public int size() {
        return size;
    }

    public boolean contains(V value) {
        if (root == null || value == null)
            return false;
        if (root.equals(value))
            return true;
        Queue<Node<V>> queue = new ArrayDeque<>();
        queue.offer(root);
        return findValue(value, queue);
    }

    private Node<V>[] findDeepestNode(Queue<Node<V>> queue) {
        Node<V> node = queue.poll();
        Node<V>[] arr = new Node[2];
        Node<V> left = node.left;
        if (left.left == null) {
            arr[0] = node;
            arr[1] = left;
            return arr;
        } else {
            queue.offer(left);
        }

        return findDeepestNode(queue);
    }

    private Node<V> findNode(V value, Queue<Node<V>> queue) {
        Node<V> node = queue.poll();
        if (node == null)
            return null;
        Node<V> left = node.left;
        Node<V> right = node.right;
        if (left != null) {
            if (left.value.equals(value)) {
                return left;
            } else {
                queue.offer(left);
            }
        }

        if (right != null) {
            if (right.value.equals(value)) {
                return right;
            } else {
                queue.offer(right);
            }
        }
        return findNode(value, queue);
    }

    private Node<V>[] findNodes(V value, Queue<Node<V>> queue) {
        Node<V> node = queue.poll();
        Node<V> arr[] = new Node[2];
        if (node == null)
            return arr;
        Node<V> left = node.left;
        Node<V> right = node.right;
        if (left != null) {
            if (left.value.equals(value)) {
                arr[0] = node;
                arr[1] = left;
                return arr;
            } else {
                queue.offer(left);
            }
        }

        if (right != null) {
            if (right.value.equals(value)) {
                arr[0] = node;
                arr[1] = right;
                return arr;
            } else {
                queue.offer(right);
            }
        }
        return findNodes(value, queue);
    }

    private boolean findValue(V value, Queue<Node<V>> queue) {
        Node<V> node = queue.poll();
        if (node == null)
            return false;
        Node<V> left = node.left;
        Node<V> right = node.right;
        if (left != null) {
            if (left.value.equals(value)) {
                return true;
            } else {
                queue.offer(left);
            }
        }

        if (right != null) {
            if (right.value.equals(value)) {
                return true;
            } else {
                queue.offer(right);
            }
        }
        return findValue(value, queue);
    }

    private void fillValue(Queue<Node<V>> nodes, Queue<V> values) {
        Node<V> node = nodes.poll();
        if (node == null)
            return;
        values.offer(node.value);
        Node<V> left = node.left;
        Node<V> right = node.right;
        if (left != null)
            nodes.offer(left);
        if (right != null)
            nodes.offer(right);
        fillValue(nodes, values);
    }

    private void insertValueInEmptyPlace(V value, Queue<Node<V>> queue) {
        Node<V> node = queue.poll();
        Node<V> left = node.left;
        Node<V> right = node.right;
        if (left == null) {
            node.left = new Node<>(value);
            return;
        } else {
            queue.offer(left);
        }

        if (right == null) {
            node.right = new Node<>(value);
            return;
        } else {
            queue.offer(right);
        }
        insertValueInEmptyPlace(value, queue);
    }

    public static class Node<V> {
        private V value;
        private Node<V> left;
        private Node<V> right;

        public Node(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return valueOf(value);
        }
    }
}

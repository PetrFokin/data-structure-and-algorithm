package algorithm.algoexpert;


import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree1 = new BinaryTree(1);
        BinaryTree binaryTree2 = new BinaryTree(2);
        BinaryTree binaryTree3 = new BinaryTree(3);
        binaryTree1.left = binaryTree2;
        binaryTree1.right = binaryTree3;
        BinaryTree binaryTree4 = new BinaryTree(4);
        BinaryTree binaryTree5 = new BinaryTree(5);
        binaryTree2.left = binaryTree4;
        binaryTree2.right = binaryTree5;
        BinaryTree binaryTree6 = new BinaryTree(6);
        BinaryTree binaryTree7 = new BinaryTree(7);
        binaryTree3.left = binaryTree6;
        binaryTree3.right = binaryTree7;
        BinaryTree binaryTree8 = new BinaryTree(8);
        BinaryTree binaryTree9 = new BinaryTree(9);
        binaryTree4.left = binaryTree8;
        binaryTree4.right = binaryTree9;

        invertBinaryTree(binaryTree1);
        System.out.println(binaryTree1);
    }

    public static void invertBinaryTree(BinaryTree tree) {
        Queue<BinaryTree> queue = new ArrayDeque<>();
        queue.offer(tree);

        while (!queue.isEmpty()) {
            var node = queue.poll();
            BinaryTree left = node.left;
            BinaryTree right = node.right;
            node.left = right;
            node.right = left;
            if (left != null) {
                queue.offer(left);
            }

            if (right != null) {
                queue.offer(right);
            }
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
            /*StringBuilder stringBuilder = new StringBuilder();
            Queue<BinaryTree> queue = new ArrayDeque<>();
            queue.offer(this);

            while (!queue.isEmpty()) {
                var node = queue.poll();
                BinaryTree left = node.left;
                BinaryTree right = node.right;
                if (left != null) {
                    stringBuilder.append(left.value).append(" ");
                    queue.offer(left);
                }

                if (right != null) {
                    stringBuilder.append(right.value);
                    queue.offer(right);
                }
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();*/
        }
    }

}

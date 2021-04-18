package algorithm.algoexpert;


public class ValidateBST {


    public static void main(String[] args) {
        BST node1 = new BST(10);
        BST node2 = new BST(15);
        BST node3 = new BST(5);
        node1.left = node3;
        node1.right = node2;
        BST node4 = new BST(10);
        node3.right = node4;
        /*BST node1 = new BST(10);
        BST node2 = new BST(10);
        BST node3 = new BST(12);
        node1.left = node2;
        node1.right = node3;
        BST node4 = new BST(11);
        BST node5 = new BST(10);
        node3.left = node4;
        node3.right = node5;
        BST node6 = new BST(25);
        node2.right = node6;*/
        System.out.println(validateBst(node1));
    }

    public static boolean validateBst(BST tree) {
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBst(BST tree, Integer min, Integer max) {
        if (tree.value < min || tree.value >= max) return false;

        if (tree.left != null && !validateBst(tree.left, min, tree.value))
            return false;

        if (tree.right != null && !validateBst(tree.right, tree.value, min))
            return false;
        return true;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

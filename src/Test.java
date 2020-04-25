import queue.linkedlist.Queue;
import stack.linkedlist.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(200);
        binarySearchTree.add(80);
        binarySearchTree.add(400);
        binarySearchTree.add(250);
        binarySearchTree.add(150);
        binarySearchTree.add(300);
        binarySearchTree.add(90);
        binarySearchTree.add(70);
        binarySearchTree.add(60);
        binarySearchTree.add(40);
        binarySearchTree.add(50);
        binarySearchTree.add(55);
        binarySearchTree.add(35);
        binarySearchTree.remove(200);
        binarySearchTree.remove(35);
        System.out.println(binarySearchTree.size());

        /*HashTable<WrongHashCodeTest, String> hashTable = new HashTable<>();
        WrongHashCodeTest wrong1 = new WrongHashCodeTest(1);
        WrongHashCodeTest wrong2 = new WrongHashCodeTest(2);
        WrongHashCodeTest wrong3 = new WrongHashCodeTest(3);
        hashTable.put(wrong1, "1");
        hashTable.put(wrong2, "2");
        hashTable.put(wrong3, "3");
        System.out.println(hashTable.size());
        System.out.println(hashTable.get(new WrongHashCodeTest(2)));
        System.out.println(hashTable.remove(new WrongHashCodeTest(2)));
        System.out.println(hashTable.remove(new WrongHashCodeTest(3)));
        System.out.println(hashTable.remove(new WrongHashCodeTest(1)));
        System.out.println(hashTable.size());

        hashTable.put(null, "69");
        hashTable.put(null, "666");
        System.out.println(hashTable.get(null));*/

        /*BinaryCompleteTree<Integer> tree = new BinaryCompleteTree<>();
        tree.addValue(20);
        tree.addValue(100);
        tree.addValue(3);
        tree.addValue(50);
        tree.addValue(15);
        tree.addValue(250);
        tree.addValue(35);
        tree.addValue(222);
        tree.addValue(69);

        System.out.println(tree.remove(3));
        System.out.println(tree.size());*/

    }
}

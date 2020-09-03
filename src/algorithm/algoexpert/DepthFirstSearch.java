package algorithm.algoexpert;

import java.util.*;

public class DepthFirstSearch {
    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            if (!array.contains(this.name)) {
                array.add(this.name);
                for(Node n : this.children) {
                    n.depthFirstSearch(array);
                }
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return child;
        }
    }

    public static void main(String[] args) {
        Node a = new Node("a");

        Node b = a.addChild("b");
        Node c = a.addChild("c");
        Node d = a.addChild("d");

        b.addChild("e");
        Node f = b.addChild("f");

        f.addChild("i");
        f.addChild("j");

        Node g = d.addChild("g");
        d.addChild("h");

        g.addChild("k");

        System.out.println(a.depthFirstSearch(new ArrayList<>()));
    }
}

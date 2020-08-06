package graph;

import algorithm.search.DepthFirstSearch;
import graph.adjacency_list.Graph;

public class Test {

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(4);
        for (int i = 0; i < 50; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);

        graph.addEdge(3, 1);
        graph.addEdge(2, 2);
        graph.addEdge(17, 3);
        graph.addEdge(19, 12);
        graph.addEdge(10, 0);
        graph.addEdge(11, 13);
        System.out.println(graph);
        System.out.println(DepthFirstSearch.search(graph, 0, 10));
        System.out.println(DepthFirstSearch.search(graph, 0, 58));
    }
}

package algorithm.search;


import graph.adjacency_list.Graph;

import java.util.*;

public class DepthFirstSearch {

    public static <T> boolean search(Graph<T> graph, T root, T value) {
        if (root == value) {
            return true;
        }

        Set<Graph.Vertex<T>> visitedVertices = new HashSet<>();
        Stack<Graph.Vertex<T>> stack = new Stack<>();

        Graph.Vertex<T> searchedVertex = new Graph.Vertex<>(value);
        Graph.Vertex<T> rootVertex = new Graph.Vertex<>(root);

        stack.push(rootVertex);
        while (!stack.empty()) {
            Graph.Vertex<T> vertex = stack.pop();
            if (vertex.equals(searchedVertex)) {
                return true;
            }

            for (Graph.Vertex<T> neighbourVertex : graph.getVertexes(vertex)) {
                if (!visitedVertices.contains(neighbourVertex)) {
                    visitedVertices.add(vertex);
                    stack.push(neighbourVertex);
                }
            }
        }

        return false;
    }
}

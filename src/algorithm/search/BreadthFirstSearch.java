package algorithm.search;

import graph.adjacency_list.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {


    public static <T> boolean search(Graph<T> graph, T root, T value) {
        if (root == value) {
            return true;
        }

        Set<Graph.Vertex<T>> visitedVertices = new HashSet<>();
        Queue<Graph.Vertex<T>> queue = new LinkedList<>();

        Graph.Vertex<T> searchedVertex = new Graph.Vertex<>(value);
        Graph.Vertex<T> rootVertex = new Graph.Vertex<>(root);
        queue.add(rootVertex);
        while (!queue.isEmpty()) {
            Graph.Vertex<T> vertex = queue.poll();

            if (vertex.equals(searchedVertex)) {
                return true;
            }

            for (Graph.Vertex<T> neighbourVertex : graph.getVertexes(vertex)) {
                if (!visitedVertices.contains(neighbourVertex)) {
                    visitedVertices.add(vertex);
                    queue.offer(neighbourVertex);
                }
            }
        }

        return false;
    }
}

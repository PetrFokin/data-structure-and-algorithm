package algorithm.search;

import graph.adjacency_list.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Popular algorithm for searching value in the graph data structure.
 * Idea is use auxiliary data structure QUEUE for travers in graph because neighbours of each not visited vertex
 * is added to queue. This allows to traverse the graph in breadth.
 *
 * Time complexity:
 *  - Worst: V + E - where V - number of vertexes and E - number of edges
 *  Space complexity:
 *  - Worst: O(V) - -//-
 *
 *  When use: Breadth First Search is generally the best approach when the depth of the tree can vary,
 *  and you only need to search part of the tree for a solution.
 *  For example, finding the shortest path from a starting value to a final value is a good place to use BFS.
 */
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

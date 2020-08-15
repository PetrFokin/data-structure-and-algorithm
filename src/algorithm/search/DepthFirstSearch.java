package algorithm.search;


import graph.adjacency_list.Graph;

import java.util.*;

/**
 * Popular algorithm for searching value in the graph data structure.
 * Idea is use auxiliary data structure STACK for travers in graph because neighbours of each not visited vertex
 * is added to stack. This allows to traverse the graph in depth.
 *
 * Time complexity:
 *  - Worst: V + E - where V - number of vertexes and E - number of edges
 *  Space complexity:
 *  - Worst: O(V) - -//-
 *
 *  When use: when you need to search the entire tree.
 *  It's easier to implement than BFS.
 */

//TODO: add recursive approach
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

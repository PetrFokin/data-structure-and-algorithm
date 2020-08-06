package graph.adjacency_matrix;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Graph {

    private final int [][] matrix;

    public Graph(int weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Graph weight can not be negative");
        }
        this.matrix = new int[weight][weight];
    }


    public void addEdge(int vertexA, int vertexB) {
        if (vertexA < 0 || vertexB < 0 || vertexA >= matrix.length || vertexB >= matrix.length) {
            throw new IllegalArgumentException("Incorrect vertexes");
        }
        matrix[vertexA][vertexB] = 1;
        matrix[vertexB][vertexA] = 1;
    }

    public void removeEdge(int vertexA, int vertexB) {
        if (vertexA < 0 || vertexB < 0 || vertexA >= matrix.length || vertexB >= matrix.length) {
            throw new IllegalArgumentException("Incorrect vertexes");
        }
        matrix[vertexA][vertexB] = 0;
        matrix[vertexB][vertexA] = 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int[] arr : matrix) {
            for (int i : arr) {
                builder.append(i).append(" ");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}

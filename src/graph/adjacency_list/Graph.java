package graph.adjacency_list;

import queue.linkedlist.Queue;

import java.util.*;

public class Graph<T> {

    private final Map<Vertex<T>, List<Vertex<T>>> adjVertices;

    public Graph(int weight) {
        adjVertices = new HashMap<>(weight);
    }

    public void addVertex(T value) {
        adjVertices.putIfAbsent(new Vertex<>(value), new ArrayList<>());
    }

    public void removeVertex(T value) {
        Vertex<T> vertex = new Vertex<>(value);
        List<Vertex<T>> list = adjVertices.get(vertex);
        list.forEach(it -> adjVertices.get(it).remove(vertex));
        adjVertices.remove(vertex);
    }

    public void addEdge(T value1, T value2) {
        Vertex<T> vertex1 = new Vertex<>(value1);
        Vertex<T> vertex2 = new Vertex<>(value2);
        List<Vertex<T>> list1 = adjVertices.get(vertex1);
        List<Vertex<T>> list2 = adjVertices.get(vertex2);

        if (list1 != null && list2 != null) {
            list1.add(vertex2);
            list2.add(vertex1);
        }
    }

    public void removeEdge(T value1, T value2) {
        Vertex<T> vertex1 = new Vertex<>(value1);
        Vertex<T> vertex2 = new Vertex<>(value2);
        List<Vertex<T>> list1 = adjVertices.get(vertex1);
        List<Vertex<T>> list2 = adjVertices.get(vertex2);

        if (list1 != null && list2 != null) {
            list1.remove(vertex2);
            list2.remove(vertex1);
        }
    }

    public List<Vertex<T>> getVertexes(T value) {
        return adjVertices.get(new Vertex<>(value));
    }

    public List<Vertex<T>> getVertexes(Vertex<T> vertex) {
        return adjVertices.get(vertex);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Vertex<T>, List<Vertex<T>>> arr : adjVertices.entrySet()) {
            builder.append("Vertex: ").append(arr.getKey()).append("; Edges: ");
            for (Vertex<T> i : arr.getValue()) {
                builder.append(i).append(" ");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    public static class Vertex<T> {

        private final T value;

        public Vertex(T value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex<?> vertex = (Vertex<?>) o;
            return value.equals(vertex.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}

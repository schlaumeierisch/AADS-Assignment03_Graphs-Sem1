package at.fhv.mme.graphs.elements;

import java.util.LinkedList;

public class Node {
    private final String name;
    private final int index;
    private final LinkedList<Edge> edges;

    public Node(String name, int index) {
        this.name = name;
        this.index = index;
        this.edges = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }
}

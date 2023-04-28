package at.fhv.mme.graphs.elements;

import java.util.LinkedList;

public class Node {
    private String name;
    private LinkedList<Edge> edges;

    public Node(String name, LinkedList<Edge> edges) {
        this.name = name;
        this.edges = edges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Edge> edges) {
        this.edges = edges;
    }
}

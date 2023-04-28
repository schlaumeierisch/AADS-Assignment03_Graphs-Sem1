package at.fhv.mme.graphs.elements;

public class Edge {
    private Node[][] nodes;
    private int weight;

    public Edge(Node[][] nodes, int weight) {
        this.nodes = nodes;
        this.weight = weight;
    }

    public Node[][] getNodes() {
        return nodes;
    }

    public void setNodes(Node[][] nodes) {
        this.nodes = nodes;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
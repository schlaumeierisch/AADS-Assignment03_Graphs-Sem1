package at.fhv.mme.graphs;

public class Graph {
    private final AdjacencyStructure adjStructure;

    private Graph(AdjacencyStructure adjStructure) {
        this.adjStructure = adjStructure;
    }

    public AdjacencyStructure load(String fileName, String struct) {
        // placeholder
        return new AdjacencyMatrix();
    }
}
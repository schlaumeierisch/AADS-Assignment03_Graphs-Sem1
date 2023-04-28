package at.fhv.mme.graphs.structures;

import at.fhv.mme.graphs.elements.Node;

import java.util.LinkedList;

public interface AdjacencyStructure {
    void addNode(String node);
    void addEdge(String firstNode, String secondNode, int weight);
    LinkedList<Node> getNeighbours(Node node);
}
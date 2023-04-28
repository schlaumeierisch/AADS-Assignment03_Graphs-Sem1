package at.fhv.mme.graphs.structures;

import at.fhv.mme.graphs.elements.Node;
import at.fhv.mme.graphs.exceptions.NodeNotFoundException;

import java.util.LinkedList;

public interface AdjacencyStructure {
    void addNode(String nodeName);
    void addEdge(String firstNodeName, String secondNodeName, int weight) throws NodeNotFoundException;
    LinkedList<Node> getNeighbours(Node node);
}
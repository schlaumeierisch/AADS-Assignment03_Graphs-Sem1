package at.fhv.mme.graphs.structures;

import at.fhv.mme.graphs.elements.Edge;
import at.fhv.mme.graphs.elements.Node;
import at.fhv.mme.graphs.exceptions.NodeNotFoundException;

import java.util.HashMap;
import java.util.LinkedList;

public class AdjacencyMatrix implements AdjacencyStructure {
    private final HashMap<String, Node> nodes;
    private int[][] adjMatrix;
    private int nodeCount;

    public AdjacencyMatrix() {
        this.nodes = new HashMap<>();
        this.adjMatrix = new int[0][0];
        this.nodeCount = 0;
    }

    @Override
    public void addNode(String nodeName) {
        if (!nodes.containsKey(nodeName)) {
            Node node = new Node(nodeName, nodeCount);
            this.nodes.put(nodeName, node);

            // increase node count and create new matrix since we added a new node
            int newNodeCount = nodeCount + 1;
            int[][] newAdjMatrix = new int[newNodeCount][newNodeCount];

            // copy existing data to new matrix
            for (int i = 0; i < nodeCount; i++) {
                System.arraycopy(adjMatrix[i], 0, newAdjMatrix[i], 0, nodeCount);
            }

            adjMatrix = newAdjMatrix;
            nodeCount = newNodeCount;
        }
    }

    @Override
    public void addEdge(String firstNodeName, String secondNodeName, int weight) throws NodeNotFoundException {
        Node firstNode = nodes.get(firstNodeName);
        Node secondNode = nodes.get(secondNodeName);

        // check if nodes exist
        if (firstNode == null) {
            throw new NodeNotFoundException("Node with name '" + firstNodeName + "' not found.");
        }

        if (secondNode == null) {
            throw new NodeNotFoundException("Node with name '" + secondNodeName + "' not found.");
        }

        adjMatrix[firstNode.getIndex()][secondNode.getIndex()] = weight;
        adjMatrix[secondNode.getIndex()][firstNode.getIndex()] = weight;

        // add edges to first and second node
        Edge edge = new Edge(firstNode, secondNode, weight);
        firstNode.addEdge(edge);
        secondNode.addEdge(edge);
    }

    @Override
    public LinkedList<Node> getNeighbours(Node node) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // calculate the maximum length of node names
        int maxNameLength = nodes.values().stream()
                .mapToInt(node -> node.getName().length())
                .max()
                .orElse(4);

        // print header with node names
        sb.append(" ".repeat(maxNameLength + 1));
        for (Node node : nodes.values()) {
            sb.append(String.format("%" + (maxNameLength + 1) + "s", node.getName()));
        }
        sb.append("\n");

        // print matrix with row labels (node names)
        for (Node rowNode : nodes.values()) {
            sb.append(String.format("%-" + (maxNameLength + 1) + "s", rowNode.getName()));
            for (Node colNode : nodes.values()) {
                int weight = adjMatrix[rowNode.getIndex()][colNode.getIndex()];
                sb.append(String.format("%" + (maxNameLength + 1) + "d", weight));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
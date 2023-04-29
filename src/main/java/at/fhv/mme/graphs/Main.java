package at.fhv.mme.graphs;

import at.fhv.mme.graphs.elements.Node;
import at.fhv.mme.graphs.exceptions.EmptyFileException;
import at.fhv.mme.graphs.exceptions.InvalidFileFormatException;
import at.fhv.mme.graphs.exceptions.NodeNotFoundException;

import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        try {
            Graph graph = Graph.load("files/example1.txt", GraphType.ADJACENCY_MATRIX);

            // print structure
            graph.print();

            // print neighbours
            LinkedList<Node> neighbours = graph.getNeighbours("B");
            for (Node neighbour : neighbours) {
                System.out.println(neighbour.getName());
            }
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getMessage());
        } catch (EmptyFileException | InvalidFileFormatException | NodeNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
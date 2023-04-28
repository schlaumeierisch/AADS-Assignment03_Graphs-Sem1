package at.fhv.mme.graphs;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Graph {
    private AdjacencyStructure adjacencyStructure;

    public AdjacencyStructure create(String fileName, String struct) {
        ArrayList<String> vertices = new ArrayList<>();
        ArrayList<String[]> edges = new ArrayList<>();
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("V =")) {
                    Pattern vertexPattern = Pattern.compile("V\\d+");
                    Matcher vertexMatcher = vertexPattern.matcher(line);
                    while (vertexMatcher.find()) {
                        vertices.add(vertexMatcher.group());
                    }
                } else if (line.startsWith("E =")) {
                    Pattern edgePattern = Pattern.compile("\\((V\\d+), (V\\d+), (\\d+)\\)");
                    Matcher edgeMatcher = edgePattern.matcher(line);
                    while (edgeMatcher.find()) {
                        String[] edge = new String[3];
                        edge[0] = edgeMatcher.group(1); // start vertex
                        edge[1] = edgeMatcher.group(2); // end vertex
                        edge[2] = edgeMatcher.group(3); // weight
                        edges.add(edge);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new AdjacencyMatrix();
    }
}
package local.nix.module.project.mostProfitableRoute.demo;

import local.nix.module.project.mostProfitableRoute.data.Node;
import local.nix.module.project.mostProfitableRoute.djkstra.GraphHandler;
import local.nix.module.project.mostProfitableRoute.reader.InputFileReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Demo {

    public static void main(String[] args) throws IOException {

        File output = new File("output.txt");
        if (!output.exists()) {
            output.createNewFile();
        }

        InputFileReader.readInputData();
        List<Node> graph = InputFileReader.getGraph();
        Map<String, String> fromTo = InputFileReader.getFromTo();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {

            for(String from: fromTo.keySet()) {
                Node fromNode = GraphHandler.getNodeByName(graph, from);
                String to = fromTo.get(from);
                Node toNode = GraphHandler.getNodeByName(graph, to);
                GraphHandler.computePaths(graph, fromNode);
                bw.write("Distance from " + from + " to " + to + ": " + (int) toNode.minDistance + "\n");

            }

        }

    }



}

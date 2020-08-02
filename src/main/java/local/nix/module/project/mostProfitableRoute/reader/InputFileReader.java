package local.nix.module.project.mostProfitableRoute.reader;

import local.nix.module.project.mostProfitableRoute.data.Edge;
import local.nix.module.project.mostProfitableRoute.data.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputFileReader {

    private static File input = new File("input.txt");
    private static List<Node> graph = new ArrayList<>();
    private static Map<String, String> fromTo = new HashMap<>();

    public static void readInputData() {
        checkIfFileIsExist();

     //   List<Node> graph = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(input))) {

            String first = br.readLine();
            int numberOfNodes = Integer.parseInt(first);

            for(int i = 1; i < numberOfNodes + 1; i++) {
                    int index = i;
                    String name = br.readLine();
                    String next = br.readLine();
                    int numberOfAdjacencies = Integer.parseInt(next);

                    List<Edge> list = new ArrayList<>();

                    for(int j = 0; j < numberOfAdjacencies; j++) {
                        String current = br.readLine();
                        String[] values = current.split(" ");
                        int currentIndex = Integer.parseInt(values[0]);
                        int currentWeight = Integer.parseInt(values[1]);
                        list.add(new Edge(currentIndex, currentWeight));
                    }

                    Edge[] edges = new Edge[list.size()];

                    for(int k = 0; k < edges.length; k++) {
                        edges[k] = list.get(k);
                    }

                    Node temp = new Node(name, index);
                    temp.setAdjacencies(edges);

                    graph.add(temp);

            }

            String paths = br.readLine();
            int numberOfPaths = Integer.parseInt(paths);


            //  Map<String, String> fromTo = new HashMap<>();
            for(int x = 0; x < numberOfPaths; x++) {
                String current = br.readLine();
                String[] values = current.split(" ");
                String from = values[0];
                String to = values[1];
                fromTo.put(from, to);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

      //  return graph;
    }

    public static void checkIfFileIsExist() {
        if(!input.exists()) {
            throw new IllegalArgumentException("файл input.txt отсутствует");
        }
    }

    public static List<Node> getGraph() {
        return graph;
    }

    public static Map<String, String> getFromTo() {
        return fromTo;
    }
}

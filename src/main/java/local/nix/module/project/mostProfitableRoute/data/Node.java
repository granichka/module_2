package local.nix.module.project.mostProfitableRoute.data;

public class Node implements Comparable<Node> {

    public final String name;
    public final int index;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Node previous;
    public Node(String name, int index) { this.name = name; this.index = index; }
    public String toString() { return name; }

    public Edge[] getAdjacencies() {
        return adjacencies;
    }

    public void setAdjacencies(Edge[] adjacencies) {
        this.adjacencies = adjacencies;
    }

    public int compareTo(Node other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}

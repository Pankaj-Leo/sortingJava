import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight; // Sort by weight
    }
}

class DisjointSet2 {
    private int[] parent, rank;

    public DisjointSet2(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path Compression
        }
        return parent[node];
    }

    public void union(int u, int v) {
        int root1 = find(u);
        int root2 = find(v);

        if (root1 != root2) {
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }
}

public class KruskalMST {
    public static List<Edge> kruskal(int n, List<Edge> edges) {
        // Step 1: Sort edges by weight
        Collections.sort(edges);

        DisjointSet2 ds = new DisjointSet2(n);
        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        // Step 2: Pick edges one by one
        for (Edge edge : edges) {
            if (ds.find(edge.src) != ds.find(edge.dest)) { // If adding edge doesn't create a cycle
                ds.union(edge.src, edge.dest);
                mst.add(edge);
                totalWeight += edge.weight;

                if (mst.size() == n - 1) { // Stop when we have (V - 1) edges
                    break;
                }
            }
        }

        System.out.println("Total Weight of MST: " + totalWeight);
        return mst;
    }

    public static void main(String[] args) {
        int n = 4; // Number of nodes
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        List<Edge> mst = kruskal(n, edges);
        System.out.println("Edges in MST:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }
}
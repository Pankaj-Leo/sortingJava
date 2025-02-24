import java.util.*;

public class DisjointSet {

    private int[] parent;
    private int[] rank;

    // Constructor
    public DisjointSet(int size){
        parent = new int[size];
        rank = new int[size];

        // Initialize each node as its own parent and rank = 1
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

    }

    // Find operation with path compression
    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);  // Path compression
        }
        return parent[node];
    }
public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) {
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;  // Attach smaller tree to larger tree
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }

    // Check if two elements are connected
    public boolean areConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(10); // 10 elements (indexed 0-9)

        // Define relationships (friendship unions)
        int[][] relations = {{0, 1}, {1, 3}, {2, 5}, {2, 8}, {9, 4}, {6, 9}};

        // Apply union operations
        for (int[] relation : relations) {
            ds.union(relation[0], relation[1]);
        }

        // Checking friendships
        System.out.println(ds.areConnected(0, 3)); // True (0 and 3 are connected)
        System.out.println(ds.areConnected(2, 8)); // True (2 and 8 are connected)
        System.out.println(ds.areConnected(4, 6)); // True (4 and 6 are connected)
        System.out.println(ds.areConnected(0, 5)); // False (0 and 5 are not connected)
    }


}

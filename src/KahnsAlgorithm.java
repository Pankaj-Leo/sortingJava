import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class KahnsAlgorithm {
    public static int[] topologicalSort(List<List<Integer>> adj, int V) {
       // Step 1: Compute the in-degree of each vertex
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++; // Increment in-degree
            }
        }
        // Step 2: Initialize a queue to store nodes with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) { // Nodes with no dependencies
                queue.offer(i);
            }
        }

// Step 3: Process nodes in topological order
        int[] result = new int[V]; // Stores the final topological order
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index++] = node; // Add node to result

            // Reduce in-degree for adjacent vertices
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                // If in-degree becomes zero, add it to the queue
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: Cycle detection - If all vertices were not processed, a cycle exists
        if (index != V) {
            System.out.println("Graph contains a cycle! No valid topological order.");
            return new int[0]; // Return an empty array
        }

        return result; // Return topological order
    }

    public static void main(String[] args) {
        // Number of nodes
        int n = 6;

        // Directed edges in the graph
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3},
                {4, 5}, {5, 1}, {5, 2}
        };

        // Step 1: Create an adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Populate the adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]); // Directed edge from edge[0] to edge[1]
        }

        // Step 3: Perform topological sorting
        System.out.println("Topological Sorting of the Graph:");
        int[] result = topologicalSort(adj, n);

        // Step 4: Display the result
        if (result.length > 0) {
            for (int node : result) {
                System.out.print(node + " ");
            }
        }
    }
}
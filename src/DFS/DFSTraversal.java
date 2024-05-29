package DFS;

import java.util.*;

class DFSTraversal {
    private LinkedList<Integer> adj[]; /* adjacency list representation */
    private boolean visited[];

    /* Creation of the graph */
    DFSTraversal(int V) /* 'V' is the number of vertices in the graph */ {
        adj = new LinkedList[V];
        visited = new boolean[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<Integer>();
    }

    /* Adding an edge to the graph */
    void insertEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src); // since the graph is undirected, add the edge both ways
    }

    void DFS(int vertex) {
        visited[vertex] = true; /* Mark the current node as visited */
        System.out.print(vertex + " ");
        Iterator<Integer> it = adj[vertex].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n])
                DFS(n);
        }
    }

    public static void main(String args[]) {
        DFSTraversal graph = new DFSTraversal(6);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 4);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 5);
        graph.insertEdge(2, 3);
        graph.insertEdge(4, 5);
        graph.insertEdge(3, 5);
        System.out.println("Depth First Traversal for the graph is:");
        graph.DFS(3);
    }
}

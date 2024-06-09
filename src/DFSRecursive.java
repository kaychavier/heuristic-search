import java.util.*;

public class DFSRecursive {
    static class Graph {
        private int V; // Número de vértices
        private LinkedList<Integer> adj[]; // Lista de adjacência

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void DFSUtil(int v, boolean visited[]) {
            // Marca o nó atual como visitado e imprime
            visited[v] = true;
            System.out.print(v + " ");

            // Recursivamente visita todos os vértices adjacentes não visitados
            for (int n : adj[v]) {
                if (!visited[n]) {
                    DFSUtil(n, visited);
                }
            }
        }

        void DFS(int v) {
            // Marca todos os vértices como não visitados (padrão é false)
            boolean visited[] = new boolean[V];

            // Chama o método recursivo auxiliar para visitar todos os vértices conectados
            DFSUtil(v, visited);
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Busca em profundidade (DFS) a partir do vértice 2:");

        g.DFS(2);
    }
}

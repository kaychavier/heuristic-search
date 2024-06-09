import java.util.*;

public class BFSRecursive {
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

        void BFSUtil(int v, boolean visited[], Queue<Integer> queue) {
            // Se a fila está vazia, retorna
            if (queue.isEmpty()) return;

            // Remove o vértice da fila e imprime
            int s = queue.poll();
            System.out.print(s + " ");

            // Marca o vértice atual como visitado
            visited[s] = true;

            // Obtém todos os vértices adjacentes do vértice s
            // Se um vértice adjacente não foi visitado, marca-o como visitado e coloca na fila
            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }

            // Chama recursivamente para o próximo vértice na fila
            BFSUtil(v, visited, queue);
        }

        void BFS(int s) {
            // Marca todos os vértices como não visitados (padrão é false)
            boolean visited[] = new boolean[V];

            // Cria uma fila para BFS
            Queue<Integer> queue = new LinkedList<>();

            // Marca o nó atual como visitado e coloca na fila
            visited[s] = true;
            queue.add(s);

            // Chama o método recursivo auxiliar
            BFSUtil(s, visited, queue);
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

        System.out.println("Busca em largura (BFS) a partir do vértice 2:");

        g.BFS(2);
    }
}

import java.util.*;

public class Dijkstra {
    static class Graph {
        private int V; // Número de vértices
        private LinkedList<Edge> adj[]; // Lista de adjacência

        static class Edge {
            int node;
            int weight;

            Edge(int node, int weight) {
                this.node = node;
                this.weight = weight;
            }
        }

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int v, int w, int weight) {
            adj[v].add(new Edge(w, weight));
        }

        void dijkstra(int src) {
            // Array para armazenar as distâncias mínimas dos vértices a partir da origem
            int dist[] = new int[V];

            // Array para verificar se o vértice já foi processado
            boolean sptSet[] = new boolean[V];

            // Inicializa todas as distâncias como infinito e o conjunto de caminhos mais curtos como falso
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(sptSet, false);

            // A distância do nó de origem para ele mesmo é sempre 0
            dist[src] = 0;

            // PriorityQueue para selecionar o vértice com a menor distância
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> dist[o]));
            pq.add(src);

            while (!pq.isEmpty()) {
                // Extrai o vértice com a menor distância
                int u = pq.poll();

                // Marca o vértice como processado
                sptSet[u] = true;

                // Atualiza os valores de distância dos vértices adjacentes
                for (Edge edge : adj[u]) {
                    if (!sptSet[edge.node] && dist[u] != Integer.MAX_VALUE && dist[u] + edge.weight < dist[edge.node]) {
                        dist[edge.node] = dist[u] + edge.weight;
                        pq.add(edge.node);
                    }
                }
            }

            // Imprime o array de distâncias
            printSolution(dist);
        }

        void printSolution(int dist[]) {
            System.out.println("Distâncias a partir da origem:");
            for (int i = 0; i < V; i++) {
                System.out.println("Vértice " + i + " - Distância: " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        System.out.println("Algoritmo de Dijkstra a partir do vértice 0:");
        g.dijkstra(0);
    }
}

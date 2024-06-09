import java.util.*;

public class GreedySearch {
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

        void greedyBestFirstSearch(int start, int goal, int[] heuristic) {
            // PriorityQueue que ordena os vértices com base na função heurística
            PriorityQueue<Integer> openList = new PriorityQueue<>(Comparator.comparingInt(node -> heuristic[node]));
            boolean[] closedList = new boolean[V];

            openList.add(start);

            while (!openList.isEmpty()) {
                int current = openList.poll();

                // Imprime o nó atual
                System.out.print(current + " ");

                // Verifica se alcançamos o objetivo
                if (current == goal) {
                    System.out.println("\nObjetivo alcançado!");
                    return;
                }

                // Marca o nó atual como visitado
                closedList[current] = true;

                // Verifica os nós adjacentes
                for (Edge edge : adj[current]) {
                    if (!closedList[edge.node]) {
                        openList.add(edge.node);
                    }
                }
            }

            System.out.println("\nObjetivo não alcançado.");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 4, 2);
        g.addEdge(3, 5, 3);
        g.addEdge(4, 5, 1);

        // Supondo uma função heurística fictícia
        int[] heuristic = {10, 8, 5, 7, 3, 0};

        System.out.println("Busca Gulosa Best-First a partir do vértice 0 para o vértice 5:");

        g.greedyBestFirstSearch(0, 5, heuristic);
    }
}

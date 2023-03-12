import java.util.Scanner;
import java.util.Arrays;
public class BellmanFord {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        int[][] graph = new int[V][V];
        System.out.println("Enter the weight of edges in the graph: ");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
                if (i == j) {
                    graph[i][j] = 0;
                }
                if (graph[i][j] == 0) {
                    graph[i][j] = INF;
                }
            }
        }
        System.out.print("Enter the source vertex: ");
        int source = sc.nextInt();
        if(source < 0 || source >= V) {
            System.out.println("Invalid source vertex entered");
            return;
        }
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[source] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if(dist[u] != INF && dist[v] > dist[u] + graph[u][v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (dist[u] != INF && dist[v] > dist[u] + graph[u][v]) {
                    System.out.println("Graph contains negative edge cycle!");
                    return;
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.println("Shortest path from source " + source + " to vertex " + i + " is: " + dist[i]);
        }
    }

}
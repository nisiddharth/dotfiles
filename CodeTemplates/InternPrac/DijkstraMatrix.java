import java.util.*;

class DijkstraMatrix {
	static int V;
	int minDistance(int dist[], boolean sptSet[]) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		return min_index;
	}

	int[] dijkstra(int graph[][], int src) {
		int dist[] = new int[V];
		boolean sptSet[] = new boolean[V];
		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;
		for (int count = 0; count < V - 1; count++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			for (int v = 0; v < V; v++)
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}
		return dist;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int e = sc.nextInt();
		int graph[][] = new int[V][V];
		for(int i = 0; i < e; ++i) {
			int from = sc.nextInt(), to = sc.nextInt(), weight = sc.nextInt();
			graph[from][to] = weight;
			// graph[to][from] = weight;
		}
		int src = sc.nextInt();
		DijkstraMatrix t = new DijkstraMatrix();
		int dist[] = t.dijkstra(graph, src);
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}
}

import java.util.*;
class DFSBFS {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		ArrayList<Integer> adj[] = new ArrayList[n];
		for(int i = 0; i < n; ++i)
			adj[i] = new ArrayList<>();
		for(int i = 0; i < m; ++i)
			adj[sc.nextInt()].add(sc.nextInt());
		boolean visited[] = new boolean[n];
		System.out.println("DFS: ");
		dfs(0, adj, visited);
		System.out.println("\nBFS: ");
		bfs(adj, 0, n);
		System.out.println("\nIterative DFS: ");
		dfsIterative(adj, 0, n);
		System.out.println();
	}

	private static void dfs(int src, ArrayList<Integer> adj[], boolean visited[]) {
		visited[src] = true;
		System.out.print(src + ", ");
		for(int node : adj[src])
			if(!visited[node])
				dfs(node, adj, visited);
	}

	private static void bfs(ArrayList<Integer> adj[], int src, int n) {
		boolean visited[] = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);
		while(!queue.isEmpty()) {
			src = queue.poll();
			visited[src] = true;
			System.out.print(src + ", ");
			for(int node : adj[src])
				if(!visited[node])
					queue.offer(node);
		}
	}

	private static void dfsIterative(ArrayList<Integer> adj[], int src, int n) {
		boolean visited[] = new boolean[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(src);
		while(!stack.isEmpty()) {
			src = stack.pop();
			visited[src] = true;
			System.out.print(src + ", ");
			for(int node : adj[src])
				if(!visited[node])
					stack.push(node);
		}
	}
}

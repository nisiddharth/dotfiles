class TopologicalSort {
	public int[] findOrder(int n, int[][] prereq) {
		ArrayList<Integer> adj[] = new ArrayList[n];
		boolean visited[] = new boolean[n], recStack[] = new boolean[n];
		for(int i = 0; i < n; ++i)
			adj[i] = new ArrayList<>();
		int len = prereq.length;
		for(int i = 0; i < len; ++i)
			adj[prereq[i][1]].add(prereq[i][0]);
		for(int i = 0; i < n; ++i)
			if(isCyclic(adj, i, visited, recStack))
				return new int[0];
		Arrays.fill(visited, false);
		Stack<Integer> postorder = new Stack<>();
		for(int i = 0; i < n; ++i)
			if(!visited[i])
				dfs(adj, i, visited, postorder);
		int ans[] = new int[postorder.size()];
		int ind = 0;
		while(!postorder.isEmpty())
			ans[ind++] = postorder.pop();
		return ans;
	}

	private void dfs(ArrayList<Integer> adj[], int src, boolean visited[], Stack<Integer> postorder) {
		visited[src] = true;
		for(int a : adj[src])
			if(!visited[a])
				dfs(adj, a, visited, postorder);
		postorder.add(src);
	}

	private boolean isCyclic(ArrayList<Integer> adj[], int src, boolean visited[], boolean recStack[]) {
		if(recStack[src])
			return true;
		if(visited[src])
			return false;
		visited[src] = true;
		recStack[src] = true;
		for(int a : adj[src])
			if(isCyclic(adj, a, visited, recStack))
				return true;
		recStack[src] = false;
		return false;
	}
}

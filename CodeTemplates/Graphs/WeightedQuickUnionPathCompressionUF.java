class UnionFind {
	int[] parents;
	int count;
	UnionFind(int n) {
		parents = new int[n];
		for(int i = 0; i < n; ++i)
			parents[i] = i;
		count = n;
	}

	int find(int i) {
		if(parents[i] == i)
			return i;
		return parents[i] = find(parents[i]);
	}

	void union(int i, int j) {
		int a = find(i);
		int b = find(j);
		if(a != b) {
			parents[a] = b;
			--count;
		}
	}
}

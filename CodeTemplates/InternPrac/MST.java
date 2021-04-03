import java.util.*;

public class MST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Edge> edges = new ArrayList<>();
		int nVert = sc.nextInt(), nEdges = sc.nextInt();
		for (int i = 0; i < nEdges; ++i)
			edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));

		KruskalMST mst = new KruskalMST(edges, nVert);
		for (Edge e : mst.edges())
			System.out.println(e.v + " " + e.w + " = " + e.weight);
		sc.close();
	}
}

class KruskalMST {
	private ArrayList<Edge> mst;

	public KruskalMST(ArrayList<Edge> edges, int nVert) {
		mst = new ArrayList<>();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (Edge e : edges)
			pq.offer(e);

		UnionFind uf = new UnionFind(nVert);

		while (!pq.isEmpty() && mst.size() < nVert - 1) {
			Edge e = pq.poll();
			if (uf.find(e.v) != uf.find(e.w)) {
				uf.union(e.v, e.w);
				mst.add(e);
			}
		}
	}

	public ArrayList<Edge> edges() {
		return mst;
	}
}

class Edge implements Comparable<Edge> {
	int v, w, weight;

	public Edge(int v, int w, int weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int compareTo(Edge that) {
		return Integer.compare(this.weight, that.weight);
	}
}

class UnionFind {
	int parents[], count;

	public UnionFind(int n) {
		parents = new int[n];
		for (int i = 0; i < n; ++i)
			parents[i] = i;
		count = n;
	}

	public int find(int i) {
		if (parents[i] == i)
			return i;
		return parents[i] = find(parents[i]);
	}

	public void union(int i, int j) {
		int a = find(i), b = find(j);
		if (a != b) {
			parents[a] = b;
			--count;
		}
	}
}

import java.io.*;
import java.util.*;

public class LCA_N_ARY {
	int n, a, b;
	ArrayList<Integer> list[];
	long ans = 0;
	int depth[];
	long suma[], sumb[];

	private void solve() throws Exception {
		n = nextInt();
		a = nextInt();
		b = nextInt();
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			int p = nextInt();
			list[p].add(i);
			list[i].add(p);
		}
		init();
		suma = new long[n + 1];
		sumb = new long[n + 1];
		depth = new int[n + 1];
		ans = 0;
		dfs(1, 0);
		out.printf("%8f\n", 1.0d * ans / (1l * n * n));
	}

	void dfs(int v, int p) {
		depth[v] = depth[p] + 1;
		ans += 1l * n * ((depth[v] + a - 1) / a);
		ans += 1l * n * ((depth[v] + b - 1) / b);
		suma[v]++;
		sumb[v]++;
		for (int vv : list[v])
			if (vv != p)
				dfs(vv, v);
		ans -= 1l * suma[v] * sumb[v];
		int x = ancestor(v, a);
		int y = ancestor(v, b);
		if (x >= 1 && x <= n)
			suma[x] += suma[v];
		if (y >= 1 && y <= n)
			sumb[y] += sumb[v];
	}

	final int logn = 25;
	int ancestor[][];

	void init() {
		depth = new int[n + 1];
		depth[0] = -1;
		ancestor = new int[n + 1][logn + 1];
		dfs1(1, 0);
		for (int j = 1; j <= logn; j++)
			for (int i = 1; i <= n; i++)
				ancestor[i][j] = ancestor[ancestor[i][j - 1]][j - 1];
	}

	void dfs1(int v, int p) {
		depth[v] = depth[p] + 1;
		ancestor[v][0] = p;
		for (int vv : list[v])
			if (vv != p)
				dfs1(vv, v);
	}

	// ancestor(i,j) is the jth ancestor of i
	int ancestor(int i, int j) {
		for (int k = logn; k >= 0; k--)
			if (((j >> k) & 1) == 1)
				i = ancestor[i][k];
		return i;
	}

	///////////////////////////////////////////////////////////

	public void run() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = null;
		out = new PrintWriter(System.out);

		int t = nextInt();
		for (int i = 1; i <= t; i++) {
			out.print("Case #" + i + ": ");
			solve();
		}

		br.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new Solution().run();
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;

	String nextToken() throws Exception {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	String nextLine() throws Exception {
		return br.readLine();
	}

	int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws Exception {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws Exception {
		return Double.parseDouble(nextToken());
	}
}

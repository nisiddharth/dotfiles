import java.io.*;
import java.util.*;

public class RAAM {
	static void solve() throws IOException {

	}

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// sieve();
		int tt = 1;
		tt = nextInt();
		for (int test = 1; test <= tt; ++test) {
			// out.print("Case #");
			// out.print(test);
			// out.print(": ");
			solve();
		}
		out.close();
	}

	static class Pair implements Comparable<Pair> {
		long first, second;

		Pair(long a, long b) {
			first = a;
			second = b;
		}

		public int compareTo(Pair p) {
			return (int) (this.first - p.first);
		}

		public boolean equals(Object p) {
			Pair p1 = (Pair) p;
			return (first == p1.first && second == p1.second);
		}

		public String toString() {
			return this.first + " " + this.second;
		}

		public int hashCode() {
			return (int) ((1l * (inf + 1) * this.first + this.second) % mod);
		}
	}

	static boolean arraySortedOrNot(int a[], int n) {
		if (n == 1 || n == 0)
			return true;
		if (a[n - 1] < a[n - 2])
			return false;
		return arraySortedOrNot(a, n - 1);
	}

	static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static long binaryExpo(long a, long b) {
		if (a == 1)
			return 1;
		long res = 1;
		a = a % mod;
		while (b != 0) {
			if ((b & 1) != 0) {
				res = (res % mod * a % mod) % mod;
			}
			a = (a % mod * a % mod) % mod;
			b >>= 1;
		}
		return res;
	}

	static boolean isPerfectSquare(long x) {
		double sr = Math.sqrt(x);
		return ((sr - Math.floor(sr)) == 0);
	}

	static long isPowerOfTwo(long n) {
		if (n == 0)
			return -1;
		long count = 0;

		while (n != 1) {
			++count;
			if (n % 2 != 0)
				return -1;
			n = n / 2;
		}
		return count;
	}

	static final long mod = (long) (1e9 + 7);
	static final int inf = (int) (1e9 + 1);

	public static int lowerBound(int[] array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value <= array[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public static int upperBound(int[] array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value >= array[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter out;

	static String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}

	static long nextLong() {
		return Long.parseLong(next());
	}

	static double nextDouble() {
		return Double.parseDouble(next());
	}

	static String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	static int[] nextIntArray(int n) {
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		return a;
	}

	static long[] nextLongArray(int n) {
		long a[] = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextLong();
		}
		return a;
	}

	static int[] memset(int n, int val) {
		int ar[] = new int[n];
		Arrays.fill(ar, val);
		return ar;
	}

	static void debug(Object... a) {
		System.out.print("> ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	static void debug(int a[]) {
		debugnsp(Arrays.stream(a).boxed().toArray());
	}

	static void debug(long a[]) {
		debugnsp(Arrays.stream(a).boxed().toArray());
	}

	static void debugnsp(Object a[]) {
		System.out.print("> ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	static class UnionFind {
		int[] parents;
		int count;

		UnionFind(int n) {
			parents = new int[n];
			for (int i = 0; i < n; ++i)
				parents[i] = i;
			count = n;
		}

		int find(int i) {
			if (parents[i] == i)
				return i;
			return parents[i] = find(parents[i]);
		}

		void union(int i, int j) {
			int a = find(i);
			int b = find(j);
			if (a != b) {
				parents[a] = b;
				--count;
			}
		}
	}

	// static final int MAXN = 100001;
	// static int spf[] = new int[MAXN];

	// static void sieve() {
	// spf[1] = 1;
	// for (int i = 2; i < MAXN; i++)
	// spf[i] = i;
	// for (int i = 4; i < MAXN; i += 2)
	// spf[i] = 2;

	// for (int i = 3; i * i < MAXN; i++) {
	// if (spf[i] == i) {
	// for (int j = i * i; j < MAXN; j += i)
	// if (spf[j] == j)
	// spf[j] = i;
	// }
	// }
	// }
}

/*
 * Jai Sita Ram Ji
 *
 * @author: Nishchal Siddharth Pandey
 */

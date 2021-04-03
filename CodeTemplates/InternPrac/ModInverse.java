import java.util.Scanner;

class ModInverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(modInverse(sc.nextInt(), sc.nextInt()));
	}

	private static int modInverse(int a, int MOD) {
		int m = MOD, x = 1, y = 0;
		if(MOD == 1)
			return 0;
		while(a > 1) {
			int q = a / m;
			int t = m;
			m = a % m;
			a = t;
			t = y;
			y = x - q * y;
			x = t;
		}
		if(x < 0)
			x += MOD;
		return x;
	}
}

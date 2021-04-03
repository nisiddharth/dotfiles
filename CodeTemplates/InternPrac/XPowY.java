import java.util.Scanner;

class XPowY {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(power(sc.nextInt(), sc.nextInt()));
		System.out.println(modPower(sc.nextInt(), sc.nextInt(), sc.nextInt()));
	}

	private static int power(int x, int y) {
		int res = 1;
		while(y > 0) {
			if((y & 1) != 0)
				res *= x;
			y >>= 1;
			x *= x;
		}
		return res;
	}

	private static int modPower(int x, int y, int MOD) {
		int res = 1;
		x %= MOD;
		if(x == 0)
			return 0;
		while(y > 0) {
			if((y & 1) != 0)
				res = (res * x) % MOD;
			y >>= 1;
			x = (x * x) % MOD;
		}
		return res;
	}
}

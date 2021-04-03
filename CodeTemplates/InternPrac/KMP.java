class KMP {
	static int KMPSearch(String txt, String pat) {
		int m = pat.length(), n = txt.length(), i = 0, j = 0, lps[] = computeLPS(pat);
		while(i < n) {
			if(txt.charAt(i) == pat.charAt(j)) {
				++i;
				++j;
			}
			if(j == m) {
				return i - m;
			} else if(i < n && txt.charAt(i) != pat.charAt(j)) {
				if(j != 0)
					j = lps[j - 1];
				else
					++i;
			}
		}
		return -1;
	}

	static int[] computeLPS(String pat) {
		int n = pat.length(), lps[] = new int[n], len = 0, i = 1;
		while(i < n)
			if(pat.charAt(i) == pat.charAt(len))
				lps[i++] = ++len;
			else if(len != 0)
				len = lps[len - 1];
			else
				++i;
		return lps;
	}

	public static void main(String args[]) {
		System.out.println(KMPSearch("My name is Nishchal Siddharth Pandey", "shchal S"));
	}
}

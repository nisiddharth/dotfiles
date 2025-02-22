class KMP {
	static void KMPSearch(String pat, String txt) {
		int M = pat.length(), N = txt.length(), i = 0, j = 0, lps[] = new int[M];
		computeLPSArray(pat, M, lps);
		while (i < N) {
			if (pat.charAt(j) == txt.charAt(i)) {
				++j;
				++i;
			}
			if (j == M) {
				System.out.println("Found pattern "
				                   + "at index " + (i - j));
				j = lps[j - 1];
			} else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
	}

	static void computeLPSArray(String pat, int M, int lps[]) {
		int len = 0, i = 1;
		lps[0] = 0;
		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = len;
					i++;
				}
			}
		}
	}

	public static void main(String args[]) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		KMPSearch(pat, txt);
	}
}

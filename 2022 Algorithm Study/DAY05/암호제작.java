package P1837;

import java.io.*;
import java.util.*;

public class Main {
	static int MAX = 100000;
	static int K;
	static char[] P;
	static boolean[] isNotPrime;
	static List<Integer> primes = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		P = st.nextToken().toCharArray();
		K = Integer.parseInt(st.nextToken());

		isNotPrime = new boolean[MAX + 1];
		for (int i = 2; i < MAX + 1; i++) {
			if (!isNotPrime[i]) {
				primes.add(i);
				for (int j = i * 2; j < MAX + 1; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
		for (int prime : primes) {
			if (prime >= K) {
				break;
			}
			if (checkIsBad(prime)) {
				System.out.println("BAD " + prime);
				return;
			}
		}
		System.out.println("GOOD");
	}

	static boolean checkIsBad(int x) {
		int r = 0;
		for (int i = 0; i < P.length; i++) {
			// char를 숫자로 바로 바꾸는 방법( - '0')
			r = (r * 10 + (P[i] - '0')) % x;
		}
		if (r == 0) {
			return true;
		} else {
			return false;
		}
	}
}

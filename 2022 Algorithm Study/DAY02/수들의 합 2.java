package P2003;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int N = Integer.parseInt(st.nextToken()); // 수열의 갯수
		int M = Integer.parseInt(st.nextToken()); // 수열의 합 크기

		int[] arr = new int[N];
		String str2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(str2);
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken()); // 1 1 1 1
		}

		int low = 0;
		int high = 0;
		int sum = 0;
		int cnt = 0;

		while (true) {
			if (sum >= M) {
				sum -= arr[low++];
			} else if (high == N)
				break;
			else {
				sum += arr[high++];
			}
			if (sum == M) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}

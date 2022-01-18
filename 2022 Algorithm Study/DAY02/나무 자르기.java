package P2805;

import java.io.*;
import java.util.*;

public class Main {
	static long T;
	static int N, M;
	static long[] inputA, inputB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 나무의 수
		M = Integer.parseInt(st.nextToken()); // 나무의 길이

		int[] tree = new int[N];
		st = new StringTokenizer(br.readLine());

		int min = 0, max = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());

			if (max < tree[i]) { // 나무길이의 최대값
				max = tree[i];
			}
		}

		while (min < max) {
			// 자르는위치 -> mid
			int mid = (min + max) / 2;
			long sum = 0; // 자른 나무 길이의 합

			for (int i=0; i<tree.length; i++) {
				// 자르는 위치가 나무의 높이 보다 클 수 있기 때문에
				if (tree[i] - mid > 0) {
					sum += (tree[i] - mid);
				}
			}

			// 자르는 위치가 높다 -> 낮쳐줘야함
			if (sum < M) {
				max = mid;
			}
			// 자르는 위치가 낮다 -> 높여줘야함
			else {
				min = mid + 1;
			}
		}

		System.out.println(min - 1);
	}
}

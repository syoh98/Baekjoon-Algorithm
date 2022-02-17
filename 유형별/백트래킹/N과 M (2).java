package Test;

import java.io.*;
import java.util.*;

/*
 * 1 2가 나올 경우 2 1은 나오면 안됨
 * */
public class Main {
	static int N, M;
	static int[] list;
	static boolean[] visited;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 숫자개수
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1]; // 숫자의 사용여부
		list = new int[M + 1]; // 수열의 개수를 count

		backTracking(0);
		System.out.println(sb);
	}

	static void backTracking(int index) {
		// 1. 목적지인가?
		if (index == M) {
			for (int i = 0; i < M; i++) {
				sb.append(list[i] + " ");
			}
			sb.append("\n");
			return;
		}

		// 2. 연결된 곳을 순회
		for (int i = 1; i <= N; i++) {
			// 3. 갈 수 있는가?
			if (!visited[i]) { // 사용하지 않은 숫자인가?
				// 4. 간다
				visited[i] = true;
				list[index] = i;

				backTracking(index + 1); // 다음 수열

				for (int j = i + 1; j <= N; j++) {
					visited[j] = false;
				}
			}
		}

	}
}

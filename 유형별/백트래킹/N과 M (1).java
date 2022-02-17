package Test;

import java.io.*;
import java.util.*;

/*
 * 수열은 사전 순으로 증가하는 순서로 출력
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

				backTracking(index + 1);
				// ** 위에서 return 후 false로 바꾸어줌  
				visited[i] = false; // 재귀호출이 끝나면 다시 false로 변경
			}
		}

	}
}

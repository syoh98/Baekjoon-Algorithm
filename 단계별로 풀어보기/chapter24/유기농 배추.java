package Test;

import java.io.*;
import java.util.*;

public class Main {
	static int T, M, N, K;
	static int[][] Map;

	static StringBuilder sb;
	static StringTokenizer st;

	static int count = 0; // 배추흰지렁이 수
	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited; // 방문 체크

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int k = 0; k < T; k++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로길이
			N = Integer.parseInt(st.nextToken()); // 세로길이
			K = Integer.parseInt(st.nextToken()); // 배추가 심어져있는 위치의 개수

			Map = new int[M][N];
			visited = new boolean[M][N];

			// MAP 생성(입력받은 위치에 1을 넣는다)
			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				Map[a][b] = 1;
			}
			count = 0;
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (Map[i][j] == 1 && !visited[i][j]) { // 1의 값이면서 방문을 하지 않은 배열일 때
						dfs(i, j);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;

		// 상하좌우 탐색
		for (int i = 0; i < 4; i++) {
			int dx = r + dr[i];
			int dy = c + dc[i];

			// 1. 범위에 벗어나지 않고
			if (dx >= 0 && dy >= 0 && dx < M && dy < N) {
				// 2. map의 값이 1이면서 방문하지 않은 곳이라면 cnt++한다
				if (Map[dx][dy] == 1 && !visited[dx][dy]) {
					dfs(dx, dy);
				}
			}
		}
	}
	
}

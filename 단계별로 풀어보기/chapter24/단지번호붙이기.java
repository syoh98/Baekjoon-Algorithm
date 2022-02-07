package Test;

import java.io.*;
import java.util.*;

/* [조건]
 * 1: 집이 있는 곳, 0: 집이 없는 곳
 * 연결된 집: 좌우/상하 로 다른 집이 있는 경우(대각선은 제외)
 * */

public class Main {
	static int N; // 지도의 크기
	static int[][] map; // 입력을 기록
	static boolean[][] visited; // 방문체크

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static ArrayList<Integer> list; // 단지수 넣을 배열
	static int cnt = 0; // 단지 수

	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		list = new ArrayList<Integer>();

		N = Integer.parseInt(br.readLine()); // 지도의 크기를 입력받음

		map = new int[N][N];
		visited = new boolean[N][N];

		// 단지의 정보를 입력받아서 map에 넣음
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.substring(j, j + 1));
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) { // 1의 값이면서 방문을 하지 않은 배열일 때
					cnt = 1;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size()); // 총 단지수 출력

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static int dfs(int r, int c) {
		visited[r][c] = true;

		// 상하좌우 탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 1. 범위 밖이 아니라면(map을 벗어나지 않았다면)
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				// 2. 연결되어 있는 곳 && 방문하지 않은 곳이었다면
				if (map[nr][nc] == 1 && !visited[nr][nc]) {
					dfs(nr, nc);
					cnt++;
				}
			}
		}
		return cnt;
	}
}

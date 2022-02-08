package Test;

import java.io.*;
import java.util.*;

/* 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
 * (1, 1) -> (N, M)의 위치로 이동할 때 지나야하는 최소의 칸 수
 * 한칸에서 다른 칸으로 이동할 때 서로 인접한 칸으로만
 * 칸을 셀 때에는 시작 위치와 도착 위치도 포함
 * */

public class Main {
	static int N, M;
	static int[][] Map;
	static boolean[][] visited;
	static int count = 0;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Map = new int[N][M];
		visited = new boolean[N][M];
		visited[0][0] = true;

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(temp.substring(j, j + 1));
			}
		}

		bfs(0, 0);
		System.out.println(Map[N - 1][M - 1]);
	}

	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dr[i];
				int dy = p.y + dc[i];

				if (dx >= 0 && dy >= 0 && dx < N && dy < M) {
					if (Map[dx][dy] == 1 && !visited[dx][dy]) {
						// 다음 방문할 좌표
						queue.add(new Point(dx, dy));
						// 다음 방문할 좌표는 방문했던 점보다 +1 값이어야한다
						Map[dx][dy] = Map[p.x][p.y] + 1;
						visited[dx][dy] = true;
					}
				}
			}
		}
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

package Test;

import java.io.*;
import java.util.*;

/* 상, 하, 좌, 우가 인접을 의미(대각선은 영향x)
 * 며칠이 지나면 익게되는지 최소 일수
 * 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있음
 * 토마토가 모두 익지 못하는 상황이면 -1 출력
 * */
public class Main {
	static int N, M;
	static int Map[][];
	static int visited[][];

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static Queue<Point> queue = new LinkedList<Point>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		Map = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				Map[i][j] = temp;

				// 익지 않은 토마토라면, visited에 -1삽입 (방문 X 표시)
				if (temp == 0) {
					visited[i][j] = -1;
				}
				// 익은 토마토라면, queue에 삽입
				else if (temp == 1) {
					queue.add(new Point(i, j));
				}
			}
		}

		BFS();

		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == -1) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, visited[i][j]);
			}
		}

		System.out.println(max);
	}

	static void BFS() {
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int dx = p.x + dr[i];
				int dy = p.y + dc[i];

				if (dx >= 0 && dy >= 0 && dx < N && dy < M) {
					if (visited[dx][dy] == -1) {
						visited[dx][dy] = visited[p.x][p.y] + 1;
						queue.add(new Point(dx, dy));
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

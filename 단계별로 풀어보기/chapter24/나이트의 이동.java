package Test;

import java.io.*;
import java.util.*;

public class Main {
	static int T;
	static int I;

	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { -1, -2, -2, -1, 1, 2, 2, 1 };

	static Queue<Point> queue = new LinkedList<Point>();
	static int count;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			I = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이
			int[][] Map = new int[I][I];
			boolean[][] visited = new boolean[I][I];
			queue.clear();

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 나이트가 현재 있는 칸
			int ca = Integer.parseInt(st.nextToken());
			int cb = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			// 나이트가 이동하려고 하는 칸
			int ba = Integer.parseInt(st.nextToken());
			int bb = Integer.parseInt(st.nextToken());

			queue.add(new Point(ca, cb)); // 현재 위치 삽입
			visited[ca][cb] = true;

			DFS(Map, visited, ba, bb);
		}
		System.out.println(sb);
	}

	static void DFS(int[][] Map, boolean[][] visited, int ba, int bb) {
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			count++;

			// 목적지에 도착했을 때
			if (p.x == ba && p.y == bb) {
				sb.append(Map[p.x][p.y] + "\n");
				return;
			}

			for (int i = 0; i < 8; i++) {
				int dx = p.x + dr[i];
				int dy = p.y + dc[i];

				// 좌표의 범위를 넘어가지 않고
				if (dx >= 0 && dy >= 0 && dx < Map.length && dy < Map.length) {
					// 방문하지 않았다면
					if (!visited[dx][dy]) {
						queue.add(new Point(dx, dy));
						visited[dx][dy] = true;
						Map[dx][dy] = Map[p.x][p.y] + 1;
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

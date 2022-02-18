package Test;

import java.io.*;
import java.util.*;

/* S에서 G까지 최대 빠른 시간 내에 도착
 * 도로가 파여진 깊이에 비례해서 복구 시간은 증가
 * */
public class Main2 {
	static int T, N;
	static int Map[][];
	static int Distance[][]; // 최소거리를 저장하는 배열

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static StringBuilder sb = new StringBuilder();
	static int count = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		while (count <= T) {
			N = Integer.parseInt(br.readLine());

			Map = new int[N][N];
			Distance = new int[N][N];
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < N; j++) {
					Map[i][j] = Integer.parseInt(temp.substring(j, j + 1));
					Distance[i][j] = Integer.MAX_VALUE;
				}
			}

			Dijkstra(Map);
			sb.append("#" + count + " " + Distance[N - 1][N - 1] + "\n");
			count++;

		}
		System.out.println(sb);
	}

	static void Dijkstra(int[][] Map) {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();

		Distance[0][0] = Map[0][0];
		pq.add(new Point(0, 0, Distance[0][0]));

		while (!pq.isEmpty()) {
			Point p = pq.poll();

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dr[i];
				int dy = p.y + dc[i];

				if (dx >= 0 && dy >= 0 && dx < N && dy < N) {
					if (Distance[dx][dy] > Distance[p.x][p.y] + Map[dx][dy]) {
						Distance[dx][dy] = Distance[p.x][p.y] + Map[dx][dy];
						pq.add(new Point(dx, dy, Distance[dx][dy]));
					}
				}
			}
		}
	}
}

class Point implements Comparable<Point> {
	int x;
	int y;
	int distance;

	Point(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	@Override
	public int compareTo(Point o) {
		return this.distance - o.distance;
	}
}

package Test;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] Map;
	static int[][] Distance; // 최소 비용을 저장하는 배열
	static int N;

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int count = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			Map = new int[N][N];
			Distance = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					Map[i][j] = Integer.parseInt(st.nextToken());
					Distance[i][j] = Integer.MAX_VALUE;
				}
			}

			dijkstra(Map);
			sb.append("Problem " + count + ": " + Distance[N - 1][N - 1] + "\n");
			count += 1;
		}
		System.out.println(sb);
	}

	static void dijkstra(int[][] Map) {
                // 우선순위 큐 사용
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
	int cost;

	Point(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Point o) {
		return this.cost - o.cost; // 오름차순(반대시 내림차순)
	}
}


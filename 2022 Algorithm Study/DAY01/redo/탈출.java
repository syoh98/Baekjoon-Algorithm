package Test;

import java.io.*;
import java.util.*;

/* 1. 물과 고슴도치는 돌을 통과 할 수 없음
 * 2. 고슴도치는 물이 있는 구역을 통과할 수 없음
 * 3. 물은 비버의 소굴로 이동할 수 없음
 */

/* 고슴도치는 물이 찰 예정인 칸으로 이동할 수 없기 때문에
 * 1. 물과 고슴도치 각각 큐를 생성하고
 * 2. 물 먼저 큐에 삽입하고 그 후 고슴도치를 큐에 삽입
 * */

public class Main {
	static int R, C;
	static String[][] Map;
	static int count = 0;

	static Queue<Point> queue1 = new LinkedList<Point>(); // 고슴도치의 큐
	static Queue<Point> queue2 = new LinkedList<Point>(); // 물의 큐

	// 고슴도치, 물 이동 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Map = new String[R][C];

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				Map[i][j] = temp.substring(j, j + 1);
				if (Map[i][j].equals("S")) { // 고슴도치라면 queue1에 삽입
					queue1.add(new Point(i, j));
				} else if (Map[i][j].equals("*")) { // 물이라면 queue2에 삽입
					queue2.add(new Point(i, j));
				}
			}
		}

		BFS();

		System.out.println(count);
	}

	static void BFS() {
		while (true) {
			count += 1;
			int waterSize = queue2.size(); // 물구역의 개수

			for (int k = 0; k < waterSize; k++) {
				Point water = queue2.poll();

				for (int i = 0; i < 4; i++) {
					int dx = water.x + dr[i];
					int dy = water.y + dc[i];

					if (dx >= 0 && dy >= 0 && dx < R && dy < C) {
						if (Map[dx][dy].equals(".")) {
							Map[dx][dy] = "*";
							queue2.add(new Point(dx, dy));
						}
					}
				}
			}

			// 비버의 굴로 이동할 수 없는 경우
			if (queue1.size() == 0) {
				System.out.println("KAKTUS");
				System.exit(0);
			}

			int kaktusSize = queue1.size();

			for (int k = 0; k < kaktusSize; k++) {
				Point kaktus = queue1.poll();

				for (int i = 0; i < 4; i++) {
					int dx = kaktus.x + dr[i];
					int dy = kaktus.y + dc[i];

					if (dx >= 0 && dy >= 0 && dx < R && dy < C) {
						if (Map[dx][dy].equals("D")) {
							return;
						}
						if (Map[dx][dy].equals(".")) {
							Map[dx][dy] = "S";
							queue1.add(new Point(dx, dy));
						}
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

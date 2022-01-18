package P3055;

import java.io.*;
import java.util.*;

public class Main2 {
	static int R, C;
	static char[][] map;
	static int[][] dp;
	
	// 좌, 우, 위, 아래
	static int[] MX = { -1, 1, 0, 0 };
	static int[] MY = { 0, 0, -1, 1 };
	
	static Queue<Point> queue;
	static boolean foundAnswer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt(); // 행
		C = sc.nextInt(); // 열

		map = new char[R][C];
		dp = new int[R][C];
		queue = new LinkedList<>();

		// 물이 먼저냐 고슴도치가 먼저냐
		Point st = null;
		// 입력을 받고 starting point를 잡음
		for (int r = 0; r < R; r++) {
			String line = sc.next();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				if (map[r][c] == 'S') {
					st = new Point(r, c, 'S');
				} else if (map[r][c] == '*') {
					queue.add(new Point(r, c, '*'));
				}
			}
		}
		queue.add(st); // starting point를 따로 빼두었다가 마지막에 삽입

		// ***bfs***
		while (!queue.isEmpty()) {
			// 1. 큐에서 꺼내옴 -? S, ., D, *
			Point p = queue.poll();
			// 2. 목적지인가-> D
			if (p.type == 'D') {
				System.out.println(dp[p.y][p.x]);
				foundAnswer = true;
				break;
			}
			// 3. 연결된 곳을 순회 -> 좌우위아래
			for (int i = 0; i < 4; i++) {
				int ty = p.y + MY[i];
				int tx = p.x + MX[i];
				// 4. 갈 수 있는가? (공통)
				if (ty >= 0 && ty < R && tx >= 0 && tx < C) {
					if (p.type == '.' || p.type == 'S') { // 고슴도치
						if ((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0) {
							// 5. 체크인 -> dp에 현재+1을 기록
							dp[ty][tx] = dp[p.y][p.x] + 1;
							// 6. 큐에 넣음
							queue.add(new Point(ty, tx, map[ty][tx]));
						}

					} else if (p.type == '*') { // 4. 갈 수 있는가? (물) -> 맵을 벗어나지 않고
						if (map[ty][tx] == '.' || map[ty][tx] == 'S') {
							// 5. 체크인 -> 지도에 * 표기
							map[ty][tx] = '*';
							// 6. 큐에 넣음
							queue.add(new Point(ty, tx, '*'));
						}
					}
				}
			}
		}

		if (foundAnswer == false) {
			System.out.println("KAKTUS");
		}
	}
}

class Point {
	int y;
	int x;
	char type;

	public Point(int y, int x, char type) {
		super();
		this.y = y;
		this.x = x;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Point [y=" + y + ", x=" + x + ", type=" + type + "]";
	}
}

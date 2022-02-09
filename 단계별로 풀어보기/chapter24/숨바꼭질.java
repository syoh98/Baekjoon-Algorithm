package Test;

import java.io.*;
import java.util.*;

/*
 * 걷기: X - 1, X + 1
 * 순간이동: 2 * X
 * 
 * */
public class Main2 {
	static int N, K;
	static int count = 0;
	static int[] visited = new int[100001]; // 거리에 따른 초 기록

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 수빈위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치

		BFS();
	}

	static void BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		int X = N;

		queue.add(X); // 현재 인덱스 위치
		visited[X] = 1; // 현재는 1초

		while (!queue.isEmpty()) {
			X = queue.poll(); // 5

			// 목적지에 도착하면
			if (X == K) {
				System.out.println(visited[X] - 1); // 기록한 초를 출력
			}

			// 1. 배열의 범위를 벗어나지 않고,
			if (X - 1 >= 0) {
				if (visited[X - 1] == 0) { // 2. 값이 비어있으면
					visited[X - 1] = visited[X] + 1; // 3. 현재 위치 값의 1을 더한 수를 왼쪽 위치에 삽입
					queue.add(X - 1); // 인덱스를 큐에 삽입
				}
			}

			// 1. 배열의 범위를 벗어나지 않고,
			if (X + 1 < visited.length) {
				if (visited[X + 1] == 0) { // 2. 값이 비어있으면
					visited[X + 1] = visited[X] + 1; // 3. 현재 위치 값의 1을 더한 수를 오른쪽 위치에 삽입
					queue.add(X + 1); // 인덱스를 큐에 삽입
				}
			}
			
			// 1. 배열의 범위를 벗어나지 않고,
			if (X * 2 < visited.length) {
				if (visited[X * 2] == 0) { // 2. 값이 비어있으면
					visited[X * 2] = visited[X] + 1;
					queue.add(X * 2); // 인덱스를 큐에 삽입
				}
			}

		}
	}
}

package P2252;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] indegree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 학생들의 수
		M = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수
		indegree = new int[N + 1]; // 자신을 가르키는 간선의 수
		ArrayList<Integer>[] list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			list[num1].add(num2);
			indegree[num2]++;
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		// 큐가 빌 때까지 반복수행
		while (!queue.isEmpty()) {
			System.out.print(queue.peek() + " ");

			int current = queue.poll();

			// 자신이 가르키고 있는 좌표를 방문하여 indegree값을 -1
			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);
				indegree[next]--;
				// 진입차수가 0인 정점들을 큐에 넣는다
				if (indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
	}
}

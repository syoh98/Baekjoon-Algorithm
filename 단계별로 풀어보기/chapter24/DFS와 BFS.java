import java.io.*;
import java.util.*;

/* bfs: 인접한 정점
 * dfs: 정점 끝까지
 * */

/* [조건]
 * 방문할 수 있는 정점이 여러개인 경우 정점 번호가 작은 것부터 먼저 방문
 * 더 이상 방문할 수 있는 점이 없는 경우 종료
 * */

public class Main {
	static int N, M, V;
	static Queue<Integer> queue;
	static int check[][]; // 연결정보 check
	static int start, end;
	static boolean[] visited1; // 노드 방문 기록
	static boolean[] visited2; // 노드 방문 기록

	static StringBuilder sb1, sb2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb1 = new StringBuilder();
		sb2 = new StringBuilder();
		queue = new LinkedList<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 탐색을 시작 노드 번호

		check = new int[N + 1][N + 1]; // 노드 연결정보

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken()); // 시작 노드
			end = Integer.parseInt(st.nextToken()); // 끝 노드

			check[start][end] = 1;
			check[end][start] = 1;
		}

		visited1 = new boolean[N + 1];
		dfs(V);

		visited2 = new boolean[N + 1];
		bfs(V);

		System.out.println(sb1);
		System.out.println(sb2);
	}

	public static void dfs(int start) {
		visited1[start] = true;
		sb1.append(start + " ");

		// 1. 목적지인가?
		if (start == check.length) {
			return;
		}
		// 2. 연결된 곳을 순회
		for (int currentIndex = 1; currentIndex < check.length; currentIndex++) {
			// 3. 갈 수 있는가? -> 지금의 노드와 연결되있고, 아직 방문하지 않은 노드
			if (check[start][currentIndex] == 1 && visited1[currentIndex] == false) {
				dfs(currentIndex);
			}
		}
	}

	public static void bfs(int start) {
		// 1. 큐에 넣는다
		queue.add(start);
		visited2[start] = true;
		sb2.append(start + " ");

		// 2. 목적지인가?
		while (!queue.isEmpty()) {
			int startNode = queue.peek();
			queue.poll();
			for (int currentIndex = 1; currentIndex <= N; currentIndex++) {
				if (check[startNode][currentIndex] == 1 && visited2[currentIndex] == false) {
					queue.add(currentIndex);
					visited2[currentIndex] = true;
					sb2.append(currentIndex + " ");
				}
			}
		}
	}
}

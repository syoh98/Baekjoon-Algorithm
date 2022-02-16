import java.io.*;
import java.util.*;

/* 다음과 같이 두가지의 경우를 생각
 * 1) 각각의 마을에서 파티장소로 이동
 * 2) 파티장소에서 다시 각각의 마을로 이동
 * 
 * 2번의 경우는, 시작지점에서 각각 마을의 최단거리를 구하면됨 -> Dijkstra 알고리즘
 * 1번의 경우는, N개의 마을에 대해 각각 다익스트라를 사용하면 비효율적임
 * -> 따라서 단방향 간선을 반대로 저장하는 것이 효율적임
 *    -> 파티장소를 도착지점이 아닌 출발지점으로 바꿔서 생각
 * */

public class Main {
	static int N, M, X;

	static ArrayList<ArrayList<Node>> list, revList;
	static int[] dist, revDist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		list = new ArrayList<ArrayList<Node>>();
		revList = new ArrayList<ArrayList<Node>>();

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 노드
		M = Integer.parseInt(st.nextToken()); // 간선
		X = Integer.parseInt(st.nextToken()); // 도착지점(파티장소)

		// -- init --
		dist = new int[N + 1];
		revDist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(revDist, Integer.MAX_VALUE);

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
			revList.add(new ArrayList<Node>());
		}
		// ----------

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken()); // 시작점
			int end = Integer.parseInt(st.nextToken()); // 끝점
			int weight = Integer.parseInt(st.nextToken());

			// 단방향 인접리스트로 구현
			list.get(start).add(new Node(end, weight));
			revList.get(end).add(new Node(start, weight));
		}

		Dijkstra(list, dist, X);
		Dijkstra(revList, revDist, X);

		int max = -1;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dist[i] + revDist[i]);
		}

		System.out.println(max);
	}

	static void Dijkstra(ArrayList<ArrayList<Node>> list, int[] dist, int start) {
		boolean[] visited = new boolean[N + 1]; // 방문체크

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0)); // 시작점

		dist[start] = 0;

		while (!pq.isEmpty()) {
			int index = pq.poll().index; // X

			if (visited[index]) { // 방문한 인덱스는 다시 방문할 필요없기 때문
				continue;
			}
			visited[index] = true;

			for (Node node : list.get(index)) {
				if (dist[node.index] > dist[index] + node.dist) {
					dist[node.index] = dist[index] + node.dist;
					pq.add(new Node(node.index, dist[node.index]));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int index; // 마을 번호
	int dist; // 시작점으로부터의 거리

	Node(int index, int dist) {
		this.index = index;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node o) {
		return this.dist - o.dist; // 오름차순(거리가 짧은 순)
	}

}

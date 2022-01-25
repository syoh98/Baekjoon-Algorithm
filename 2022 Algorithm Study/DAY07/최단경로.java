package P1753;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int end, weight;

	public Node(int end, int weight) {
		super();
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight; // 간선의 길이가 짧은 것부터 나오도록
	}
}

public class Main {
	static int V, E, K;
	static ArrayList<Node>[] list;
	static int[] dist;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

		list = new ArrayList[V + 1]; // 간선리스트
		dist = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
			dist[i] = INF; // 배열의 모든 값을 같은 값으로 초기화
		}

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // start node
			int v = Integer.parseInt(st.nextToken()); // end node
			int w = Integer.parseInt(st.nextToken()); // 가중치

			// start node에서 end node로 가는 가중치
			list[u].add(new Node(v, w));
		}

		dijkstra(K);

		for (int i = 1; i <= V; i++) {
			if (dist[i] != INF) {
				sb.append(dist[i] + "\n");
			} else {
				sb.append("INF" + "\n");
			}
		}
		
		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();

		dist[start] = 0;
		queue.add(new Node(start, 0));

		Node nowNode;
		while (!queue.isEmpty()) {
			nowNode = queue.poll();

			if (nowNode.weight > dist[nowNode.end]) {
				continue;
			}

			for (Node next : list[nowNode.end]) {
				if (dist[next.end] > dist[nowNode.end] + next.weight) {
					dist[next.end] = dist[nowNode.end] + next.weight;
					queue.add(new Node(next.end, dist[next.end]));
				}
			}
		}
	}
}

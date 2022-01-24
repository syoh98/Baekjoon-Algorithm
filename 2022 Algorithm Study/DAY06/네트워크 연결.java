package P1922;

import java.io.*;
import java.util.*;

// 간선
class Edge implements Comparable<Edge> {
	int nodeA;
	int nodeB;
	int weight;

	public Edge(int nodeA, int nodeB, int weight) {
		super();
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.weight = weight;
	}

	// 간선을 오름차순 정렬해준다
	@Override
	public int compareTo(Edge o) {
		return weight - o.weight;
	}
}

public class Main {
	static int N, M;
	static ArrayList<Edge> edgeList; // 간선정보 리스트
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수
		parent = new int[N + 1];
		edgeList = new ArrayList<>();

		// 컴퓨터 비용정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(nodeA, nodeB, weight));
		}

		// 간선이 자기 자신을 가리키도록
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		Collections.sort(edgeList); // 오름차순 정렬

		int sum = 0;
		// 정렬된 간선을 순서대로 선택
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);

			// 사이클이 발생하는 간선 제외
			if (find(edge.nodeA) != find(edge.nodeB)) {
				sum += edge.weight;
				union(edge.nodeA, edge.nodeB);
			}
		}
		
		System.out.println(sum);

	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			parent[b] = a;
		}
	}

	public static int find(int a) {
		if (parent[a] == a) {
			return a;
		}

		return parent[a] = find(parent[a]);
	}
}

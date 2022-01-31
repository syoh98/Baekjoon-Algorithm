import java.io.*;
import java.util.*;

/* [조건]
 * 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
 * */

public class Main {
	static int N, E;
	static int[][] check;
	static Queue<Integer> queue;
	static int num = 0; // 바이러스에 걸린 컴퓨터 수
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		queue = new LinkedList<Integer>();

		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		check = new int[N + 1][N + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			check[node1][node2] = 1;
			check[node2][node1] = 1;
		}
		visited = new boolean[N + 1];
		bfs(1);

		System.out.println(num);
	}

	public static void bfs(int start) {
		queue.add(start);
		visited[start] = true;
		//num++;

		while (!queue.isEmpty()) {
			int startNode = queue.peek();
			queue.poll();
			
			for (int currentNode = 1; currentNode <= N; currentNode++) {
				if (check[startNode][currentNode] == 1 && visited[currentNode] == false) {
					queue.add(currentNode);
					visited[currentNode] = true;
					num++;
				}
			}
		}
	}
}

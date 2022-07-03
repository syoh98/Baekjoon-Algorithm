import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author syoh98
 * @since 2022. 07. 03.
 * @see https://www.acmicpc.net/problem/11724
 * @category DFS
 */
public class Main {
	static int[][] graph = new int[1001][1001];
	static int V, E;
	static boolean[] visited = new boolean[1001];

	public static void dfs(int index) {
		if (visited[index] == true) {
			return;
		} else {
			visited[index] = true;
			for (int i = 1; i <= V; i++) {
				if (graph[index][i] == 1) {
					dfs(i);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nums = br.readLine().split(" ");
		V = Integer.parseInt(nums[0]);
		E = Integer.parseInt(nums[1]);

		int u, v;

		for (int i = 0; i < E; i++) {
			String[] temp = br.readLine().split(" ");
			u = Integer.parseInt(temp[0]);
			v = Integer.parseInt(temp[1]);

			graph[u][v] = graph[v][u] = 1;
		}

		int result = 0;

		for (int i = 1; i <= V; i++) {
			if (visited[i] == false) {
				dfs(i);
				result++;
			}
		}
		System.out.println(result);
	}
}

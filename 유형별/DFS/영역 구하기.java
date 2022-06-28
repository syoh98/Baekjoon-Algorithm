import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/***
 * 
 * @author syoh
 * @since 2022. 06. 28.
 * @see https://www.acmicpc.net/problem/2583
 * @category DFS
 */
public class Main {
	static int N, M, K, count = 0, result = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean visited[][];
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int dx = x + dr[i];
			int dy = y + dc[i];

			if (dx >= 0 && dy >= 0 && dx < M && dy < N) {
				if (!visited[dx][dy]) {
					dfs(dx, dy);
					count++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 세로
		N = Integer.parseInt(st.nextToken()); // 가로
		K = Integer.parseInt(st.nextToken()); // 직사각형 갯수

		visited = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			// 왼쪽 아래 꼭짓점
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());

			// 오른쪽 위 꼭짓점
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int m = y1; m < y2; m++) {
				for (int n = x1; n < x2; n++) {
					visited[m][n] = true;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					count = 1;
					result++;
					dfs(i, j);
					list.add(count);
				}
			}
		}
		Collections.sort(list); // 오름차순 정렬
		System.out.println(result);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}

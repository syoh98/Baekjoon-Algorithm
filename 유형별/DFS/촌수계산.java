import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author syoh98
 * @since 2022. 06. 22.
 * @see https://www.acmicpc.net/problem/2644
 * @category DFS
 */
public class Main {
	static int[][] map;
	static boolean[] check;
	static int count = -1; // 친척 관계가 전혀없는 경우는 -1을 출력하기 위해

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 전체 사람의 수
		int N = Integer.parseInt(br.readLine());

		map = new int[101][101];
		check = new boolean[101];

		// 계산해야 하는 서로 다른 두 사람의 번호
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		// 부모자식들 간의 관계의 개수
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // y의 부모 번호
			int y = Integer.parseInt(st.nextToken());

			map[x][y] = 1;
			map[y][x] = 1;
		}

		dfs(start, end, 0);

		System.out.println(count);
	}

	public static void dfs(int start, int end, int cnt) { // 현재 번호, 목표 친척 번호, 지금까지의 거리
		if (start == end) {
			count = cnt;
			return;
		}

		check[start] = true;

		for (int i = 1; i <= 100; i++) {
			if (map[start][i] == 1 && !check[i]) {
				dfs(i, end, cnt + 1);
			}
		}
	}

}

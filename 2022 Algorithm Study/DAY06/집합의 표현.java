package P1717;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 연산의 개수
		parent = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int com = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (com == 0) {
				union(A, B);
			}

			if (com == 1) {
				if (find(A) == find(B)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	public static void union(int A, int B) {
		int aGroup = find(A);
		int bGroup = find(B);

		parent[aGroup] = bGroup;
	}

	// A의 부모 찾기
	public static int find(int A) {
		if (parent[A] == A) {
			return A;
		} else {
			return parent[A] = find(parent[A]); // 시간단축을 위해
		}
	}
}

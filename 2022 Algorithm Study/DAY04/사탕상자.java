package P2243;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int MAX = 1000000;
	static int[] tree;
	static int S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = 1;
		while (S < MAX) {
			S *= 2;
		}
		tree = new int[2 * S];
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());

			if (A == 2) {
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				update(1, S, 1, B, C);
			}

			else if (A == 1) {
				int B = Integer.parseInt(st.nextToken());
				int index = query(1, S, 1, B);
				update(1, S, 1, index, -1); // 100000말고 S로 꼭 넣어주기
				System.out.println(index);
			}
		}
	}

	// count: 내가 찾는 값(몇 번째를 의미)
	static int query(int left, int right, int node, int count) {
		// 1. Leaf에 도착했을 때 -> 사탕 번호 반환
		if (left == right) { // leaf에 도착함을 의미
			return left; // 둘 중 아무거나 리턴
		}
		int mid = (left + right) / 2;
		// 2. 왼쪽 >= count -> 왼쪽으로 이동
		if (tree[node * 2] >= count) {
			return query(left, mid, node * 2, count); // count는 그대로(내가 찾는 값이니까, 잘라내지 않아서)
		}
		// 3. 왼쪽 < count
		else {
			return query(mid + 1, right, node * 2 + 1, count - tree[node * 2]); // 왼쪽꺼 잘라낼거니까 왼쪽꺼 빼줘야함
		}
	}

	// diff는 오리지널 값이랑 내가 바꾸는 값이랑 차이
	static void update(int left, int right, int node, int index, long diff) {
		if (left <= index && index <= right) {
			tree[node] += diff;
			if (left != right) {
				int mid = (left + right) / 2;
				update(left, mid, node * 2, index, diff);
				update(mid + 1, right, node * 2 + 1, index, diff);
			}
		}
	}
}

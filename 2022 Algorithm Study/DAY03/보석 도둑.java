package P1202;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 보석 개수
		int K = Integer.parseInt(st.nextToken()); // 가방의 개수

		Jewelry[] jewelry = new Jewelry[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// M: 보석의 무게, V: 보석의 가격
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			jewelry[i] = new Jewelry(M, V);
		}

		// 무게를 오름차순 정렬, but 같은 무게인 경우 내림차순
		Arrays.sort(jewelry, new Comparator<Jewelry>() {
			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				if (o1.M == o2.M) {
					return o2.V - o1.V;
				}
				return o1.M - o2.M;
			}

		});

		int[] bag = new int[K];
		for (int i = 0; i < K; i++) {
			// C: 가방에 담을 수 있는 최대무게
			int C = Integer.parseInt(br.readLine());
			bag[i] = C;
		}
		Arrays.sort(bag); // 가방 오름차순 정렬

		// ** 가격 내림차순 되도록 **
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long ans = 0; // 훔칠 수 있는 보석 가격의 합

		for (int i = 0, j = 0; i < K; i++) {
			// 현재 가방의 무게보다 작거나 같은 보석을 pq에 모두 삽입한다
			while (j < N && jewelry[j].M <= bag[i]) {
				pq.offer(jewelry[j++].V);
			}

			// pq에 있는 것 중에 첫 번째를 빼서 가방에 넣음
			// 첫 번째 있는 것은 제일 비싼 가격을 의미
			if (!pq.isEmpty()) {
				ans += pq.poll();
			}
		}

		System.out.println(ans);
	}
}

class Jewelry {
	int M;
	int V;

	public Jewelry(int M, int V) {
		this.M = M;
		this.V = V;
	}
}

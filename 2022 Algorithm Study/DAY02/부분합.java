package P2003;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수열의 갯수
		int M = Integer.parseInt(st.nextToken()); // 수열의 합 크기

		nums = new int[N + 1]; // 아래코드에서 ++high를 수행하기 때문에 배열크기+1로 설정

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int low = 0, high = 0, sum = nums[0], minLength = Integer.MAX_VALUE;

		while (true) {
			// sum == M -> 답 low++
			if (sum >= M) {
				minLength = Math.min(high - low + 1, minLength);
				sum -= nums[low++];
			} else {
				sum += nums[++high];
			}
			if (high == N) {
				break;
			}
		}

		if (minLength == Integer.MAX_VALUE) {
			System.out.println(0);
		} else
			System.out.println(minLength);

	}

}

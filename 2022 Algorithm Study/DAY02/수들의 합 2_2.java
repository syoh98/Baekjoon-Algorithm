package P2003;

import java.io.*;
import java.util.*;

public class Main2 {

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
		//System.out.println(Arrays.toString(nums));

		int low = 0, high = 0, sum = nums[0], count = 0;
		while (true) {
			// sum == M -> 답 low++
			if (sum == M) {
				count++;
				sum -= nums[low++]; // low값을 사용 후 ++증가(순서주의)
			}
			// sum > M -> low++
			else if (sum > M) {
				sum -= nums[low++];
			}
			// sum < M -> high++
			else {
				sum += nums[++high]; // high 증가 먼저
			}
			// high가 범위를 벗어났을 때
			if(high == N) {
				break;
			}
		}
		
		System.out.println(count);
	}
}

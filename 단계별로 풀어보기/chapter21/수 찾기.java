import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String str1 = br.readLine(); // A[1], A[2], …, A[N]
		StringTokenizer st1 = new StringTokenizer(str1);
		int[] arrN = new int[N];

		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st1.nextToken());
		}
		Arrays.sort(arrN); // 정렬

		int M = Integer.parseInt(br.readLine());
		String str2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(str2);

		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st2.nextToken());
			sb.append(Integer.toString(binarySearch(arrN, key)) + "\n");
		}

		System.out.println(sb);
	}

	public static int binarySearch(int[] arrN, int key) {
		int front = 0; // 첫 번째 인덱스
		int back = arrN.length - 1; // 마지막 인덱스

		// 존재하면 1을, 존재하지 않으면 0을 sb에 append
		while (front <= back) {
			int mid = (front + back) / 2; // 중간 값

			if (key < arrN[mid]) {
				back = mid - 1;
			} else if (key > arrN[mid]) {
				front = mid + 1;
			} else { // key == arrN[mid]
				return 1;
			}
		}
		return 0;

	}
}

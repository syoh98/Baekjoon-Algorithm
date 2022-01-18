import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
	static long X, Y, Z;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken()); // 게임 횟수
		Y = Integer.parseInt(st.nextToken()); // 이긴 게임
		Z = Y * 100 / X; // 승률

		// Z가 절대 변하지 않을 때 -> 확률이 99인 경우
		if (Z >= 99) {
			System.out.println("-1");
		} else {
			binarySearch(1, X);
		}
	}

	public static void binarySearch(long start, long end) {
		long mid = 0; // 중간 값
		long per = 0; // 기존의 승률과 비교할 새로운 승률

		while (start <= end) {
			mid = (start + end) / 2;
			per = (Y + mid) * 100 / (X + mid);

			if (per > Z) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(start);
	}
}

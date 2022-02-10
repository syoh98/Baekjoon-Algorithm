package Test;

import java.io.*;
import java.util.*;

/* 아래에서 위로 올라오면서, 나와 내 오른쪽 값 중 큰 값을 위에 더해준다
 * 위에서 아래로 내려오는 것만 생각하지말고 양쪽 모두 생각하기
 * */
public class Main {
	static int N; // 삼각형의 크기
	static int[][] rect;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		rect = new int[N + 1][N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				rect[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				rect[i - 1][j] += Math.max(rect[i][j], rect[i][j + 1]);
			}
		}

		System.out.println(rect[0][0]);
	}
}

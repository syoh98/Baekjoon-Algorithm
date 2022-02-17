package Test;

import java.io.*;
import java.util.*;

/* 메모이제이션
 * */

public class Main {
	static int T;
	// 1 <= N <= 100
	public static Long[] list = new Long[101];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		list[0] = (long) 0;
		list[1] = (long) 1;
		list[2] = (long) 1;
		list[3] = (long) 1;
		list[4] = (long) 2;

		T = Integer.parseInt(br.readLine()); // 2
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(pivo(N) + "\n");
		}
		
		System.out.println(sb);
	}

	static long pivo(int N) {
		if (list[N] == null) {
			list[N] = pivo(N - 2) + pivo(N - 3);
		}

		return list[N];
	}
}

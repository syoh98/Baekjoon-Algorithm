package Test;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			// 무조건 한수에 속한다
			if (i <= 99) {
				cnt++;
			}
			// 그 이상의 수이면, (백의자리수-십의자리수 == 십의자리수-일의자리수) 조건을 만족해야 한수이다
			else if (i <= 999) {
				String[] temp = Integer.toString(i).split("");

				if (Integer.parseInt(temp[2]) - Integer.parseInt(temp[1]) == Integer.parseInt(temp[1])
						- Integer.parseInt(temp[0])) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}

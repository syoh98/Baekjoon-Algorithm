import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 5
		int[][] list = new int[N][2];

		// 값 넣기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 3 4
			list[i][0] = Integer.parseInt(st.nextToken()); // 3
			list[i][1] = Integer.parseInt(st.nextToken()); // 4
		}
                // lamda
		Arrays.sort(list, (e1, e2) -> {
			if (e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});

		for (int i = 0; i < N; i++) {
			sb.append(list[i][0] + " " + list[i][1] + "\n");
		}

		System.out.println(sb);
	}
}

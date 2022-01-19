package Test;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();

		int N = Integer.parseInt(br.readLine()); // 명령의 수
		int X = 0; // 정수 X

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String com = st.nextToken();

			if (com.equals("push")) {
				X = Integer.parseInt(st.nextToken());
				queue.add(X);
			} else if (com.equals("front")) {
				sb.append(queue.isEmpty() ? "-1\n" : Integer.toString(queue.peek()) + "\n");
			} else if (com.equals("back")) {
				sb.append(queue.isEmpty() ? "-1\n" : Integer.toString(X) + "\n");
			} else if (com.equals("pop")) {
				sb.append(queue.isEmpty() ? "-1\n" : Integer.toString(queue.poll()) + "\n");
			} else if (com.equals("size")) {
				sb.append(queue.size() + "\n");
			} else if (com.equals("empty")) {
				sb.append(queue.isEmpty() ? "1\n" : "0\n");
			}
		}

		System.out.println(sb);
	}
}

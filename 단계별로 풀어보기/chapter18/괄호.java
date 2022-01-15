import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 

		for (int i = 0; i < T; i++) {
			String temp = result(br.readLine());
			sb.append(temp + "\n");
		}
		System.out.println(sb);
	}

	public static String result(String str) {
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			String temp = str.substring(i, i + 1);

			if (temp.equals("(")) {
				stack.push(temp);
			}

			// -- ")" 인 경우
			else if (stack.empty()) { // 스택이 비어있는 경우
				return "NO";
			} else {
				stack.pop();
			}
			// --
		}
		// 스택에 데이터가 남아있지 않을 경우
		if (stack.empty()) {
			return "YES";
		} else {
			return "NO";
		}
	}
}

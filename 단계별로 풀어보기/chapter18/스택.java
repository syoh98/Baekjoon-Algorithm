import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>(); // int형 스택 선언

		int N = Integer.parseInt(br.readLine()); // 명령의 수
		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine(); // push X / pop / size / empty / top

			if (temp.contains(" ")) {
				int num = Integer.parseInt(temp.substring(5, temp.length()));
				stack.push(num);
			} else {
				if (temp.equals("pop")) { // 스택에서 가장위에 있는 정수를 출력, 스택에 값이 없으면 -1 출력
					if (stack.empty()) {
						sb.append("-1" + "\n");
					} else {
						sb.append(stack.peek() + "\n");
						stack.pop();
					}
				} else if (temp.equals("size")) { // 스택에 들어있는 정수의 개수를 출력
					sb.append(stack.size() + "\n");
				} else if (temp.equals("empty")) { // 스택이 비어있으면 1, 아니면 0 출력
					if (stack.empty()) {
						sb.append("1" + "\n");
					} else {
						sb.append("0" + "\n");
					}
				} else if (temp.equals("top")) { // 스택의 가장 위에 있는 정수를 출력, 스택에 값이 없으면 -1 출력
					if (stack.empty()) {
						sb.append("-1" + "\n");
					} else {
						sb.append(stack.peek() + "\n");
					}
				}
			}
		}

		System.out.println(sb);
	}
}

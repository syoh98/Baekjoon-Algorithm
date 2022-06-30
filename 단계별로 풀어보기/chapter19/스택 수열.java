import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/***
 * 
 * @author syoh98
 * @since 2022. 07. 01.
 * @see https://www.acmicpc.net/problem/1874
 * @category STACK
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] numList = new int[N + 1]; // input data
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<String> result = new ArrayList<String>();
		int count = 1;

		// input
		for (int i = 1; i <= N; i++) {
			numList[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			stack.push(i);
			result.add("+");

			while (!stack.empty() && stack.peek() == numList[count]) {
				stack.pop();
				result.add("-");
				count++;
			}
		}

		if (stack.empty()) {
			for (String resultData : result) {
				System.out.println(resultData);
			}
		} else { // 불가능한 경우
			System.out.println("NO");
		}
	}
}

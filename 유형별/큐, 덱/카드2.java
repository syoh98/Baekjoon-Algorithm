import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/***
 * 
 * @author syoh98
 * @since 2022. 06. 21.
 * @see https://www.acmicpc.net/problem/2164
 * @category QUEUE
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());

		// 데이터 삽입
		for (int i = 1; i < N + 1; i++) {
			queue.add(i);
		}

		while (queue.size() > 1) {
			queue.poll();
			queue.add(queue.poll());
		}

		System.out.println(queue.poll());
	}
}

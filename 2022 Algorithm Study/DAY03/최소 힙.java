package P1927;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 오름차순으로 정렬되기 때문에 숫자가 작을수록 우선순위가 높다
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine()); // 연산의 개수
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			// 0이 아니라면 배열에 x값을 추가
			if (x != 0) {
				queue.add(x);
			}
			// 배열이 비어있는 경우 -> 0 출력
			else if (queue.isEmpty()) {
				System.out.println("0");
			}
			// 0이라면 배열에서 가장 작은 값 출력, 배열에서 제거
			else {
				System.out.println(queue.poll());
			}
		}
	}
}

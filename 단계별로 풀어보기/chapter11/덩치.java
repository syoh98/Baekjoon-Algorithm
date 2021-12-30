import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			arr[i][0] = scanner.nextInt(); // 몸무게
			arr[i][1] = scanner.nextInt(); // 키
		}

		for (int i = 0; i < N; i++) {
			int rank = 1; // 등수 비교
			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
			System.out.print(rank + " ");
		}
		scanner.close();
	}
}

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt(); // 입력받는 수의 갯수
		int X = scanner.nextInt(); // X보다 작은수

		int[] arr = new int[N+1];

		for (int i = 1; i <= N; i++) {
			arr[i] = scanner.nextInt();
		}

		for (int j = 1; j <= N; j++) {
			if (arr[j] < X) {
				System.out.print(arr[j] + " ");
			}
		}
		
		scanner.close();
	}
}

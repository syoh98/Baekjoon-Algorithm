import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt(); // 카드의 개수
		int M = scanner.nextInt(); // 최대값
		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}
		scanner.close();
		
		int result = searchMax(arr, N, M);
		System.out.println(result);	
	}
	
	static int searchMax(int[] arr, int N, int M) {
		int result = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int z = j + 1; z < N; z++) {
					int sum = arr[i] + arr[j] + arr[z];
					if(sum == M) {
						result = M;
						break;
					}
					if(result < sum && sum < M) {
						result = sum;
					}
				}
			}
		}
		return result;
	}
}

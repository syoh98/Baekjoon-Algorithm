import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int M = scanner.nextInt(); // 수의 개수
		int[] arr = new int[M]; // M개만큼 입력받는 수

		for (int i = 0; i < M; i++) {
			arr[i] = scanner.nextInt();
		}
		Arrays.sort(arr); // 오름차순으로 정렬

		int N = scanner.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int key = scanner.nextInt();
			sb.append(upperBound(arr, key) - lowerBound(arr, key));
			sb.append(" ");
		}
		System.out.println(sb);
	}

	public static int lowerBound(int[] arr, int key) { // 하한
		int low = 0;
		int high = arr.length;

		while (low < high) {
			int mid = (low + high) / 2;

			if (key <= arr[mid]) {
				high = mid;
			} else { // 중복원소 case
				low = mid + 1;
			}
		}
		return low;
	}

	public static int upperBound(int[] arr, int key) { // 상한
		int low = 0;
		int high = arr.length;

		while (low < high) {
			int mid = (low + high) / 2;
			
			if(key < arr[mid]) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		return low;
	}
}

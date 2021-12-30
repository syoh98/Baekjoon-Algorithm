import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int arr[] = new int[N];
		int temp[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}
		scanner.close();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i] < arr[j]) {
					int tempI = arr[i];
					int tempJ = arr[j];
					
					arr[i] = tempJ;
					arr[j] = tempI;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

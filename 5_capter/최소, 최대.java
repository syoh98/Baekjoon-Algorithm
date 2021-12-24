import java.util.Scanner;

public class Main {
	@SuppressWarnings("null")
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int[] array = new int[N];
		int max = 0, min = 0;

		for (int i = 0; i <= N-1; i++) {
			array[i] = scanner.nextInt();
		}
		
		min = array[0];
		max = array[0];

		for (int i = 0; i <= N-1; i++) {
			if(min > array[i]) {
				min = array[i];
			}
			if (max < array[i]) {
				max = array[i];
			}
		}
		System.out.println(min + " " + max);

		scanner.close();
	}
}

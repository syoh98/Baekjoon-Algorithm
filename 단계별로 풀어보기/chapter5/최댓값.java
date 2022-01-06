import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int[] array = new int[10];
		int max = 0;
		int index = 0;

		for (int i = 0; i <= 8; i++) {
			array[i] = scanner.nextInt();
		}
		max = 0;

		for (int i = 0; i <= 8; i++) {
			if (max < array[i]) {
				max = array[i];
				index = i + 1;
			}
		}
		System.out.println(max);
		System.out.println(index);

		scanner.close();
	}
}

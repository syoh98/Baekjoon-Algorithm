import java.util.Scanner;

public class Main {
	@SuppressWarnings("null")
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		for (int i = n; i >= 1; i--) {
			System.out.println(i);
		}
		scanner.close();
	}
}

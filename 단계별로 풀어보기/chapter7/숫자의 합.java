import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int sum = 0;
		int N = scanner.nextInt();
		String str = scanner.next();

		scanner.close();

		for (int i = 0; i < N; i++) {
			sum += str.charAt(i) - '0';
		}

		System.out.println(sum);
	}
}

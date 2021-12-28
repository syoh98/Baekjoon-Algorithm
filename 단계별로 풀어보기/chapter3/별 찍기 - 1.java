import java.util.Scanner;

public class Main {
	@SuppressWarnings("null")
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		String result = "";
		
		for (int i = 1; i <= n; i++) {
			result = result + "*";
			System.out.println(result);
		}
		scanner.close();
	}
}

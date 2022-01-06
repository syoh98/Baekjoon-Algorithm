import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		StringBuilder sb = new StringBuilder();
		String[] arr = new String[n];

		for (int i = 1; i <= n; i++) {
			for (int j = n; j >= 1; j--) {
				if (i < j) {
					System.out.print(" ");
				} else {
					System.out.print("*"); // 공백 갯수
				}
			}
			System.out.println();
		}
		scanner.close();
	}
}

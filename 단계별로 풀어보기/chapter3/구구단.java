import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		/*
		 * int hour = in.nextInt(); int minute = in.nextInt(); int ahour = 0;
		 */

		int n = in.nextInt();

		in.close();

		for (int i = 1; i <= 9; i++) {
			System.out.println(n + " * " + i + " = " + n * i);
		}

	}
}

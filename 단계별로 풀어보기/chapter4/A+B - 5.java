import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		int a = scanner.nextInt();
		int b = scanner.nextInt();

		sb.append((Integer.toString(a + b)) + "\n");

		while (a != 0 && b != 0) {
			a = scanner.nextInt();
			b = scanner.nextInt();

			if(a == 0 && b == 0) {
				break;
			}
			sb.append((Integer.toString(a + b)) + "\n");
		}

		System.out.print(sb);
	}
}

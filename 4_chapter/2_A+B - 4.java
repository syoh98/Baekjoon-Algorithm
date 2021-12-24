import java.io.*;
import java.util.*;

public class Main {
	@SuppressWarnings("null")
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextInt()) {

			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(a + b);
		}
		
		scanner.close();
	}
}

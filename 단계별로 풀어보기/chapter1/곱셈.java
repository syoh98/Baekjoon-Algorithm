import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		String b = scanner.next();
		
		scanner.close();
		
		System.out.println(a * (b.charAt(2) - '0' ));
		System.out.println(a * (b.charAt(1) - '0'));
		System.out.println(a * (b.charAt(0) - '0'));
		System.out.println(a * Integer.parseInt(b));
	}
}

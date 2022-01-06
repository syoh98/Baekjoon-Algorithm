import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		char ch = scanner.nextLine().charAt(0); // 소문자 or 대문자 or 숫자
		
		System.out.println((int)ch);
		scanner.close();
	}
}

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int[] array = new int[26];
		for (int k = 0; k < 26; k++) {
			array[k] = 0;
		}

		String alpha = scanner.nextLine(); // 알파벳을 입력받는다
		scanner.close();

		for (int i = 0; i < alpha.length(); i++) {
			if (65 <= alpha.charAt(i) && alpha.charAt(i) <= 90) { // 대문자
				array[alpha.charAt(i) - 65]++;
			} else { // 소문자
				array[alpha.charAt(i) - 97]++;
			}
		}

		int max = -1;
		char ch = '?';

		for (int k = 0; k < 26; k++) {
			if (max < array[k]) {
				max = array[k];
				ch = (char) (k + 65);
			} else if (max == array[k]) {
				ch = '?';
			}
		}
		System.out.println(ch);
	}

}

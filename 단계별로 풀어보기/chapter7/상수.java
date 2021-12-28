import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		String num1 = scanner.next();
		String num2 = scanner.next();

		scanner.close();

		String[] temArr1 = new String[3];
		String[] temArr2 = new String[3];

		for (int i = 0; i < temArr1.length; i++) { // 숫자 1
			temArr1[i] = num1.substring(i, i + 1);
		}

		for (int i = 0; i < temArr1.length; i++) {
			sb1.append(temArr1[2 - i]);
		}

		for (int i = 0; i < temArr2.length; i++) { // 숫자 2
			temArr2[i] = num2.substring(i, i + 1);
		}

		for (int i = 0; i < temArr2.length; i++) {
			sb2.append(temArr2[2 - i]);
		}

		String temp1 = sb1.toString();
		String temp2 = sb2.toString();
		
		if (Integer.parseInt(temp1) > Integer.parseInt(temp2)) {
			System.out.println(sb1);
		} else {
			System.out.println(sb2);
		}

	}
}

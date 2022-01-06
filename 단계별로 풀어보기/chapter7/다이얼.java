import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int sum = 0;
		String alpha = scanner.nextLine(); // 알파벳을 입력받는다
		scanner.close();
		String[] arr = new String[alpha.length()];

		for (int i = 0; i < alpha.length(); i++) {
			arr[i] = alpha.substring(i, i + 1);
		}

		for (int j = 0; j < arr.length; j++) {
			switch (arr[j]) {
			case "A": case "B": case "C":
				sum += 3;
				break;
			case "D": case "E": case "F":
				sum += 4;
				break;
			case "G": case "H": case "I":
				sum += 5;
				break;
			case "J": case "K": case "L":
				sum += 6;
				break;
			case "M": case "N": case "O":
				sum += 7;
				break;
			case "P": case "Q": case "R": case "S":
				sum += 8;
				break;
			case "T": case "U": case "V":
				sum += 9;
				break;
			case "W": case "X": case "Y": case "Z":
				sum += 10;
				break;
			}
		}

		System.out.println(sum);
	}
}

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();

		int count0 = 0, count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0,
				count9 = 0;

		String sum = Integer.toString(A * B * C);
		String[] arr = new String[sum.length()];

		for (int i = 0; i <= sum.length() - 1; i++) {
			arr[i] = sum.substring(i, i + 1);
		}
		
		for (int j = 0; j <= arr.length - 1; j++) {
			if (Integer.parseInt(arr[j]) == 0) {
				count0++;
			} else if (Integer.parseInt(arr[j]) == 1) {
				count1++;
			} else if (Integer.parseInt(arr[j]) == 2) {
				count2++;
			} else if (Integer.parseInt(arr[j]) == 3) {
				count3++;
			} else if (Integer.parseInt(arr[j]) == 4) {
				count4++;
			} else if (Integer.parseInt(arr[j]) == 5) {
				count5++;
			} else if (Integer.parseInt(arr[j]) == 6) {
				count6++;
			} else if (Integer.parseInt(arr[j]) == 7) {
				count7++;
			} else if (Integer.parseInt(arr[j]) == 8) {
				count8++;
			} else if (Integer.parseInt(arr[j]) == 9) {
				count9++;
			}
		}

		System.out.println(count0);
		System.out.println(count1);
		System.out.println(count2);
		System.out.println(count3);
		System.out.println(count4);
		System.out.println(count5);
		System.out.println(count6);
		System.out.println(count7);
		System.out.println(count8);
		System.out.println(count9);

		scanner.close();
	}
}

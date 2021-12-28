import java.util.Scanner;

public class Main {
	@SuppressWarnings("null")
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		/*
		 * int hour = in.nextInt(); int minute = in.nextInt(); int ahour = 0;
		 */

		/*
		 * if (hour == 0) { ahour = 24 * 60; } else { ahour = hour * 60; }
		 * 
		 * int totalMinute = ahour + minute - 45; // 창영이가 원하는 알람 시간
		 * 
		 * System.out.println(totalMinute / 60 + " " + totalMinute % 60);
		 */
		int n = scanner.nextInt();
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + i;
		}
		
		System.out.println(sum);
		scanner.close();
	}
}

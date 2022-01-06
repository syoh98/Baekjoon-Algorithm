import java.util.*;

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
		int A = 0, B = 0;
		int test = scanner.nextInt();
		int arr[] = new int[test];
		
		
		for (int i = 0; i < test; i++) {
			A = scanner.nextInt();
			B = scanner.nextInt();
			
			arr[i] =  A + B;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		scanner.close();
	}
}

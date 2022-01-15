import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int year = in.nextInt();

		in.close();

		// 윤년일 경우
		if ((int) year % 4 == 0) {
			// 100의 배수가 아닐 때 또는 400의 배수일 때
			if ((int) year % 100 != 0 || (int) year % 400 == 0) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
		// 윤년이 아닐 경우
		else {
			System.out.println("0");
		}
	}
}

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int A = in.nextInt();

		in.close();

		if (90 <= A && A <= 100) {
			System.out.println("A");
		} else if (80 <= A && A < 90) {
			System.out.println("B");
		} else if (70 <= A && A < 80) {
			System.out.println("C");
		} else if (60 <= A && A < 70) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}
}

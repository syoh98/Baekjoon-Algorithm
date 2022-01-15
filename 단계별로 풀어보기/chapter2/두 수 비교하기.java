import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
                StringBuilder sb = new StringBuilder();

		int A = in.nextInt();
		int B = in.nextInt();

		in.close();

		if (A > B) {
                        sb.append(">");
		} else if (A < B) {
                        sb.append("<");
		} else {
                        sb.append("==");
		}

                System.out.println(sb);
	}
}

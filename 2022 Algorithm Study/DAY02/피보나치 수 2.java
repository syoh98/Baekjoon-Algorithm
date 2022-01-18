import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static long fibo[] = new long[91];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		fibo[0] = 0;
		fibo[1] = 1;

		for (int i = 2; i <= n; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}

		System.out.println(fibo[n]);
	}
}

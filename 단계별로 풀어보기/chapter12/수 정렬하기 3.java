import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int[] numList = new int[N];

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			numList[i] = temp;
		}
		br.close();
		Arrays.sort(numList);

		for (int i = 0; i < N; i++) {
			sb.append(numList[i] + "\n");
		}

		System.out.println(sb);
	}
}

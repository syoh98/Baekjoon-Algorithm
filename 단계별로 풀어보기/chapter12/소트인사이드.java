import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<Integer>();

		String N = br.readLine(); // 2143

		for (int i = 0; i < N.length(); i++) {
			String temp = N.substring(i, i + 1);
			list.add(Integer.parseInt(temp));
		}
		Collections.sort(list, Collections.reverseOrder());

		for (int i = 0; i < N.length(); i++) {
			sb.append(list.get(i));
		}
		
		System.out.println(sb);
	}
}

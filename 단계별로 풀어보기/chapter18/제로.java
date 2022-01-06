import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;

		int K = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < K; i++) {
			int temp = Integer.parseInt(br.readLine());

			if (temp == 0) {
				list.remove(list.size() - 1);
				//list.add(temp);
			}
			else {
				list.add(temp);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		System.out.println(sum);
	}
}

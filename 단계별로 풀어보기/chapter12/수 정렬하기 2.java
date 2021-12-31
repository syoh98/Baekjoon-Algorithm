import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		StringBuilder sb = new StringBuilder();

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(scanner.nextInt());
		}

		Collections.sort(list);

		for (int value : list) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
	}
}

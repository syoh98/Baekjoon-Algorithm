import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		HashSet<Integer> hs = new HashSet<Integer>();
		int countSame = 0;

		// 수 10개를 입력 받는다 && 이를 42로 나눈 나머지를 구한다 => 배열에 저장
		for (int i = 0; i <= 9; i++) {
			hs.add(scanner.nextInt() % 42);
		}
		scanner.close();
		System.out.println(hs.size());
	}
}

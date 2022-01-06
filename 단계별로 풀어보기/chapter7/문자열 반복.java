import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int testcase = scanner.nextInt(); // 테스트케이스
		String arr[] = new String[testcase];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < testcase; i++) {
			int R = scanner.nextInt(); // R번 반복
			String S = scanner.next(); // 문자열

			for (int j = 0; j < S.length(); j++) {
				char str = S.charAt(j);
				for (int k = 0; k < R; k++) {
					//System.out.println(str);
					sb.append(str);
				}
			}
			arr[i] = sb.toString();
			sb.setLength(0); // sb 비우기
		}

		for (int i = 0; i < testcase; i++) { //출력
			System.out.println(arr[i]);
		}
	}
}

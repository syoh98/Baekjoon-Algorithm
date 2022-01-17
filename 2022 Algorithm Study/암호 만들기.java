package P1759;

import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static String[] arr;
	static ArrayList<String> result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String strNum = br.readLine();
		StringTokenizer st1 = new StringTokenizer(strNum);

		L = Integer.parseInt(st1.nextToken()); // 4
		C = Integer.parseInt(st1.nextToken()); // 6

		arr = new String[C]; // 6 크기의 배열
		result = new ArrayList<String>();

		String strAlpha = br.readLine();
		StringTokenizer st2 = new StringTokenizer(strAlpha);

		for (int i = 0; i < C; i++) {
			arr[i] = st2.nextToken(); // a t c i s w
		}
		Arrays.sort(arr); // a c i s t w

		dfs(0, 0, 0, -1, "");

		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) + "\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int length, int ja, int mo, int current, String pwd) { // 몇글자까지 왔는지, 자음, 모음, 현재의 위치, 히스토리
		// 1. 체크인 - 생략가능
		// 2. 목적지인가? - L길이만큼 + 자음, 모음 개수 조건
		if (length == L) { // 목적지 도착
			if (ja >= 2 && mo >= 1) {
				result.add(pwd);
			}
		} else {
			// 3. 연결된 곳을 순회 - 나보다 높은 알파벳
			for (int nextIndex = current + 1; nextIndex < arr.length; nextIndex++) {
				String nextData = arr[nextIndex];
				// 4. 갈 수 있는가? - 생략 가능
				if (nextData.equals("a") || nextData.equals("e") || nextData.equals("i") || nextData.equals("o")
						|| nextData.equals("u")) {
					// 5. 간다 -> 모음
					dfs(length + 1, ja, mo + 1, nextIndex, pwd + nextData);
				} else {
					// 5. 간다 -> 자음
					dfs(length + 1, ja + 1, mo, nextIndex, pwd + nextData);
				}
			}
		}
		// 6. 체크아웃 - 생략가능
	}
}

package P1759;

import java.io.*;
import java.util.*;

/*[문제조건]
    1. 서로 다른 L개의 알파벳으로 구성, 문자의 개수 C개
    2. 최소 한 개의 모음, 최소 2개의 자음으로 구성
    3. 암호 오름차순으로 구성됨(abc..)
  [풀이 전 생각]
    1. 암호는 오름차순으로 구성된다 -> 입력받을 때 미리 정렬을 하는 것이 효율적
    2. 따라서 아래노드에서 위의 노드로 방문하지 않아도 되고, 체크인/체크아웃 과정 생략이 가능하다
    3. DFS방법으로 풀이
*/
public class Main {
	static int L, C;
	static StringTokenizer st;
	static String[] list; // 입력받은 문자를 저장하기 위한 배열
	static ArrayList<String> result; // 조건에 맞는 암호를 저장할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		result = new ArrayList<String>();

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); // 4
		C = Integer.parseInt(st.nextToken()); // 6

		list = new String[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			list[i] = st.nextToken(); // a t c i s w
		}
		Arrays.sort(list); // 1번 과정(a c i s t w)

		dfs(0, 0, 0, -1, "");

		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) + "\n");
		}

		System.out.println(sb);
	}

	public static void dfs(int length, int ja, int mo, int current, String history) {
		// 1. 목적지인가?[L까지 옴, (1개의 모음, 2개의 자음)]
		if (length == L) { // 목적지 도착
			if (mo >= 1 && ja >= 2) {
				result.add(history);
			}
		} else {
			// 2. 연결된 곳을 순회(오름차순으로 나보다 뒤에 나오는 알파벳)
			for (int nextIndex = current + 1; nextIndex < list.length; nextIndex++) {
				String nextData = list[nextIndex]; // a
				if (nextData.equals("a") || nextData.equals("e") || nextData.equals("i") || nextData.equals("o")
						|| nextData.equals("u")) {
					dfs(length + 1, ja, mo + 1, nextIndex, history + nextData);
				} else {
					dfs(length + 1, ja + 1, mo, nextIndex, history + nextData);
				}
			}
		}
	}
}

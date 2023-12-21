import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 문자열 입력
// 2. 문자열에 대해 중복 제거 후 출력
// 중복이 제거된 문자열은 순서를 유지
// ksekkset -> kset
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String str = br.readLine();
			ArrayList<String> answer = new ArrayList<String>();
			int[] check = new int[123];
			
			// 초기화
			for(int i=0; i<check.length; i++) {
				check[i] = 0;
			}
			
			// check
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				
				if(check[(int)c] == 0) {
					answer.add(Character.toString(c));
					check[(int)c] = 1;
				}
			}
			
			for(int i=0; i<answer.size(); i++) {
				System.out.print(answer.get(i));
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

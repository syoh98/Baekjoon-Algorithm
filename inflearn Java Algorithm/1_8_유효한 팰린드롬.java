import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 해당 문자열이 팰린드롭이면 "YES"출력, 아니면 "NO"출력
// 대소문자 구분하지 않음
// 알파벳 이외의 문자들은 무시
// gooG
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String inputStr = br.readLine().toLowerCase(); // 소문자로 변환
			String originStr = "";
			String reverseStr = "";
			
			for(int i=0; i<inputStr.length(); i++) {
				char c = inputStr.charAt(i);
				if(c >= 97 && c <=122) { // 알파벳이라면
					originStr += Character.toString(c);
				}
			}
			
			StringBuilder sb = new StringBuilder(originStr);
			reverseStr = sb.reverse().toString();

			if(originStr.equals(reverseStr)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

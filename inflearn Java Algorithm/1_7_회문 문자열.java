import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 회문 문자열이면 YES 출력, 아니면 NO 출력
// 길이 100을 넘지 않는 공백이 없는 문자열이 주어짐
// gooG
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			ArrayList<String> reverse = new ArrayList<String>();
			String reverseStr = "";
			String inputStr = br.readLine().toLowerCase(); // 소문자로 변환
			
			for(int i=inputStr.length()-1; i>=0; i--) {
				reverseStr += Character.toString(inputStr.charAt(i));
			}
			
			if(reverseStr.equals(inputStr)) {
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

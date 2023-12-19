import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 문자열을 입력받는다
// 2. 대문자->소문자로 변경, 소문자->대문자로 변경하여 출력하는 프로그램 작성
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer = "";
		
		try {
			String inputStr = br.readLine();
			
			for(int i=0; i<inputStr.length(); i++) {
				char temp = inputStr.charAt(i);
				
				if(Character.isLowerCase(temp)) { // 소문자라면
					answer += Character.toUpperCase(temp);
				} else {
					answer += Character.toLowerCase(temp);
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(answer);
	}
}

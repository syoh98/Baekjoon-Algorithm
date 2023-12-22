import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 문자+숫자열의 문자열이 주어지면, 숫자만 추출
// g0en2T0s8eSoft
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String inputStr = br.readLine().toLowerCase(); // 소문자로 변환
			String answer = "", answer2 = "";
			
			// 알파벳을 제거한 문자열
			answer = inputStr.replaceAll("[a-z]", "");
			int a = Integer.parseInt(answer);
			
			System.out.println(Integer.toString(a));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

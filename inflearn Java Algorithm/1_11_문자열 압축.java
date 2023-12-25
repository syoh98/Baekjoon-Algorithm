import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 알파벳 대문자로 이루어진 문자열을 입력 받음
// 2. 같은 문자가 연속으로 반복되는 경우 반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램
// 반복횟수가 1인 경우 생략
// KSTTTSEEKFKKKDJJGG
// KST3SE2KFK3DJ2G2
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer = "";

		try {
			String input = br.readLine();
			boolean flag = false;
			int cnt = 1;
			
			for(int i=0; i<input.length()-1; i++) {
				char c1 = input.charAt(i), c2 = 0;
				c2 = input.charAt(i+1);
				
				if(flag == true) {
					if(c1 == c2) { // 연속됨
						cnt++;
					} else {
						answer+=Character.toString(c1);
						if(cnt > 1) {
							answer+=Integer.toString(cnt);
							cnt=1;
						}
						flag = false;
					}
				} else {
					if(c1 == c2) { // 연속됨
						cnt++;
						flag = true;
					} else {
						answer+=Character.toString(c1);
						if(cnt > 1) {
							answer+=Integer.toString(cnt);
							cnt = 1;
						}
					}
				}
			}
			
			if(input.charAt(input.length()-2) != input.charAt(input.length()-1)) {
				answer+=Character.toString(input.charAt(input.length()-1));
			} else {
				answer+=Character.toString(input.charAt(input.length()-1));
				answer+= Integer.toString(cnt);
			}
			
			System.out.println(answer);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

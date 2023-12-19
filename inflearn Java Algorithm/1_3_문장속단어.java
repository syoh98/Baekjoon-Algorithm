import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 알파벳 대문자로 구성된 문자열을 받음
// 2. 알파벳 한 문자마다 #또는 *이 7개로 구성되어있음
// 3. #은 1로, *은 0으로 변환(이진수화)
// 4. 2진수 -> 10진수
// 5. 10진수 -> 아스키코드로 변환(영어 대문자)
public class Main {
	public static void sol(String inputCnt, String pw) {
		int cnt = pw.length()/7;
		int num = 0;
		String str = "";

		for(int i=0; i<cnt; i++) {
			str = pw.substring(num, num+7);

			String binaryStr = "";
			num = num+7;
			
			for(int j=0; j<7; j++) {
				char c = str.charAt(j);
				
				if(c == '#') {
					binaryStr+= 1;
				} else {
					binaryStr+= 0;
				}
			}
			int decimal = Integer.parseInt(binaryStr, 2);
			char c = (char)(decimal);
			
			System.out.print(c);
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String inputCnt = br.readLine(); // 보낸 문자의 개수
			String pw = br.readLine(); // 문자 개수의 일곱 배 만큼의 #또는 * 신호
			
			sol(inputCnt, pw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int num = Integer.valueOf(br.readLine());
			
			// 데이터 입력받기
			String[] arr = new String[num];
			String[] ans = new String[num];
			
			for(int i=0; i<num; i++) {
				String str = br.readLine(); // good
				String ansStr = "";
				
				for(int j=0; j<str.length(); j++) {
					ansStr+= Character.toString(str.charAt(str.length()-j-1));
				}
				
				System.out.println(ansStr);
			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 영어 알파벳만 뒤집고, 특수문자는 자기 자리에 그대로 있는 문자열 출력 프로그램
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String str = br.readLine();
			String[] answer = new String[str.length()]; 
			ArrayList<Character> alphaList = new ArrayList<Character>();
			
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				
				if(Character.isAlphabetic(c)) { // 알파벳이라면
					alphaList.add(c);
					answer[i] = " ";
				} else { // 특수문자라면
					answer[i] = Character.toString(c);
				}
			}
			
			for(int j=0; j<answer.length; j++) {
				if(answer[j].equals(" ")) {
					answer[j] = Character.toString(alphaList.get(alphaList.size()-1));
					alphaList.remove(alphaList.size()-1);
				}
			}
			
			for(int j=0; j<answer.length; j++) {
				System.out.print(answer[j]);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

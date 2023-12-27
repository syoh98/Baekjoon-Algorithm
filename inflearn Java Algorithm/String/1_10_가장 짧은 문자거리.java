import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 문자열 s, 문자 t가 주어짐
// 2. s와 t가 떨어진 최소거리를 출력
// 문자열과 문자는 소문자로만 주어짐
// teachermode e -> 1 0 1 2 1 0 1 2 2 1 0
public class Main {
	public static void findChar(String s, String t) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		// s = teachermode
		// t = e
		for(int i=0; i<s.length(); i++) {
			int lIdx = i, mIdx = i, rIdx = i;
			char c = s.charAt(i); // t e a c h e r m o d e
			
			while(true) {
				lIdx--;
				rIdx++;

				if(Character.toString(c).equals(t)) {
					answer.add(0);
					break;
				} else if(lIdx >= 0 && Character.toString(s.charAt(lIdx)).equals(String.valueOf(t))) {
					answer.add(mIdx-lIdx);
					break;
				} else if(rIdx < s.length() && Character.toString(s.charAt(rIdx)).equals(String.valueOf(t))) {
					answer.add(rIdx-mIdx);
					break;
				}
			}
		}
		
		for(int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String s = st.nextToken(); // 문자열
			String t = st.nextToken(); // 문자
			
			findChar(s, t);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

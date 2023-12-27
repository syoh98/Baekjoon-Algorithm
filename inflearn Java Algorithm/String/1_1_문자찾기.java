import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 1. 한 개의 문자열을 입력 받는다
// 2. 특정문자를 입력 받는다.
// 3. 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램 작성.
public class Main {
	  public static int solution(String str, char t) {
		  int answer = 0;
		  str = str.toUpperCase();
		  t = Character.toUpperCase(t);
		  
		  for(int i=0; i<str.length(); i++) {
			  if(str.charAt(i) == t) {
				  answer++;
			  }
		  }
		  return answer;
	  }
	  
	  public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  String str = sc.next();
		  char c = sc.next().charAt(0);
		  System.out.println(solution(str, c));
	  }
}

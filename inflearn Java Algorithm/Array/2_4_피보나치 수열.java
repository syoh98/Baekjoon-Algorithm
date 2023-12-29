import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 피보나치(앞의 2개의 수를 합하여 다음 숫자가 되는 수열) 수열을 출력
// 2. 입력 수만큼 출력
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int N = Integer.parseInt(br.readLine());
			int[] answer = new int[N];
			
			for(int i=0; i<N; i++) {
				if(i == 0 || i == 1) {
					answer[i] = 1;
				} else {
					answer[i] = 0;
				}
			}
			
			for(int i=2; i<N; i++) {
				answer[i] = answer[i-2] + answer[i-1];
			}
			
			for(int a:answer) {
				System.out.print(a + " ");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

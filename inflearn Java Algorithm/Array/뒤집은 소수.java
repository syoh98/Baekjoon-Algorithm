import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. N 입력, N개의 자연수 입력
// 2. 각 자연수를 뒤집어 소수면 출력
public class Main {
	public static boolean isPrime(int num) {
		if(num == 1)
			return false;
		for(int i=2; i<num; i++) {
			if(num%i == 0) { // 소수가 아님
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int N = Integer.parseInt(br.readLine());
			int[] list = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// 1. 뒤집은 자연수를 list 배열에 삽입
			for(int i=0; i<N; i++) {
				String str = st.nextToken();
				StringBuilder sb = new StringBuilder(str);
				int revseNum = Integer.parseInt(sb.reverse().toString());
				
				list[i] = revseNum;
			}
			
			// 2. 소수를 판별하여 출력
			for(int i=0; i<N; i++) {
				if(isPrime(list[i]))
					System.out.print(list[i] + " ");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

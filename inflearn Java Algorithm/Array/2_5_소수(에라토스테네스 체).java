import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. N을 입력
// 2. 1 부터 N까지의 소수의 개수 출력
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int N = Integer.parseInt(br.readLine());
			int[] primeList = new int[N+1];
			int cnt = 0;
			
			// 배열의 값을 모두 0으로 초기화
			for(int i=0; i<=N; i++) {
				primeList[i] = 0;
			}
			
			// 배열의 값이 0인 경우 cnt를 증가, 증가 후 1로 값 변경
			// 반복하면서 0일 경우만 check하면 소수 개수 count 완료
			for(int i=2; i<=N; i++) {
				if(primeList[i] == 0) {
					int temp = 2;
					primeList[i] = 1;
					cnt++;

					while(i*temp < N+1) {
						primeList[i*temp] = 1;	
						temp++;
					}
				}
			}
			
			System.out.println(cnt);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

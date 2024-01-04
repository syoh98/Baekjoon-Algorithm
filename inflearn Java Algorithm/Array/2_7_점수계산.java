import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 연속으로 답을 맞히는 경우 가산점을 계산 후 출력하는 프로그램
// 2. 틀리면 0점, 틀리다가 처음 맞히면 1점, 연속으로 맞히면 맞힌 문제 수만큼 N점
// 문제의 개수 N, 채점결과가 주어짐
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int N = Integer.parseInt(br.readLine());
			int[] list = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int totalScore = 0, score = 0;
			boolean backNum = false;
			
			for(int i=0; i<N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				if(i == 0) { // 처음 문제인 경우
					if(list[i] == 1) { // 맞은 경우
						totalScore++;
						backNum = true;
						score++;
					}
				} else {
					if(list[i] == 1) { // 맞은 경우
						if(backNum == true) { // 연속해서 맞은 경우
							score++;
							totalScore += score;
						} else {
							totalScore++;
							score = 1;
							backNum = true;
						}
					} else { // 틀린 경우
						backNum = false;
						score = 0;
					}
				}
			}
			
			System.out.println(totalScore);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

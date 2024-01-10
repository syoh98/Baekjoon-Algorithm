import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. N 입력
// 2. N*N 격자판 입력
// 3. 상하좌우 숫자보다 큰 숫자는 봉우리 지역
// 봉우리 지경기 몇 개 있는지 알아내는 프로그램
// 격자의 가장자리는 0으로 초기화
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int answer = 0;

		try {
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					boolean flag = true;
					for(int k=0; k < 4; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx>=0 && ny>=0 && nx<N && ny<N) { // 상하좌우 MIN, MAX check
							if(board[nx][ny] >= board[i][j]) {
								flag = false;
								break;
							}
						}
					}
					if(flag) 
						answer++;
				}
			}
			
			System.out.println(answer);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

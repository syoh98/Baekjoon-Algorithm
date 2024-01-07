import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. N 입력
// 2. N*N 격자판 입력
// 3. 행, 열, 대각선 합 중 가장 큰 합 출력
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int MAX = 0;

		try {
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];

			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 1) 행, 열 check
			for(int i=0; i<N; i++) {
				int col = 0, row = 0;
				
				for(int j=0; j<N; j++) {
					col += board[i][j];
					row += board[j][i];
				}
				if(MAX < col) 
					MAX = col;
				if(MAX < row) 
					MAX = row;
			}
			
			
			// 2) 대각선 check
			int dia1 = 0, dia2 = 0;
			for(int i=0; i<N; i++) {
				dia1 += board[i][i];
			}
			if(MAX < dia1)
				MAX = dia1;
			
			for(int i=0, j = N-1; i<N; i++, j--) {
				dia2 += board[i][j];
			}
			if(MAX < dia2) {
				MAX = dia2;
			}
			
			System.out.println(MAX);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

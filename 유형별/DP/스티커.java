
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스의 개수
        int T = Integer.parseInt(br.readLine());
        // 열
        int n;
        int[][] sticker;

        for(int k=0; k<T; k++) {
            n = Integer.parseInt(br.readLine());
            sticker = new int[2][n];

            for(int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(maxScore(sticker, n)).append("\n");

        }

        System.out.print(sb.toString());
    }

    public static int maxScore(int[][] sticker, int n) {
        if (n == 1)
            return Math.max(sticker[0][0], sticker[1][0]);

        int dp[][] = new int[2][n];
        dp[0][0] = sticker[0][0];
        dp[1][0] = sticker[1][0];

        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[1][i-1], (i > 1 ? dp[1][i-2] : 0)) + sticker[0][i];  // 윗줄 스티커
            dp[1][i] = Math.max(dp[0][i-1], (i > 1 ? dp[0][i-2] : 0)) + sticker[1][i];  // 아랫줄 스티커
        }

        return Math.max(dp[0][n-1], dp[1][n-1]);  // 마지막 열에서 최대값 선택
    }
}

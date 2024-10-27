import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];

        dp[1][0] = 1; // 사자를 배치하지 않는 경우
        dp[1][1] = 1; // 왼쪽에만 사자를 배치하는 경우
        dp[1][2] = 1; // 오른쪽에만 사자를 배치하는 경우

        for(int i=2; i<=N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }

        int result = (dp[N][0] + dp[N][1] + dp[N][2]) % 9901;
        System.out.println(result);
    }
}

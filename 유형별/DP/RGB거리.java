import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 집의 수
        int[][] houseList = new int[N][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 3; j++) {
                houseList[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(getMinCost(houseList));
    }

    public static int getMinCost(int[][] houseList) {
        int N = houseList.length;
        int[][] dp = new int[N][3];

        dp[0][0] = houseList[0][0];
        dp[0][1] = houseList[0][1];
        dp[0][2] = houseList[0][2];

        for(int i = 1; i < N; i++) {
            dp[i][0] = houseList[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = houseList[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = houseList[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        return Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
    }
}

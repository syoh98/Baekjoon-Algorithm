class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        int[][] dp = new int[N][N];
        int max = 0;

        dp[0][0] = triangle[0][0];

        for(int i=1; i<N; i++) {
            for(int j=0; j<=i; j++) {
                if(j == 0) { // 맨 앞일 경우
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == i) { // 맨 끝일 경우
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
            }
        }

        for(int i=0; i<N; i++) {
            max = Math.max(max, dp[N-1][i]);
        }

        return max;
    }
}

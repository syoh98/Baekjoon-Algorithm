import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] board = new int[n][n];
        int idx = 1;
        int x = 0, y = 0; // 현재 위치 좌표
        int[] dx = {1, 0, -1}; // 아래, 오른쪽, 대각선 위
        int[] dy = {0, 1, -1};
        int dir = 0; // 이동 방향

        // 배열 초기화
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
        }

        // 삼각형 넓이만큼 수 채우기
        for(int i = 0; i < n*(n+1)/2; i++) {
            board[x][y] = idx++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 경계 벗어나거나 이미 채워진 칸이었을 경우 방향 전환
            if(nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        int[] answer = new int[n*(n+1)/2];
        idx = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[idx++] = board[i][j];
            }
        }

        return answer;
    }
}

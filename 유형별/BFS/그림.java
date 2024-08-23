import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int boardNum = 0;
        int maxArea = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 1 && !visit[i][j]) {
                    boardNum++;
                    int area = bfs(board, visit, i, j);
                    if(area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }


        System.out.println(boardNum);
        System.out.println(maxArea);
    }

    public static int bfs(int[][] board, boolean[][] visit, int startX, int startY) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        visit[startX][startY] = true;

        int area = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            area++;

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length) {
                    if (board[nx][ny] == 1 && !visit[nx][ny]) {
                        queue.add(new int[] {nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }

        return area;
    }
}

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        return bfs(maps, visited, 0, 0);
    }
    
    public static int bfs(int[][] maps, boolean[][] visited, int startX, int startY) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY, 1});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 상대방 진영 도달 시
            if(x == maps.length-1 && y == maps[0].length-1) {
                return distance;
            }

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[] {nx, ny, distance+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int freshOrange = 0;

        Queue<int[]> queue = new LinkedList<>();

        // 썩은 오렌지 queue에 insert
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }

        // 신선한 오렌지가 없는 경우
        if (freshOrange == 0) return 0;

        // 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int minutes = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean rotOccurred = false;

            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx >= 0 && ny >= 0 && nx < row && ny < col && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // 썩은 오렌지로 변경
                        queue.add(new int[]{nx, ny});
                        freshOrange--;
                        rotOccurred = true;
                    }
                }
            }

            if (rotOccurred) minutes++;
        }

        return freshOrange == 0 ? minutes : -1;
    }
}

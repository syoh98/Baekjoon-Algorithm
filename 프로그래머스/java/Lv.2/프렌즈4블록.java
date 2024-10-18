class Solution {
    public int solution(int m, int n, String[] board) {
        String[][] blockBoard = new String[m][n];
        int totalRemoveBlocks = 0;

        // 배열에 문자열을 substring하여 삽입
        for(int i=0; i<m; i++) {
            String str = board[i];
            for(int j=0; j<n; j++) {
                blockBoard[i][j] = str.substring(j, j+1);
            }
        }

        boolean hasMoreBlocks = true;

        while(hasMoreBlocks) {
            boolean[][] visited = new boolean[m][n]; // 방문여부
            hasMoreBlocks = false;
            int removeBlocks = 0;

            // 2*2 블록을 찾아서 방문여부를 확인
            for(int i = 0; i < m-1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    String currentBlock = blockBoard[i][j];

                    if (!currentBlock.equals(" ")
                            && currentBlock.equals(blockBoard[i][j+1])
                            && currentBlock.equals(blockBoard[i+1][j])
                            && currentBlock.equals(blockBoard[i+1][j+1])) {

                        visited[i][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j] = true;
                        visited[i+1][j+1] = true;

                        hasMoreBlocks = true; // 블록을 제거했음을 표시
                    }
                }
            }

            // 2*2 블록 삭제
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(visited[i][j]) {
                        blockBoard[i][j] = " ";
                        removeBlocks++;
                    }
                }
            }

            totalRemoveBlocks += removeBlocks;

            for(int j = 0; j < n; j++) {
                // 아래에서 위로 탐색하면서 블록 내려주기
                for(int i = m-1; i >= 0; i--) {
                    // 현재 칸이 빈 칸이면(삭제된 블록이면)
                    if(blockBoard[i][j].equals(" ")) {
                        // 위의 블록을 찾아서 내려준다.
                        for(int k = i-1; k >= 0; k--) {
                            if(!blockBoard[k][j].equals(" ")) {
                                blockBoard[i][j] = blockBoard[k][j];
                                blockBoard[k][j] = " "; // 위의 블록을 빈 칸으로 set

                                break;
                            }
                        }
                    }
                }
            }
        }

        return totalRemoveBlocks;
    }
}

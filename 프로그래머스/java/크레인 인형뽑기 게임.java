import java.util.*;

class Solution {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> bucket = new ArrayList<Integer>();

        for(int i = 0; i< moves.length; i++){
            int index = moves[i] - 1;
            int boardNum = 0;

            while(boardNum < board.length) {
                if(board[boardNum][index] != 0) {
                    bucket.add(board[boardNum][index]);
                    board[boardNum][index] = 0;

                    if (bucket.size() != 1 && bucket.get(bucket.size() - 2) == bucket.get(bucket.size() - 1)) {
						// 3-1-1. 해당 값을 remove하고 인형의 수를 +2해준다.
						bucket.remove(bucket.size() - 2);
						bucket.remove(bucket.size() - 1);
						answer += 2;
						
						boardNum = 0;
						break;
					} else {
						break;
					}
                }
                else {
					boardNum++;
					continue;
				}
            }
        }
        return answer;
    }
}

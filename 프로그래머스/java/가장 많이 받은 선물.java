import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;
		int board[][] = new int[N][N];
		int[] giftJisu = new int[N];
		int[] total = new int[N];
		int answer = 0;
		
		// board 초기화
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j] = 0;
				if(i == j) {
					board[i][j] = -1;
				}
				giftJisu[i] = 0;
				total[i] = 0;
			}
		}
		
		// board 배열 정의
		for(int i=0; i<gifts.length; i++) {
			String[] temp = gifts[i].split(" ");
			String from = temp[0]; // 준 사람 
			String to = temp[1]; // 받은 사람
			
			int fromIdx = Arrays.asList(friends).indexOf(from);
			int toIdx = Arrays.asList(friends).indexOf(to);
			
			board[fromIdx][toIdx] += 1;
		}
		
		// giftJisu 배열 정의
		for(int i=0; i < N; i++) {
			int fromGift = 0;
			int toGift = 0;
			
			for(int j=0; j < N; j++) {
				fromGift += board[i][j];
				toGift += board[j][i];
			}
			giftJisu[i] = fromGift - toGift;
		}
		
		// --------------------------------
		
		// total 배열 정의
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i != j) {
					if(board[i][j] == 0 && board[j][i] == 0 && board[i][j] != -1) { // 선물을 주고받은 기록이 없는 경우
						// 선물지수가 차이 나는 경우
						if(giftJisu[i] != giftJisu[j]) {
							if(giftJisu[i] > giftJisu[j]) {
								total[i] += 1;
								board[i][j] = -1;
								board[j][i] = -1;
							} else if(giftJisu[i] < giftJisu[j]) {
								total[j] += 1;
								board[i][j] = -1;
								board[j][i] = -1;
							}
						}
						
					} else if(board[i][j] != 0 && i != j && board[i][j] != -1) {// 선물을 주고받은 기록이 있는 경우
						if(board[i][j] > board[j][i]) {
							total[i] += 1;
						} else if(board[i][j] == board[j][i]) { // 선물지수가 더 큰 사람에게 total++
							if(giftJisu[i] > giftJisu[j]) {
								total[i] += 1;
								board[i][j] = -1;
								board[j][i] = -1;
							} else if(giftJisu[i] < giftJisu[j]) {
								total[j] += 1;
								board[i][j] = -1;
								board[j][i] = -1;
							}
						}
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			if(total[i] > answer) {
				answer = total[i];
			}
		}
		
		return answer; // 다음 달에 가장 많은 선물을 받는 친구가 받을 선물의 수
		
    }
}

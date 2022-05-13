import java.util.*;

class Solution {
    public int[] solution(int[] lotto, int[] win_num) {
        int correct = 0; // 사용자 번호 중 당첨된 번호
        int zeroNum = 0; // 알아 볼 수 없는 숫자
        ArrayList<Integer> lottos = new ArrayList<Integer>(); // 사용자가 뽑은 번호
        ArrayList<Integer> win_nums = new ArrayList<>(); // 당첨번호
        int[] answer = new int[2];
        
        for(int i = 0; i < lotto.length; i++) {
            lottos.add(lotto[i]);
        }
        
        for(int i = 0; i < win_num.length; i++) {
            win_nums.add(win_num[i]);
        }
        
        		for (int i = 0; i < 6; i++) {
			int userNum = lottos.get(i);

			if (win_nums.contains(userNum)) { // 당첨번호와 사용자가 뽑은 번호가 일치하면
				correct++;
			}

			if (userNum == 0) { // 0이면
				zeroNum++;
			}
		}
        
        int min = 7 - correct;
		int max = 7 - (correct + zeroNum);
		
		if(min == 7) { // 로또 당첨 번호가 하나도 일치하는게 없는 경우
			min = 6;
		}
		if(max == 7) {
			max = 6;
		}

		answer[0] = max;
		answer[1] = min;
        
        return answer;
    }
}

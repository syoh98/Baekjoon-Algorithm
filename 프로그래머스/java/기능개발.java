import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        ArrayList<Integer> list = new ArrayList<Integer>();

        // answer 배열에 각각 일의 수를 삽입
        for (int i = 0; i < progresses.length; i++) {
			int cnt = 0;

			while (progresses[i] < 100) {
				progresses[i] += speeds[i];
				cnt++;
			}
			answer[i] = cnt;
		}

        for (int i = 0; i < answer.length; i++) {
			int current = answer[i];
			int cnt = 1;

            // 건너뛰도록
			if (current < 0) {
				continue;
			}

			for (int j = i + 1; j < answer.length; j++) {
				int next = answer[j];
				if (current >= next) {
					answer[j] = -1;
					cnt++;
				} else {
					break;
				}
			}
			list.add(cnt);	
		}
        return list;
    }
}

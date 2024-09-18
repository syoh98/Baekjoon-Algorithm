import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        int printNum = 0;

        // 1. {인덱스, 우선순위} 저장
        for(int i=0; i<priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }

        // 2. 현재 프로세스보다 우선순위가 높은 프로세스가 있는지 큐에 있는 모든 문서들과 비교
        while(!queue.isEmpty()) {
            int[] current = queue.remove();
            boolean hasHigherPriority = false;

            for(int[] q : queue) {
                // 3. 현재 프로세스보다 우선순위가 더 높은 프로세스가 있을 경우
                if(q[1] > current[1]) {
                    hasHigherPriority = true;
                    break;
                }
            }

            // 3-1. 다시 큐에 추가
            if(hasHigherPriority) {
                queue.add(current);
            } else { // 3-2. 출력
                printNum++;
                if(current[0] == location) {
                    return printNum;
                }
            }
        }

        return -1;
    }
}

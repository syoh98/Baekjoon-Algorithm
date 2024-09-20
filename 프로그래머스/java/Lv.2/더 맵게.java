import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;

        for(int s : scoville) {
            queue.add(s);
        }

        while(K > queue.peek()) {
            if(queue.size() < 2) {
                return -1;
            }
            int firstNum = queue.poll();
            int secondNum = queue.poll();

            queue.add(firstNum + (secondNum*2));
            answer++;
        }

        return answer;
    }
}

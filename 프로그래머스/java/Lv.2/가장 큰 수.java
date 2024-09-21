import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numberStr = new String[numbers.length];
        String answer = "";

        for(int i=0; i<numbers.length; i++) {
            numberStr[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(numberStr, (a, b) -> (b+a).compareTo(a+b));
        
        // 모든 숫자가 0인 경우
        if(numberStr[0].equals("0")) {
            return "0";
        }

        for(String num : numberStr) {
            answer += num;
        }

        return answer;
    }
}

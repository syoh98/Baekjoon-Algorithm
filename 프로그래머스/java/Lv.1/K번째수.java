import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int x = 0; x < commands.length; x++) {
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];

            int[] list = new int[j-i+1];

            // 1. array 자르기
            for(int y = 0; y < list.length; y++) {
                if(i > j) {
                    break;
                }
                list[y] = array[i-1];
                i++;
            }

            // 2. 1에서 나온 배열 정렬하기
            Arrays.sort(list);

            // 3. 2에서 나온 k번째 숫자 삽입하기
            answer.add(list[k-1]);
        }

        return answer;
    }
}

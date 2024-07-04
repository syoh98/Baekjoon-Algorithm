import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int sum = 0;
        int cnt = 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
      
        ArrayList<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList, Collections.reverseOrder());
      
        for (int i = 0; i< valueList.size(); i++) {
            if ((sum+valueList.get(i)) >= k) {
                cnt++;
                break;
            } else {
                sum += valueList.get(i);
                cnt++;
            }
        }
        return cnt;
    }
}

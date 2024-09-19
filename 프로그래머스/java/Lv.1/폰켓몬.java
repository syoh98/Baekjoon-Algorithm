import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for(int n : nums) {
            hashSet.add(n);
        }

        if(nums.length/2 < hashSet.size()) {
            return nums.length/2;
        } else {
            return hashSet.size();
        }
    }
}

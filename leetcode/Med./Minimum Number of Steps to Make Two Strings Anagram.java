class Solution {
    public int minSteps(String s, String t) {
        
        // 1. 두 문자 빈도를 저장할 배열을 선언한다.
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        // 2. 두 문자 빈도를 계산한다.
        for(int i=0; i<s.length(); i++) {
            cnt1[s.charAt(i)-'a']++;
        }

        for(int j=0; j<t.length(); j++) {
            String temp = t.substring(j, j+1);
            cnt2[t.charAt(j)-'a']++;
        }

        int result = 0;
        // 3. 빈도의 차이를 계산한다.
        for(int r=0; r<26; r++) {
            if(cnt1[r] > cnt2[r]) {
                result += cnt1[r] - cnt2[r];
            }
        }

        return result;
    }
}

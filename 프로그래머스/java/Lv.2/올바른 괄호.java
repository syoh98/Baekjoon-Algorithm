class Solution {
    boolean solution(String s) {
        int frontNum = 0, backNum = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.substring(i, i+1).equals("(")) {
                frontNum++;
            } else {
                backNum++;
            }
            
            if(frontNum < backNum) {
                return false;
            }
        }

        if(frontNum == backNum) {
            return true;
        } else {
            return false;
        }
    }
}

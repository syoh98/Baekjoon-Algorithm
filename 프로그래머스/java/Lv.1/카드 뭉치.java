class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cards1Idx = 0, cards2Idx = 0;

        for (String word : goal) {
            if (cards1Idx < cards1.length && word.equals(cards1[cards1Idx])) {
                cards1Idx++;
            } else if (cards2Idx < cards2.length && word.equals(cards2[cards2Idx])) {
                cards2Idx++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}

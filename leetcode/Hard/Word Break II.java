class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        backTrack(s, wordDict, new ArrayList<>(), result);

        return result;
    }

    public static void backTrack(String s, List<String> wordDict, List<String> tempList, List<String> result) {

        // 현재 조합을 result에 추가
        if(s.isEmpty()) {
            StringBuilder sb = new StringBuilder();

            for(int i=0; i< tempList.size(); i++) {
                if(i == tempList.size()-1) {
                    sb.append(tempList.get(i));
                } else {
                    sb.append(tempList.get(i)).append(" ");
                }
            }
            result.add(sb.toString());

            return;
        }

        for(String word: wordDict) {
            if(s.startsWith(word)) { // 문자열이 단어 사전에 있는 단어로 시작하면
                tempList.add(word); // 현재 문자열 추가
                backTrack(s.substring(word.length()), wordDict, tempList, result); // 재귀
                tempList.remove(tempList.size()-1); // 되돌리기
            }
        }
    }
}

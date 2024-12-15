class Solution {
    public int compress(char[] chars) {
        int i = 0, write = 0;

        while(i < chars.length) {
            char current = chars[i];
            int cnt = 0;

            // 같은 문자의 길이를 계산
            while(i < chars.length && chars[i] == current) {
…                for(char cntChar : cntString.toCharArray()) {
                    chars[write++] = cntChar;
                }
            }
        }

        return write;
    }
}

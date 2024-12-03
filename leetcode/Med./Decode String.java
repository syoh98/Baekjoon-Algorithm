class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> stringStack = new Stack<Character>();
        int num = 0;

        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) { // 숫자라면
                num = num * 10 + (ch - '0');
            } else if(ch == '[') { // 스택에 값 삽입하기
                numStack.add(num);
                num = 0;

                stringStack.add(ch); // 마찬가지로 [도 삽입
            } else if(ch == ']') { // 스택에 있는 값을 꺼내기
                StringBuilder sb = new StringBuilder();

                while(!stringStack.isEmpty() && stringStack.peek() != '[') {
                    sb.insert(0, stringStack.pop()); // 앞으로 추가
                }

                if(!stringStack.isEmpty() && stringStack.peek() == '[') {
                    stringStack.pop();
                }

                int repeatTimes = numStack.pop();
                StringBuilder repeatSb = new StringBuilder();

                for(int i=0; i<repeatTimes; i++) {
                    repeatSb.append(sb);
                }

                for(char c : repeatSb.toString().toCharArray()) {
                    stringStack.add(c);
                }
            } else { // 이외의 다른 문자라면
                stringStack.add(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!stringStack.isEmpty()) {
            result.insert(0, stringStack.pop());
        }

        return result.toString();    
    }
}

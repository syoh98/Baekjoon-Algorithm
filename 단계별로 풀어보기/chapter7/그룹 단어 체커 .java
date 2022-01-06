import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int i = 0;
        int n = sc.nextInt(); // 단어 갯수 입력
        int answer = n; // answer에 단어 갯수 대입
        
        for(int test_case = 0; test_case < n; test_case++) {
            String word = sc.next(); // 단어 입력
            boolean[] checker = new boolean[26]; // 체커 배열 선언. 등장한 문자는 true로 변경한다. 
            
            for(i = 1; i < word.length(); i++) { // 단어의 길이만큼 반복
                if(word.charAt(i-1) != word.charAt(i)) { // 현재 문자와 이전 문자가 같지 않다면
                    if(checker[word.charAt(i)-97] == true) { // 현재 문자가 이전에 나온적이 있다면 
                        answer--;            // 그룹단어가 아니므로 answer - 1
                        break;               // 더 이상 확인할 필요가 없으므로 break;
                    }
                    checker[word.charAt(i-1) - 97] = true; // checker 배열의 현재 단어 위치를 true로 변경한다.
                }
            }
        }

        System.out.println(answer);
    }
}

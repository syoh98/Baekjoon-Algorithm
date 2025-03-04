import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String[] words = new String[word.length()];

        for(int i=0; i<word.length(); i++) {
            words[i] = word.substring(i, i + 1);
        }

        System.out.print(palindrome(word, words));
    }

    public static int palindrome(String word, String[] words) {
        for(int j=0; j<words.length; j++) {
            String left, right;
            int i = 0;

            while(true) {
                left = words[i];
                right = words[word.length()-(i+1)];

                if(left.equals(right)) {
                    if((word.length()/2 == i) || (word.length()/2 == word.length()-(i+1))) { // 끝이라면
                        return 1;
                    } else {
                        i++;
                    }
                } else {
                    return 0;
                }
            }
        }
      
        return 0;
    }
}

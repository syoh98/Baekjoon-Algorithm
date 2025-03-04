import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> reverseWords = new ArrayList<String>();

        for(int i=0; i<word.length(); i++) {
            words.add(word.substring(i, i + 1));
            reverseWords.add(word.substring(i, i + 1));
        }
        Collections.reverse(reverseWords);

        System.out.print(palindrome(word, words, reverseWords));
    }

    public static int palindrome(String word, ArrayList<String> words, ArrayList<String> reverseWords) {
        for(int i=0; i<words.size(); i++) {
            if(!words.get(i).equals(reverseWords.get(i))) {
                return 0;
            }
        }

        return 1;
    }
}

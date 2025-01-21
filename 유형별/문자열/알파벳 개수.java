import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] alphabet = new int[26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String words = br.readLine();


        for(int i=0; i<words.length(); i++) {
            char word = words.charAt(i);
            int temp = alphabet[word - '0' - 49]+1;

            alphabet[word - '0' - 49] = temp;
        }

        for(int alpha:alphabet) {
            System.out.print(alpha + " ");
        }
    }
}

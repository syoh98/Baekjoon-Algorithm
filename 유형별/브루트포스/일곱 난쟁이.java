import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heightList = new int[9];
        int num1 = 0, num2 = 0, sum = 0;

        for(int i=0; i<9; i++) {
            heightList[i] = Integer.parseInt(br.readLine());
            sum += heightList[i];
        }

        Arrays.sort(heightList);

        for(int i=0; i<9; i++) {
            for(int j=i+1; j<9; j++) {
                if(sum - heightList[i] - heightList[j] == 100) {
                    num1 = heightList[i];
                    num2 = heightList[j];
                }
            }
        }

        for(int height:heightList) {
            if(height != num1 && height!= num2) {
                System.out.println(height);
            }
        }
    }
}

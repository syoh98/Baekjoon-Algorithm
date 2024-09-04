
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        int[] numList = new int[T];

        for(int i=0; i<T; i++) {
            numList[i] = Integer.parseInt(br.readLine()); // numList[i]는 양수이며 11보다 작다
        }

        int[] D = new int[12]; // 최대 11개

        // 초기 값 설정
        D[1] = 1; // 1을 만드는 방법은 1가지
        D[2] = 2; // 2를 만드는 방법은 2가지(1+1, 2)
        D[3] = 4; // 3을 만드는 방법은 4가지(1+1+1, 1+2, 2+1, 3)

        for(int i=4; i<=11; i++) {
            D[i] = D[i-1] + D[i-2] + D[i-3];
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++) {
            sb.append(D[numList[i]]).append("\n");
        }

        System.out.println(sb.toString());
    }
}

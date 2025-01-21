import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cnt = new int[101];
        int start, end, sum = 0;

        // 주차요금
        int A, B, C;
        A = Integer.parseInt(st.nextToken()); // 한 대일 때 주차요금
        B = Integer.parseInt(st.nextToken()); // 두 대일 때 주차요금
        C = Integer.parseInt(st.nextToken()); // 세 대일 때 주차요금

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            for(int j=start; j<end; j++) {
                cnt[j]++;
            }
        }

        for(int r=1; r<100; r++) {
            if(cnt[r] == 1) {
                sum += A;
            } else if(cnt[r] == 2) {
                sum += B*2;
            } else if(cnt[r] == 3) {
                sum += C*3;
            }
        }

        System.out.println(sum);
    }
}

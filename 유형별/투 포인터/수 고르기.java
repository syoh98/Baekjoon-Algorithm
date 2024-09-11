import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] list = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(list);

        System.out.print(getMinGap(list));
    }

    // M 이상이면서 가장 작은 차이를 출력
    public static int getMinGap(int[] list) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;

        while(left < N && right < N) {
            int gap = list[right] - list[left];

            if(gap >= M) {
                min = Math.min(min, gap);
                left++;
            } else {
                right++;
            }

        }

        return min;
    }
}

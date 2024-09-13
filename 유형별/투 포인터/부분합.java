
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] list = new int[N];

        st = new StringTokenizer(br.readLine());

        // 10,000 이하의 자연수로 이루어진 길이 N짜리 수열
        for(int i=0; i<list.length; i++) {
           list[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(getMinLength(list));
    }

    // 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램
    public static int getMinLength(int[] list) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int right=0; right<N; right++) {
            sum += list[right];

            // sum이 S 이상이면 최소 길이 갱신
            // 후 left이동
            while(sum >= S) {
                minLength = Math.min(minLength, right-left+1);
                sum -= list[left];
                left++;
            }
        }

        // 합 만드는 것이 불가능한 경우 0 출력
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}

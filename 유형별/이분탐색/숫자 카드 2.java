import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb  = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); // 숫자카드

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int current = Integer.parseInt(st.nextToken());

            // 처음 등장하는 인덱스
            int firstIdx = lowerBinarySearch(A, current);

            // 마지막에 등장하는 인덱스
            int lastIdx = upperBinarySearch(A, current);

            sb.append(lastIdx-firstIdx + " ");
        }

        System.out.print(sb.toString());
    }

    public static int lowerBinarySearch(int list[], int value) {
        int startIdx = 0;
        int endIdx = list.length;

        while(startIdx < endIdx) {
            int midIdx = (startIdx+endIdx) / 2;

            if(list[midIdx] >= value) {
                endIdx = midIdx;
            } else {
                startIdx = midIdx+1;
            }
        }

        return startIdx;
    }

    public static int upperBinarySearch(int list[], int value) {
        int startIdx = 0;
        int endIdx = list.length;

        while(startIdx < endIdx) {
            int midIdx = (startIdx+endIdx)/2;

            if(list[midIdx] > value) {
                endIdx = midIdx;
            } else {
                startIdx = midIdx+1;
            }
        }

        return endIdx;
    }

}

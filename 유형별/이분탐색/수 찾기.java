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

        N = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int current = Integer.parseInt(st.nextToken());

            int startIdx = 0;
            int endIdx = N;
            int midIdx = N/2;

            System.out.println(binarySearch(startIdx, endIdx, midIdx, current));
        }
    }

    static public int binarySearch(int startIdx, int endIdx, int midIdx, int current) {

        while(startIdx <= endIdx) {
            midIdx = (startIdx + endIdx)/2;

            if(midIdx < 0 || midIdx >= N) {
                return 0;
            }

            if(current > A[midIdx]) {
                startIdx = midIdx+1;

                if(startIdx > N) {
                    return 0;
                }
            } else if(current < A[midIdx]) {
                endIdx = midIdx-1;

                if(endIdx < 0) {
                    return 0;
                }
            } else {
                return 1;
            }
        }

        return 0;
    }
}

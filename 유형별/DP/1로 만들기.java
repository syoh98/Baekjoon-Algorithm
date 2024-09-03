import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.print(getMin(N));
    }

    // queue 왼쪽         오른쪽
    //       더한 결과값   횟수
    public static int getMin(int X) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {X, 0});
        boolean[] visit = new boolean[X+1];
        int total = 0;

        int result = 0;
        int cnt = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            result = current[0];
            cnt = current[1];

            if(result == 1) {
                return cnt;
            }

            if((result/3 > 0) && !visit[result / 3] && (result % 3) == 0) {
                queue.add(new int[] {(result/3), cnt+1});
                visit[result/3] = true;
            }

            if((result/2 > 0) && !visit[result / 2] && (result % 2) == 0) {
                queue.add(new int[] {(result/2), cnt+1});
                visit[result/2] = true;
            }

            if(result-1 > 0 && !visit[result-1]) {
                queue.add(new int[] {(result-1), cnt+1});
                visit[result-1] = true;
            }
        }
        return -1;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited = new boolean[100001]; // 방문여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
        int K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치

        System.out.println(bfs(N, K));
    }

    public static int bfs(int N, int K) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {N, 0});
        visited[N] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int locate = current[0];
            int distance = current[1];

            if(locate == K) {
                return distance;
            }

            int[] nextPositions = {locate-1, locate+1, locate*2};

            for(int position : nextPositions) {
                if(position >= 0 && position < visited.length && !visited[position]) {
                    queue.add(new int[]{position, distance+1});
                    visited[position] = true;
                }
            }
        }

        return -1;
    }
}

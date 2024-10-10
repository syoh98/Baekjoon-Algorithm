import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N]; // 중복 체크
        list = new int[M];

        getSequence(N, M, 0);
    }

    // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    // 수열은 사전 순으로 증가하는 순서로 출력
    public static void getSequence(int N, int M, int depth) {
        StringBuilder sb = new StringBuilder();
        
        // M에 도달했으면
        if(depth == M) {
            for(int i=0; i<M; i++) {
                sb.append(list[i] + " ");
            }
            System.out.println(sb.toString());
            return;
        }

        // M에 도달하지 않았으면
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list[depth] = i+1;

                getSequence(N, M, depth+1);
                visited[i] = false;
            }
        }
    }
}

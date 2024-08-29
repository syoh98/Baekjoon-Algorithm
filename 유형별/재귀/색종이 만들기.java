import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int whitePaper;
    static int bluePaper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(whitePaper);
        System.out.println(bluePaper);
    }

    public static void divide(int x, int y, int size) {
        // 모든 칸이 같은 색이라면
        if(check(x, y, size)) {
            if(paper[x][y] == 0) {
                whitePaper++;
            } else {
                bluePaper++;
            }
        } else {
            int newSize = size/2;
            divide(x, y, newSize); // 왼쪽 위
            divide(x, y + newSize, newSize); // 오른쪽 위
            divide(x + newSize, y, newSize); // 왼쪽 아래
            divide(x + newSize, y + newSize, newSize); // 오른쪽 아래
        }
    }

    public static boolean check(int x, int y, int size) {
        int color = paper[x][y]; // 첫 번째 칸의 색깔(비교의 기준)

        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}

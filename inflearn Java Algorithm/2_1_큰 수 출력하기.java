import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. N을 입력받음
// 2. N개의 정수를 입력 받음
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> numList = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<N; i++) {
				numList.add(Integer.parseInt(st.nextToken()));
			}
			
			System.out.print(numList.get(0) + " ");
			
			for(int j=1; j<N; j++) {
				if(numList.get(j) > numList.get(j-1)) {
					System.out.print(numList.get(j) + " ");
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

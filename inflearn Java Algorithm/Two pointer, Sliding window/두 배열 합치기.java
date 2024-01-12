import java.io.*;
import java.util.*;

// 1. 첫 번째 배열의 크기가 주어짐(N)
// 2. N개의 배열 원소가 오름차순으로 주어짐
// 3. 두 번째 배열의 크기가 주어짐(M)
// 4. M개의 배열 원소가 오름차순으로 주어짐
// 오름차순으로 정렬된 배열을 출력하는 프로그램
public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st1.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<M; i++) {
				list.add(Integer.parseInt(st2.nextToken()));
			}
			
			Collections.sort(list);
			
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

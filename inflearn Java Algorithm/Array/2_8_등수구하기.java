import java.io.*;
import java.util.*;

// 1. 집합 A의 크기가 주어짐(N)
// 2. N개의 원소가 주어짐(중복X)
// 3. 집합 B의 크기가 주어짐(M)
// 4. M개의 원소가 주어짐(중복X)
// 두 집합의 공통원소를 오름차순 정렬하는 프로그램
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
			
			int idx = 0;
			while(true) {
				if(idx < list.size()-1) { // 마지막 인덱스가 아닐 경우
					if(Integer.toString(list.get(idx)).equals(Integer.toString(list.get(idx+1)))) {
						System.out.print(list.get(idx) + " ");
						idx += 2;
					} else {
						idx++;
					}
				} else { // 마지막 인덱스 일 경우
					break;
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

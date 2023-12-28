import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. A, B 두 사람이 가위바위보 게임을 진행
// 2. N: 가위바위보 횟수 / 1: 가위, 2: 바위, 3: 보
// 3. A가 이기면 A를 출력, B가 이기면 B를 출력, 비기는 경우 D를 출력 
public class Main {
	public static String winRsp(int A, int B) {
		String winner = "";
		
		if(A == 1 && B == 3) {
			winner = "A";
		} else if(A == 2 && B == 1) {
			winner = "A";
		} else if(A == 3 && B == 2) {
			winner = "A";
		} else {
			winner = "B";
		}
		
		return winner;
	} 
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> aList = new ArrayList<Integer>();
			ArrayList<Integer> bList = new ArrayList<Integer>();
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<N; i++) {
				aList.add(Integer.parseInt(st1.nextToken()));
				bList.add(Integer.parseInt(st2.nextToken()));
			}
			
			for(int j=0; j<N; j++) {
				int A = aList.get(j);
				int B = bList.get(j);
				
				if(A == B) { // 비기는 경우
					System.out.println("D");
				} else {
					System.out.println(winRsp(A, B));
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

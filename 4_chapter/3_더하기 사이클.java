import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		br.close();
		
		int cycle = 0;
		int result = N; //원래의 수
		
		while(true) {
			N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
			cycle++;
			
			if(result == N) {
				break;
			}
		}
		System.out.println(cycle);
	}
}

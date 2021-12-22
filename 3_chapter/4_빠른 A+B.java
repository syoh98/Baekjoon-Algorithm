import java.io.*;
import java.util.*;

public class Main {
	@SuppressWarnings("null")
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
			}
			
			bw.flush();
			bw.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

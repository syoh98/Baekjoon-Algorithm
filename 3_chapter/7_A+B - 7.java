import java.util.Scanner;

public class Main {
	@SuppressWarnings("null")
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int A = 0, B = 0;
		int test = scanner.nextInt();
		int arr[] = new int[test];
		
		
		for (int i = 0; i < test; i++) {
			A = scanner.nextInt();
			B = scanner.nextInt();
			
			arr[i] =  A + B;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Case #"+ (i+1) + ": " + arr[i]);
		}
		
		
		scanner.close();
	}
}

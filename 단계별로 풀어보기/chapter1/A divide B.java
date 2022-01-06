import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		DecimalFormat form = new DecimalFormat("#.################################");
		
		double sum = 0;

		int a = scanner.nextInt();
		int b = scanner.nextInt();

		sum = (double)a / (double)b;
		
		System.out.println(form.format(sum));

	}
}

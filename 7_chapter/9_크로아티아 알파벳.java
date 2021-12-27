import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		String str[] = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		String st = scanner.nextLine();
		scanner.close();

		for (int i = 0; i < str.length; i++) {
			if (st.contains(str[i]))
				st = st.replace(str[i], "!");
		}
		System.out.println(st.length());
	}
}

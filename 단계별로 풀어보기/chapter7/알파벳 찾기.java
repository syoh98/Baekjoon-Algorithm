import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		String S = scanner.nextLine();
		int ca = -1, cb = -1, cc = -1, cd = -1, ce = -1, cf = -1, cg = -1, ch = -1, ci = -1, cj = -1, ck = -1, cl = -1,
				cm = -1, cn = -1, co = -1, cp = -1, cq = -1, cr = -1, cs = -1, ct = -1, cu = -1, cv = -1, cw = -1,
				cx = -1, cy = -1, cz = -1;
		scanner.close();

		for (int i = 0; i < S.length(); i++) {
			switch (S.charAt(i)) {
			case 'a':
				if (ca == -1) {
					ca = i;
				}
				break;

			case 'b':
				if (cb == -1) {
					cb = i;
				}
				break;
			case 'c':
				if (cc == -1) {
					cc = i;
				}
				break;
			case 'd':
				if (cd == -1) {
					cd = i;
				}
				break;
			case 'e':
				if (ce == -1) {
					ce = i;
				}
				break;
			case 'f':
				if (cf == -1) {
					cf = i;
				}
				break;
			case 'g':
				if (cg == -1) {
					cg = i;
				}
				break;
			case 'h':
				if (ch == -1) {
					ch = i;
				}
				break;
			case 'i':
				if (ci == -1) {
					ci = i;
				}
				break;
			case 'j':
				if (cj == -1) {
					cj = i;
				}
				break;
			case 'k':
				if (ck == -1) {
					ck = i;
				}
				break;
			case 'l':
				if (cl == -1) {
					cl = i;
				}
				break;
			case 'm':
				if (cm == -1) {
					cm = i;
				}
				break;
			case 'n':
				if (cn == -1) {
					cn = i;
				}
				break;
			case 'o':
				if (co == -1) {
					co = i;
				}
				break;
			case 'p':
				if (cp == -1) {
					cp = i;
				}
				break;
			case 'q':
				if (cq == -1) {
					cq = i;
				}
				break;
			case 'r':
				if (cr == -1) {
					cr = i;
				}
				break;
			case 's':
				if (cs == -1) {
					cs = i;
				}
				break;
			case 't':
				if (ct == -1) {
					ct = i;
				}
				break;
			case 'u':
				if (cu == -1) {
					cu = i;
				}
				break;
			case 'v':
				if (cv == -1) {
					cv = i;
				}
				break;
			case 'w':
				if (cw == -1) {
					cw = i;
				}
				break;
			case 'x':
				if (cx == -1) {
					cx = i;
				}
				break;
			case 'y':
				if (cy == -1) {
					cy = i;
				}
				break;
			case 'z':
				if (cz == -1) {
					cz = i;
				}
				break;
			}
		}

		System.out.println(ca + " " + cb + " " + cc + " " + cd + " " + ce + " " + cf + " " + cg + " " + ch + " " + ci
				+ " " + cj + " " + ck + " " + cl + " " + cm + " " + cn + " " + co + " " + cp + " " + cq + " " + cr + " "
				+ cs + " " + ct + " " + cu + " " + cv + " " + cw + " " + cx + " " + cy + " " + cz);
	}
}

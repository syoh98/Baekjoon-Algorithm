package P3955;

import java.io.*;
import java.util.*;

public class Main {
	static int T, K, C;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			long a, b;

			K = Integer.parseInt(st.nextToken()); // 파티에 참가한 명수
			C = Integer.parseInt(st.nextToken()); // 한 봉지에 들어있는 사탕의 개수

			EGResult result = extendedGcd(K, C);

			if (result.r != 1) {
				System.out.println("IMPOSSIBLE");
			} else {
				a = result.s;
				b = result.t;

				b %= K;
				if (b < 0) {
					b += K;
				}
				b = Math.max(b, (K + C) / C);

				if (b <= 1e9) {
					System.out.println(b);
				} else {
					System.out.println("IMPOSSIBLE");
				}
			}
		}

		// X: 인당 나눠줄 사탕의 수
		// Y: 사탕 봉지의 수
		// A * x + 1 = B * y
		// Ax + By = C의 형태로 변환
		// Ax + By = 1
		// A(-x) + By = 1의 형태로 변환

		// 1. 해 검증
		// D = gcd(A, B) = egcd(A, B).r
		// Ax + By = C 일 때 C % D == 0 이어야 해를 가질 수 있음: 베주 항등식
		// C % D != 0 => 해가 없음

		// 1. 초기 해 구하기
		// x0 = s * C / D
		// y0 = t * C / D

		// 3. 일반 해 구하기
		// x = x0 + B / D * k
		// y = y0 - A / D * k

		// 4. k의 범위
		// x < 0
		// x0 + B * k (// D는 1이니까 생략하고 생성)
		// k < - x0 / B (위의 식을 옮겨주면)

		// 0 < y <= 10의 9승(1e9)
		// 0 < y0 - A * k <= 1e9
		// -y0 < -A * k <= 1e9 - y0
		// (y0 - 1e9) / A <= k < y0 / A(음수이기 때문에 나누면 부등호 방향 바뀜)
		// k < - x0 / B(소수점 잃지 않도록 올림하고 -1해야함)

		// 5. 만족하는 k가 있는지 찾고 k를 통해 y를 구한다
	}

	// 확장 유클리드 호제법
	static EGResult extendedGcd(long a, long b) {
		long s0 = 1, t0 = 0, r0 = a;
		long s1 = 0, t1 = 1, r1 = b;

		long temp;
		while (r1 != 0) {
			long q = r0 / r1;

			temp = r0 - q * r1;
			r0 = r1;
			r1 = temp;

			temp = s0 - q * s1;
			s0 = s1;
			s1 = temp;

			temp = t0 - q * t1;
			t0 = t1;
			t1 = temp;
		}
		return new EGResult(s0, t0, r0);
	}
}

class EGResult {
	long s;
	long t;
	long r;

	public EGResult(long s, long t, long r) {
		super();
		this.s = s;
		this.t = t;
		this.r = r;
	}

	@Override
	public String toString() {
		return "EGResult [s=" + s + ", t=" + t + ", r=" + r + "]";
	}
}


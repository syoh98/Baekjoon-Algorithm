import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());
        BigInteger C = new BigInteger(st.nextToken());

        // A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
        System.out.println(modular(A, B, C));
    }

    public static BigInteger modular(BigInteger A, BigInteger B, BigInteger C) {
        // 1. B가 0인경우
        if(B.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        // 2-1. B가 짝수인 경우
        if(B.remainder(BigInteger.TWO).equals(BigInteger.ZERO)) {
            BigInteger half = modular(A, B.divide(BigInteger.TWO), C);
            return half.multiply(half).mod(C);
        } else { // 2-2. B가 홀수인 경우
            return A.multiply(modular(A, B.subtract(BigInteger.ONE), C)).mod(C);
        }
    }
}

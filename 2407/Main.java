import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	
	private static int N;
	private static int M;

	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		BigInteger answer = calcPermutation(N, M);
		answer = answer.divide(calcFactorial(M));
		
		System.out.println(answer.toString());
		
		sc.close();
	}

	private static BigInteger calcPermutation(int n, int r) {
		BigInteger target = new BigInteger(String.valueOf(n));

		for (int i = n - 1, cnt = 1; cnt < r; --i, ++cnt) {
			BigInteger bigI = new BigInteger(String.valueOf(i));
			target = target.multiply(bigI);
		}
		
		return target;
	}
	
	private static BigInteger calcFactorial(int n) {
		BigInteger target = new BigInteger("1");
		
		for (int i = 2; i <= n; ++i) {
			BigInteger bigI = new BigInteger(String.valueOf(i));
			target = target.multiply(bigI);
		}
		
		return target;
	}
}

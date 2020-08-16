import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	
	private static int N;
	private static int K;

	private static int[][] dp = new int[1001][1001];
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		int answer = pascalTriangle(N, K);
		
		System.out.println(answer);
	}
	
	private static int pascalTriangle(int n, int r) {
		if (n == r || r == 0) {
			dp[n][r] = 1;
			return dp[n][r];
		} else if (r == 1) {
			dp[n][r] = n;
			return dp[n][r];
		}
		
		
		if (dp[n][r] == 0) {
			dp[n][r] = pascalTriangle(n - 1, r - 1) + pascalTriangle(n - 1, r);
		}
		
		return dp[n][r];
	}
}

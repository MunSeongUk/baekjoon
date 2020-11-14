import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	private static Scanner sc;
	private static int N;
	private static long[] dp;
	
	
	public static void main(String[] args) throws IOException {
		sc = new Scanner(System.in);
//		sc = new Scanner(new File("input.txt"));
		
		N = sc.nextInt();
		
		dp = new long[2];
		dp[1] = 1;
		
		
		for (int i = 1; i < N; ++i) {
			long cntOfZero = dp[0];
			long cntOfOne = dp[1];
			
			dp[0] = 0;
			dp[1] = 0;
			
			dp[0] = cntOfOne + cntOfZero;
			dp[1] = cntOfZero;
		}
		
		System.out.println(dp[0] + dp[1]);
		
		sc.close();
	}
}

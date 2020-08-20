import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static int T;
	private static int[] dp0;
	private static int[] dp1;
	
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
//		sc = new Scanner(new File("input.txt"));
		
		T = sc.nextInt();
		dp0 = new int[41];
		dp1 = new int[41];
		
		for (int i = 0; i < 41; ++i) {
			dp0[i] = -1;
			dp1[i] = -1;
		}
		
		for (int i = 0; i < T; ++i) {
			int input = sc.nextInt();
			
			fibonacci0(input);
			fibonacci1(input);
			
			System.out.println(dp0[input] + " " + dp1[input]);
		}
		
		sc.close();
	}
	
	private static int fibonacci0(int n) {
		if (n == 0) {
			if (dp0[0] == -1) {
				dp0[0] = 1;
				
				return dp0[0];
			}
		} else if (n == 1) {
			dp0[1] = 0;
			
			return dp0[1];
		}
		
		if (dp0[n] == -1) {
			dp0[n] = fibonacci0(n - 1) + fibonacci0(n - 2);
		}
		
		return dp0[n];
	}
	
	private static int fibonacci1(int n) {
		if (n == 0) {
			if (dp1[0] == -1) {
				dp1[0] = 0;
				
				return dp1[0];
			}
		} else if (n == 1) {
			dp1[1] = 1;
			
			return dp1[1];
		}
		
		if (dp1[n] == -1) {
			dp1[n] = fibonacci1(n - 1) + fibonacci1(n - 2);
		}
		
		return dp1[n];
	}
}
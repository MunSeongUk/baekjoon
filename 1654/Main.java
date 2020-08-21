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
	private static long N, K;
	private static long[] CABLES;
	
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
//		sc = new Scanner(new File("input.txt"));
		
		N = sc.nextLong();
		K = sc.nextLong();
		CABLES = new long[10001];
		
		long max = 0;
		
		for (int i = 0; i < N; ++i) {
			CABLES[i] = sc.nextLong();
			max += CABLES[i];
		}
		
		long left = 0;
		long right = max / K;
		max = 0;
		
		while (left <= right) {
			long mid = (left + right) / 2 == 0 ? 1 : (left + right) / 2;
			long answer = 0;
			
			for (int i = 0; i < N; ++i) {
				answer += CABLES[i] / mid;
			}
			
			if (answer >= K) {
				left = mid + 1;
				if (mid > max) {
					max = mid;
				}
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(max);
		
		sc.close();
	}
}
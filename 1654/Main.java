import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static long N, K;
	private static long[] CABLES;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		N = sc.nextLong();
		K = sc.nextLong();
		CABLES = new long[10001];
		
		long left = 1;
		long right = 0;
		
		for (int i = 0; i < N; ++i) {
			CABLES[i] = sc.nextLong();
			
			if (right < CABLES[i]) {
				right = CABLES[i];
			}
		}
		
		long max = 0;
		
		while (left <= right) {
			long mid = (left + right) / 2;
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
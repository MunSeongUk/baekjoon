import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static int M, N;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		boolean[] tables = new boolean[N + 1];
		
		for (int i = 2; i <= N; ++i) {
			if (tables[i] == false) {
				for (int j = i + i; j <= N; j = j + i) {
					tables[j] = true;
				}
			}
		}
		
		int answer = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = M; i <= N; ++i) {
			if (i != 1 && tables[i] == false) {
				answer += i;
				if (i < min) {
					min = i;
				}
			}
		}
		
		if (min == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(answer);
			System.out.println(min);
		}
		
		sc.close();
	}
}
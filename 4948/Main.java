import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static int n;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		boolean[] isPrime = new boolean[(2 * 123456) + 1];
		
		for (int i = 2; i <= 2 * 123456; ++i) {
			if (isPrime[i] == false) {
				for (int j = i + i; j <= 2 * 123456; j += i) {
					isPrime[j] = true;
				}
			}
		}
		
		while ((n = sc.nextInt()) != 0) {
			int answer = 0;
			
			for (int i = n + 1; i <= 2 * n; ++i) {
				if (i != 1 && isPrime[i] == false) {
					answer++;
				}
			}
			
			System.out.println(answer);
		}
		
		
		sc.close();
	}
}
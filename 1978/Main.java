import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static int N;
	private static int[] arr;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		
		boolean[] tables = new boolean[1001];
		arr = new int[N];
		
		for (int i = 2; i <= 1000; ++i) {
			if (tables[i] == false) {
				for (int j = i + i; j <= 1000; j = j + i) {
					tables[j] = true;
				}
			}
		}
		
		int answer = 0;
		
		for (int i = 0; i < N; ++i) {
			arr[i] = sc.nextInt();
			
			if (arr[i] != 1 && tables[arr[i]] == false) {
				answer++;
			}
		}
		
		
		System.out.println(answer);
		
		sc.close();
	}
}
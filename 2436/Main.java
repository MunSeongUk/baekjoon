import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long gcd = sc.nextInt();
		long lcm = sc.nextInt();
		
		long range = lcm / gcd;
		long A = gcd;
		long B = lcm;
		long sum = A + B;
		long t = 0;
		
		for (long i = 2; i * i < range; ++i) {
			t = range / i;
			if (range % i == 0 && getGcd(i, t) == 1) {
				if ((i + t) * gcd < sum) {
					A = i * gcd;
					B = t * gcd;
				}
			}
		}
		
		
		System.out.println(A + " " + B);
		
		sc.close();
	}
	
	public static long getGcd(long u, long v) {
		while (v != 0) {
			int t = (int) (u % v);
			u = v;
			v = t;
		}
		
		return u;
	}
}

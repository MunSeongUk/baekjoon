import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int u = sc.nextInt();
		int v = sc.nextInt();
		int gcd = getGCD(u, v);
		int lcm = u * v / gcd;
		
		System.out.println(gcd + " "  + lcm);
		
		sc.close();
	}
	
	public static int getGCD(int u, int v) {
		while (u != 0) {
			if (u < v) {
				int t = u;
				u = v;
				v = t;
			}
			
			u = u - v;
		}
		
		return v;
	}
	
	public static int getGCD2(int u, int v) {
		while (v != 0) {
			int t = u % v;
			u = v;
			v = t;
		}
		
		return u;
	}
}

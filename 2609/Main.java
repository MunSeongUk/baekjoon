import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static int T;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		
		int u = sc.nextInt(), v = sc.nextInt();
		int gcd = euclid(u, v);
		System.out.println(gcd + " " + (u * v / gcd));
		
		sc.close();
	}
	
	private static int euclid(int u, int v) {
		int t = 0;
		
		while (v > 0) {
			t = u % v;
			u = v;
			v = t;
		}
		
		return u;
	}
}
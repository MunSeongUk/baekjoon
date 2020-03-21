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
		
		boolean[] primes = new boolean[1000001];
		primes[1] = true;
		initPrimes(primes);
		
		int M = sc.nextInt(), N = sc.nextInt();
		
		for (int i = M; i <= N; ++i) {
			if (primes[i] == false) {
				System.out.println(i);
			}
		}
		
		sc.close();
	}
	
	private static void initPrimes(boolean[] primes) {
		for (int i = 2; i < 1000001; ++i) {
			
			if (primes[i] == true) { continue; }
			
			for (int count = 2, j = i * count; j < 1000001; count++, j = i * count) {
				primes[j] = true;
			}
		}
	}
}
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
	private static int N, M;
	private static int[] SETS;
	private static int[] RANKS;
	
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
//		sc = new Scanner(new File("input.txt"));
		
		N = sc.nextInt();
		
		SETS = new int[N + 1];
		RANKS = new int[N + 1];
		
		M = sc.nextInt();
		
		for (int i = 0; i <= N; ++i) {
			SETS[i] = i;
			RANKS[i] = 1;
		}
		
		for (int i = 0; i < M; ++i) {
			int operation = sc.nextInt();
			int lhs = sc.nextInt();
			int rhs = sc.nextInt();
			
			switch (operation) {
			case 0:
				union(lhs, rhs);
				break;
				
			case 1:
				if (find(lhs) == find(rhs)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
				
				break;
			}
		}
		
		sc.close();
	}
	
	private static void union(int lhs, int rhs) {
		int lParent = find(lhs);
		int rParent = find(rhs);
		
		if (lParent == rParent) {
			return;
		}
		
		if (RANKS[lParent] >= RANKS[rParent]) {
			SETS[rParent] = lParent;
			RANKS[lParent] += RANKS[rParent];
		} else {
			SETS[lParent] = rParent;
			RANKS[rParent] += RANKS[lParent];
		}
	
	}
	
	private static int find(int target) {
		while (SETS[target] != target) {
			target = SETS[target];
		}
		
		return target;
	}
}
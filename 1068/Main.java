import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static int N;
	private static int[][] TREE;
	private static int[] PARENT;
	
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
//		sc = new Scanner(new File("input.txt"));
		
		N = sc.nextInt();
		TREE = new int[N][2];
		PARENT = new int[N];
		
		for (int i = 0; i < N; ++i) {
			TREE[i][0] = -1;
			TREE[i][1] = -1;
		}
		
		for (int i = 0; i < N; ++i) {
			int target = sc.nextInt();
			
			if (target == -1) {
				PARENT[i] = -998;
				continue;
			}
			
			PARENT[i] = target;
			
			if (TREE[target][0] == -1) {
				TREE[target][0] = i;
			} else {
				TREE[target][1] = i;
			}
		}
		
		int delIdx = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(delIdx);
		
		while (!queue.isEmpty()) {
			int target = queue.poll();
			PARENT[target] = -1;
			
			if (TREE[target][0] != -1) {
				queue.add(TREE[target][0]);
			}
			
			if (TREE[target][1] != -1) {
				queue.add(TREE[target][1]);
			}
		}
		
		int[] entryDegree = new int[N];
		
		for (int i = 0; i < N; ++i) {
			if (PARENT[i] == -1) {
				entryDegree[i] = -999;
			} else if (PARENT[i] != -998) {
				entryDegree[PARENT[i]]++;
			}
		}
		
		int answer = 0;
		
		for (int i = 0; i < N; ++i) {
			if (entryDegree[i] == 0) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
		sc.close();
	}
}

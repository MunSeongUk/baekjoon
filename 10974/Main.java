import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	
	private static int[] Arr;
	private static int N;
	private static boolean[] isChecked;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
//		sc = new Scanner(new File("input.txt"));
		
		int N = sc.nextInt();
		Arr = new int[N];
		isChecked = new boolean[N];
		for (int i = 0; i < N; ++i) {
			Arr[i] = i + 1;
		}
		
		perm(new LinkedList<>(), 0);
		
		sc.close();
	}
	
	private static void perm(LinkedList<Integer> list, int r) {
		if (r == Arr.length) {
			for (int item : list) {
				System.out.print(item + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < Arr.length; ++i) {
			if (!isChecked[i]) {
				isChecked[i] = true;
				list.add(Arr[i]);
				perm(list, r + 1);
				list.pollLast();
				isChecked[i] = false;
			}
		}
	}
}

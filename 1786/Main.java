import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
//		sc = new Scanner(new File("input.txt"));
		
		String origin = sc.nextLine();
		String pattern = sc.nextLine();
		
		ArrayList<Integer> target = kmp(origin, pattern);
		
		System.out.println(target.size());
		for (int item : target) {
			System.out.println(item + 1);
		}
		
		sc.close();
	}
	
	private static int[] failureFunction(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		
		for (int i = 1; i < pattern.length(); ++i) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
	
	private static ArrayList<Integer> kmp(String origin, String pattern) {
		ArrayList<Integer> target = new ArrayList<>();
		int[] pi = failureFunction(pattern);
		int n = origin.length();
		int m = pattern.length();
		int j = 0;
		
		for (int i = 0; i < n; ++i) {
			while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			
			if (origin.charAt(i) == pattern.charAt(j)) {
				if (j == m - 1) {
					target.add(i - m + 1);
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		
		return target;
	}
}

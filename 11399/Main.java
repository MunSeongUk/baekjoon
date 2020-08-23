import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static int N;
	
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
//		sc = new Scanner(new File("input.txt"));
		
		N = sc.nextInt();
		int[] people = new int[N];
		
		for (int i = 0; i < N; ++i) {
			people[i] = sc.nextInt();
		}
		
		Arrays.sort(people);
		
		for (int i = 1; i < N; ++i) {
			people[i] = people[i - 1] + people[i];
		}
		int answer = 0;
		for (int item : people) {
			answer += item;
		}
		
		System.out.println(answer);
		
		sc.close();
	}
}
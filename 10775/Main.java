import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static int G;
	private static int P;
	private static int[] listOfGate;
	
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
//		sc = new Scanner(new File("input.txt"));
		
		G = sc.nextInt();
		listOfGate = new int[G + 1];
		for (int i = 1; i <= G; ++i) {
			listOfGate[i] = i;
		}
		
		P = sc.nextInt();
		int answer = 0;
		
		for (int i = 0; i < P; ++i) {
			int start = sc.nextInt();
			int dockingGate = findGate(start);
			
			if (dockingGate == 0) {
				break;
			} else {
				answer++;
				listOfGate[dockingGate]--;
			}
		}
		
		System.out.println(answer);
		
		sc.close();
	}
	
	private static int findGate(int start) {
		while (listOfGate[start] != start) {
			start = listOfGate[start]--;
			
			if (start == 0) {
				break;
			}
		}
		
		return start;
	}
}

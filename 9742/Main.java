import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	
	private static String TARGET;
	private static int IDX, FINISH;
	private static boolean[] isChecked;
	private static boolean isFinished;
	
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
//		sc = new Scanner(new File("input.txt"));
		
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			String[] token = input.split(" ");
			TARGET = token[0];
			FINISH = Integer.valueOf(token[1]);
			IDX = 1;
			isFinished = false;
			isChecked = new boolean[TARGET.length()];
			
			perm(new LinkedList<>(), 0);
			
			if (!isFinished) {
				System.out.println(TARGET + " " + FINISH + " = No permutation");	
			}
		}
		
		sc.close();
	}
	
	private static void perm(LinkedList<Character> list, int r) {
		if (r == TARGET.length()) {
			if (IDX == FINISH) {
				isFinished = true;
				StringBuilder sb = new StringBuilder();
				
				for (char item : list) {
					sb.append(item);
				}
				
				System.out.println(TARGET + " " + FINISH + " = " + sb.toString());
			}
			
			IDX++;
			return;
		}
		
		for (int i = 0; i < TARGET.length(); ++i) {
			if (!isChecked[i]) {
				if (IDX == FINISH + 1) {
					return;
				}
				
				isChecked[i] = true;
				list.add(TARGET.charAt(i));
				perm(list, r + 1);
				list.pollLast();
				isChecked[i] = false;
			}
		}
	}
}

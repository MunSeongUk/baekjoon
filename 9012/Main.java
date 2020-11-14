import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	private static Scanner sc;
	private static int T;
	
	public static void main(String[] args) throws IOException {
		sc = new Scanner(System.in);
//		sc = new Scanner(new File("input.txt"));
		
		T = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 1; tc <= T; ++tc) {
			String input = sc.nextLine();
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < input.length(); ++i) {
				char item = input.charAt(i);
				
				if (item == '(') {
					stack.push(item);
				} else {
					if (stack.isEmpty()) {
						stack.push(item);
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			
			if (stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		
		sc.close();
	}
}

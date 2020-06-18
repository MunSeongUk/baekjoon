import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < input.length(); ++i) {
			char target = input.charAt(i);
			
			if (isCharacter(target)) {
				sb.append(target);
			} else {
				if (stack.isEmpty()) {
					stack.add(target);
				} else {
					if (target == '(') {
						stack.push(target);
					} else if (target == ')') {
						while (stack.peek() != '(') {
							sb.append(stack.pop());
						}
						stack.pop();
					} else if (getPriority(stack.peek()) < getPriority(target)) {
						stack.push(target);
					} else {
						while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(target)) {
							char top = stack.pop();
							sb.append(top);
						}
						stack.push(target);
					}
				}
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
		
		sc.close();
	}
	
	private static int getPriority(char operation) {
		int target = -1;
		
		switch (operation) {
		case '-':
		case '+':
			target = 1;
			break;
			
		case '*':
		case '/':
			target = 2;
			break;
			
		case '(':
			target = 0;
			break;
		}
		
		
		return target;
	}
	
	private static boolean isCharacter(char character) {
		if ('A' <= character && character <= 'Z') {
			return true;
		} else {
			return false;
		}
	}
}

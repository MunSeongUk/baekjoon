import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfOperand = sc.nextInt();
		sc.nextLine();

		String input = sc.nextLine();
		
		double[] mappingOfOperand = new double[numOfOperand];
		
		for (int i = 0; i < numOfOperand; i++) {
			mappingOfOperand[i] = sc.nextInt();
		}
		
		Stack<Double> stack = new Stack<>();
		
		for (int i = 0; i < input.length(); ++i) {
			char target = input.charAt(i);
			
			if (isCharacter(target)) {
				stack.push(mappingOfOperand[target- 'A']);
			} else {
				double rhs = stack.pop();
				double lhs = stack.pop();
				stack.push(doCalc(lhs, rhs, target));
			}
		}
		
		
		System.out.printf("%.2f", stack.pop());
		
		sc.close();
	}
	
	private static double doCalc(double lhs, double rhs, char operation) {
		double target = -1;
		
		switch (operation) {
		case '+':
			target = lhs + rhs;
			break;
			
		case '-':
			target = lhs - rhs;
			break;
			
		case '*':
			target = lhs * rhs;
			break;
			
		case '/':
			target = lhs / rhs;
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

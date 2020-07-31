import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static int N;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
//		sc = new Scanner(new File("input.txt"));
		N = sc.nextInt();
		sc.nextLine();
		char[] list = new char[3];
		Tree tree = new Tree();
		
		for (int i = 0; i < N; ++i) {
			String input = sc.nextLine();
			String[] token = input.split(" ");
			list[0] = token[0].charAt(0);
			list[1] = token[1].charAt(0);
			list[2] = token[2].charAt(0);
			tree.addNode(list[0], list[1], list[2]);
		}
		
		if (tree.root != null) {
			tree.printPreorder(tree.root);
			System.out.println();
			tree.printInorder(tree.root);
			System.out.println();
			tree.printPostorder(tree.root);
			System.out.println();
		}
		
		sc.close();
	}
}

class Tree {
	private class Node {
		public Node left;
		public Node right;
		public char val;
		
		public Node(char val) {
			this.val = val;
		}
	}	
	
	public Node root;
	
	public void addNode(char a, char b, char c) {
		
		if (root == null) {
			root = new Node(a);
			if (b != '.') {
				root.left = new Node(b);	
			}
			
			if (c != '.') {
				root.right = new Node(c);	
			}
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if (cur.val == a) {
				if (b != '.') {
					cur.left = new Node(b);	
				}
				
				if (c != '.') {
					cur.right = new Node(c);	
				}
				
				break;
			}
			
			if (cur.left != null) {
				queue.add(cur.left);
			}
			
			if (cur.right != null) {
				queue.add(cur.right);
			}
		}
	}

	public void printPreorder(Node cur) {
		if (cur == null) {
			return;
		}
		
		System.out.print(cur.val);
		printPreorder(cur.left);
		printPreorder(cur.right);
	}
	
	public void printInorder(Node cur) {
		if (cur == null) {
			return;
		}
		
		printInorder(cur.left);
		System.out.print(cur.val);
		printInorder(cur.right);
	}
	
	public void printPostorder(Node cur) {
		if (cur == null) {
			return;
		}
		
		printPostorder(cur.left);
		printPostorder(cur.right);
		System.out.print(cur.val);
	}
}


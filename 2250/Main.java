import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static int N;
	
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
//		sc = new Scanner(new File("input.txt"));
		N = sc.nextInt();
		Tree tree = new Tree(N);
		
		int root = 0;
		
		for (int i = 1; i <= N; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if (b != -1) {
				root += b;
			}
			
			if (c != -1) {
				root += c;
			}
			
			tree.addNode(a, b, c);
		}
		
		tree.root = ((1 + N) * N/2) - root;
		
		tree.calcLevel(tree.root, 1);
		int maxWidth = 1;
		int minLevel = 1;
		
		for (int i = 2; i <= tree.maxLevel; ++i) {
			int begin = tree.nodes[i][0];
			int end = tree.nodes[i][1];
			int width = end - begin + 1;
			
			if (width > maxWidth) {
				maxWidth = width;
				minLevel = i;
			}
		}
		
		System.out.println(minLevel + " " + maxWidth);
		
		sc.close();
	}
	
}

class Tree {
	public int root;
	public int maxLevel;
	public int[][] nodes;
	private int[][] indiceOfChild;
	private int position;
	private int[] positions;
	
	public Tree(int N) {
		root = -1;
		maxLevel = -1;
		positions = new int[N + 1];
		position = 1;
		indiceOfChild = new int[N + 1][2];
		nodes = new int[N + 1][2];
	}
	
	public void addNode(int a, int b, int c) {
		if (b != -1) {
			indiceOfChild[a][0] = b;	
		}
		
		if (c != -1) {
			indiceOfChild[a][1] = c;
		}
	}
	
	public void calcLevel(int index, int level) {
		if (index == 0) {
			return;
		}
		
		if (maxLevel < level) {
			maxLevel = level;
		}
		
		calcLevel(indiceOfChild[index][0], level + 1);
		positions[index] = position++;
		if (nodes[level][0] == 0) {
			nodes[level][0] = positions[index];
		}
		nodes[level][1] = positions[index];
		calcLevel(indiceOfChild[index][1], level + 1);
	}
}
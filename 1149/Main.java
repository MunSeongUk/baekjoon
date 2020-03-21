import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		
		int N = sc.nextInt();
		int[][] RGB = new int[N][3];
		int R, G, B;
		
		R = sc.nextInt();
		G = sc.nextInt();
		B = sc.nextInt();
		
		RGB[0][0] = R;
		RGB[0][1] = G;
		RGB[0][2] = B;
		
		for (int i = 1; i < N; ++i) {
			R = sc.nextInt();
			G = sc.nextInt();
			B = sc.nextInt();

			RGB[i][0] = Integer.MAX_VALUE;
			RGB[i][1] = Integer.MAX_VALUE;
			RGB[i][2] = Integer.MAX_VALUE;
			
			RGB[i][0] = Math.min(RGB[i - 1][1], RGB[i - 1][2]) + R;
			RGB[i][1] = Math.min(RGB[i - 1][0], RGB[i - 1][2]) + G;
			RGB[i][2] = Math.min(RGB[i - 1][0], RGB[i - 1][1]) + B;
		}
		
		System.out.println(Math.min(Math.min(RGB[N - 1][0], RGB[N - 1][1]), RGB[N - 1][2]));
		
		sc.close();
	}
}
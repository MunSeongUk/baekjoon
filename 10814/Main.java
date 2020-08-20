import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
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
		sc.nextLine();
		
		Person[] people = new Person[N];
		int idx = 0;
		
		for (int i = 0; i < N; ++i) {
			String input = sc.nextLine();
			String[] token = input.split(" ");
			
			people[idx++] = new Person(Integer.valueOf(token[0]),
										token[1]);
		}
		
		divide(people, 0, people.length - 1);
		
		for (Person person : people) {
			System.out.println(person.age + " " + person.name);
		}
		
		sc.close();
	}
	
	private static void divide(Person[] people, int start, int end) {
		if (start >= end) { return; }
		
		int mid = (end - start) / 2 + start;
		divide(people, start, mid);
		divide(people, mid + 1, end);
		
		merge(people, start, mid, end);
	}
	
	private static void merge(Person[] people, int start, int mid, int end) {
		int n1 = mid - start + 1;
		int n2 = end - mid;
		
		Person[] L = new Person[n1];
		Person[] R = new Person[n2];
		
		for (int i = 0; i < n1; ++i) {
			L[i] = new Person(people[start + i]);
		}
		
		for (int j = 0; j < n2; ++j) {
			R[j] = new Person(people[mid + 1 + j]);
		}
		
		int i = 0, j = 0;
		int k = start;
		
		while (i < n1 && j < n2) {
			if (L[i].age <= R[j].age) {
				people[k] = L[i++];
			} else {
				people[k] = R[j++];
			}
			k++;
		}
		
		while (i < n1) {
			people[k++] = L[i++];
		}
		
		while (j < n2) {
			people[k++] = R[j++];
		}
	}
}

class Person {
	public int age;
	public String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public Person(Person source) {
		age = source.age;
		name = source.name;
	}
}
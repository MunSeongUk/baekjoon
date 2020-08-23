import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
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
		ArrayList<Schedule> schedules = new ArrayList<>();
		
		for (int i = 0; i < N; ++i) {
			Schedule schedule = new Schedule(sc.nextInt(), sc.nextInt());
			
			schedules.add(schedule);
		}
		
		schedules.sort(new Comparator<Schedule>() {
			@Override
			public int compare(Schedule o1, Schedule o2) {
				return o1.end == o2.end ? o1.begin - o2.begin : o1.end - o2.end;
			}
		});
		
		int answer = 1;
		int max = schedules.get(0).end;
		
		for (int i = 1; i < schedules.size(); ++i) {
			Schedule schedule = schedules.get(i);
			
			if (schedule.begin >= max) {
				max = schedule.end;
				answer++;
			}
		}
		
		System.out.println(answer);
		
		sc.close();
	}
}

class Schedule {
	public int begin;
	public int end;
	
	public Schedule(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}	
}
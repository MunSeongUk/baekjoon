import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Container con = new Container();
		
		for (int i = 1; i <= N; ++i) {
			con.addNode(i);
		}
		
		con.print(K);
		
		sc.close();
	}

}


class Container {
	public StringBuffer sb;
	
	public Node head;
	public int size;
	
	{
		head = null;
		size = 0;
		sb = new StringBuffer();
	}
	
	public void addNode(int value) {
		if (head == null) {
			head = new Node(value);
			head.next = head;
			head.prev = head;
			size++;
			return;
		}
		
		Node cur = head;
		
		while (cur.next != head) {
			cur = cur.next;
		}
		
		Node newNode = new Node(value);
		newNode.next = head;
		newNode.prev = cur;
		cur.next = newNode;
		head.prev = newNode;
		size++;
		
	}
	
	public void print(int K) {
		sb.append("<");
		
		Node cur = head;
		int step = 1;
		
		while (size > 0) {
			if (step == K) {
				sb.append(cur.value);
				if (size != 1) {
					sb.append(", ");
				} else {
					sb.append(">");
				}

				cur.prev.next = cur.next;
				cur.next.prev = cur.prev;
				cur = cur.next;
				step = 1;
				size--;
			} else {
				cur = cur.next;
				step++;
			}
		}
		
		System.out.println(sb.toString());
	}
}

class Node {
	public int value;
	public Node next;
	public Node prev;
	
	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + value;
	}
	
	
}
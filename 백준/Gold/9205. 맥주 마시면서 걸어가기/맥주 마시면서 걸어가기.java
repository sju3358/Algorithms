import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Node{
		int num;
		int x;
		int y;
		public Node(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	static int T;
	static Node home;
	static Node festival;
	static Node[] store;
	static boolean[] visited;
	static boolean arrived;
	
	public static int getDistance(Node a, Node b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	
	public static void getSolution(Node cur) {
		
		Queue<Node> nextNode = new LinkedList<>();
		nextNode.add(cur);
		
		while(nextNode.isEmpty() != true) {
			Node curNode = nextNode.poll();
			
			if(getDistance(curNode, festival) <= 1000) {
				arrived = true;
				break;
			}
			else {
				for(int i = 0; i < store.length; i++) {
					
					if(visited[store[i].num] == true)
						continue;
					
					if(getDistance(curNode, store[i]) > 1000)
						continue;
					
					visited[store[i].num] = true;
					nextNode.add(store[i]);
				}
			}
		}
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		T = scanner.nextInt();
		
		for(int t = 0; t < T; t++) {
			
			int n = scanner.nextInt();
			store = new Node[n];
			
			int home_x = scanner.nextInt();
			int home_y = scanner.nextInt();
			home = new Node(-1,home_x, home_y);
			
			for(int i = 0; i < n ; i++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				store[i] = new Node(i,x,y);
			}
			
			int festival_x = scanner.nextInt();
			int festival_y = scanner.nextInt();
			festival = new Node(-1,festival_x,festival_y);
			
			
			arrived = false;
			visited = new boolean[n];
			getSolution(home);
			
			if(arrived == true)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
		
		
	}
}
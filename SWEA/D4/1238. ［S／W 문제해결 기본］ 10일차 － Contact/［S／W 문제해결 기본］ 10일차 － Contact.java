import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;



public class Solution {
	
	private static class Node implements Comparable<Node>{
		int cur;
		int length;
		
		public Node(int cur, int length) {
			this.cur = cur;
			this.length = length;
		}

		@Override
		public int compareTo(Node node) {
		
			if(this.length != node.length)
				return node.length - this.length;
			else
				return node.cur - this.cur;
		}
		
		
	}
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int[][] people;
	private static boolean[] visited;
	
	
	private static PriorityQueue<Node> visitedNode;
	
	
	public static void bfs(int start) {
		
		Queue<Node> nextPerson = new LinkedList<>();
		nextPerson.add(new Node(start,0));
		visited[start] = true;
		
		while(nextPerson.isEmpty() != true) {
			Node curPerson = nextPerson.poll();
			
			for(int i = 0; i < 101; i++) {
				
				if(people[curPerson.cur][i] != 1)
					continue;
				if(visited[i] == true) 
					continue;
					
				visited[i] = true;
				Node node = new Node(i,curPerson.length+1);
				nextPerson.add(node);
				visitedNode.add(node);
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		
		for(int t= 1; t<=10; t++) {
			
			people = new int[101][101];
			visited = new boolean[101];
			visitedNode = new PriorityQueue<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			
			int start = Integer.parseInt(st.nextToken());
			
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				people[from][to] = 1;
			}
			
			bfs(start);
			
			System.out.println("#" + t + " " + visitedNode.poll().cur);
		}
	}
	
}
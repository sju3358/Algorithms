import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	
	static ArrayList<ArrayList<Node>> adjList;
	static int[] minLength;
	
	static boolean[] visited;
	
	static class Node implements Comparable<Node>{
		int index;
		int weight;
		
		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	public static void getMinLength(int start) {
		
		PriorityQueue<Node> nextNode = new PriorityQueue<Node>();
		
		minLength[start] = 0;
		nextNode.add(new Node(start,0));
		
		while(nextNode.isEmpty() != true) {
			
			
			Node curNode = nextNode.poll();
			visited[curNode.index] = true;
			
			for(Node node : adjList.get(curNode.index)) {
				if(visited[node.index] == false && minLength[node.index] > minLength[curNode.index] + node.weight) {
					minLength[node.index] = minLength[curNode.index] + node.weight;
					nextNode.add(new Node(node.index, minLength[node.index]));
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		
		
		
		int n, m;
		st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		minLength = new int[n];
		visited = new boolean[n];
		adjList = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i < n; i++) {
			minLength[i] = Integer.MAX_VALUE;
			visited[i] = false;
			adjList.add(new ArrayList<Node>());
		}		
		
		
		int start = Integer.parseInt(br.readLine()) - 1;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			
			adjList.get(from).add(new Node(to,weight));
		}
		
		getMinLength(start);
		
		for(int i = 0; i < minLength.length; i++) {
			if(visited[i] == true)
				System.out.println(minLength[i]);
			else
				System.out.println("INF");
		}
	}
}
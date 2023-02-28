import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	private static class Edge implements Comparable<Edge>{
		int from;
		int to;
		long weight;
		
		public Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			
			if(this.weight < e.weight)
				return -1;
			else if(this.weight == e.weight)
				return 0;
			else 
				return 1;
		}
	}
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int[] vertaxes;
	private static PriorityQueue<Edge> edges;
	
	
	public static void makeSet(int n) {
		vertaxes = new int[n];
		for(int i = 0; i < n; i++)
			vertaxes[i] = i;
	}
	
	public static int findSet(int n) {
		if(vertaxes[n] == n)
			return n;
		else
			return vertaxes[n] = findSet(vertaxes[n]);
	}
	
	public static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot != bRoot) {
			vertaxes[bRoot] = aRoot;
			return true;
		}
		else
			return false;
	}
	
	public static void main(String args[]) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
			for(int t = 1; t <= T; t++) {
			
			int n,m;
			
			long answer = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			makeSet(n);
			
			
			m = Integer.parseInt(st.nextToken());
			edges = new PriorityQueue<>();
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				long weight = Integer.parseInt(st.nextToken());
				edges.add(new Edge(from-1, to-1, weight));
			}
			
			int v = 0;
			while(v < n-1) {
				Edge edge = edges.poll();
				if(unionSet(edge.from,edge.to)) {
					answer += edge.weight;
					v++;
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
}
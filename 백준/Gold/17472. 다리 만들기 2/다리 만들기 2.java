import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Node{
		int i;
		int j;
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	
	
	static PriorityQueue<Edge> edges;
	
	static int[][] map;
	static boolean[][] visited;
	
	
	static int N,M;
 	static int cnt = 0;
	static int[][] dir = {{1, 0},{-1, 0},{0, 1},{0, -1}};
	
	

	static int[] parents;
	
	
	public static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < N && 0 <= j && j < M;
	}
	
	public static void getNodes(int startI, int startJ) {

		if(map[startI][startJ] == 0)
			return;
		
		if(visited[startI][startJ] == true)
			return;
		
		cnt++;
 		Queue<Node> nextNode = new LinkedList<>();
 		
 		
 		map[startI][startJ] = cnt;
 		visited[startI][startJ] = true;
 		nextNode.add(new Node(startI,startJ));
 		
 		while(nextNode.isEmpty() != true) {
 			Node curNode = nextNode.poll();
 			
 			for(int i =0; i <4; i++) {
 				int nextI = curNode.i + dir[i][0];
 				int nextJ = curNode.j + dir[i][1];
 				
 				if(isInBoundary(nextI, nextJ) != true)
 					continue;
 				
 				if(visited[nextI][nextJ] == true)
 					continue;
 				
 				if(map[nextI][nextJ] == 1) {
 					nextNode.add(new Node(nextI,nextJ));
 					map[nextI][nextJ] = cnt;
 					visited[nextI][nextJ] = true;
 				}
  			}
 		}
	}
	
	public static void getEdges(int startI, int startJ) {
		
		if(map[startI][startJ] == 0)
			return;
		
		int curNode = map[startI][startJ];
		int length;
		
		length = 0;
		for(int i = startI + 1; i < N; i++) {
			if(map[i][startJ] == 0)
				length++;
			else {
				if(map[i][startJ] != curNode && length > 1) 
					edges.add(new Edge(curNode,map[i][startJ],length));
				break;
			}
		}
			
		
		length = 0;
		for(int i = startI - 1; i >=0 ; i--) {
			if(map[i][startJ] == 0)
				length++;
			else {
				if(map[i][startJ] != curNode && length > 1) 
					edges.add(new Edge(curNode,map[i][startJ],length));
				break;
			}
		}
		
		length = 0;
		for(int j = startJ + 1; j < M; j++) {
			if(map[startI][j] == 0)
				length++;
			else {
				if(map[startI][j] != curNode && length > 1) 
					edges.add(new Edge(curNode,map[startI][j],length));
				break;
			}
		}
			
		
		length = 0;
		for(int j = startJ - 1; j >= 0; j--) {
			if(map[startI][j] == 0)
				length++;
			else {
				if(map[startI][j] != curNode && length > 1) 
					edges.add(new Edge(curNode,map[startI][j],length));
				break;
			}
		}
	}
	
	
	public static int getParent(int child) {
		if(parents[child] == child) 
			return parents[child];
		else
			return parents[child] = getParent(parents[child]);
	}
	
	public static boolean unionParent(int child1, int child2) {
		int parent1 = getParent(child1);
		int parent2 = getParent(child2);
		
		if(parent1 != parent2) {
			if(parent1 > parent2)
				parents[parent1] = parent2;
			else
				parents[parent2] = parent1;
			return true;
		}
		else
			return false;
	}
	
	public static int getMST() {
		
		int minWeight = 0;
		int cntOfEdge = 0;
		
		while(edges.isEmpty() != true) {
			Edge edge = edges.poll();
			
			if(unionParent(edge.from, edge.to) == true) {
				minWeight += edge.weight;
				cntOfEdge++;
			}
		}
		
		if(cntOfEdge == cnt-1)
			return minWeight;
		else
			return -1;
	}
	
	public static void main(String args[]) {
	
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		map = new int[N][M];
		visited = new boolean[N][M];
		edges = new PriorityQueue<>();
		
		
		
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				map[i][j] = scanner.nextInt();
		
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				getNodes(i,j);
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				getEdges(i,j);
		
		
		parents = new int[cnt+1];
		for(int i = 0; i < parents.length; i++)
			parents[i] = i;
		
		System.out.println(getMST()); 
	}
}
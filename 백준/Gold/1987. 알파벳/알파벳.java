import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	
	static char[][] map;
	static int R,C;
	
	static int maxLength = -1;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean flag = true;
	
	static boolean[] visited = new boolean[26];
	static class Node{
		int i;
		int j;
		int length;
		
		public Node(int i, int j, int length) {
			this.i = i;
			this.j = j;
			this.length = length;
		}
	}
	
	public static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < R && 0 <= j && j < C;
	}
	
	public static void dfs(Node node) {
			
			
			if(maxLength < node.length)
				maxLength = node.length;
			
			for(int i = 0; i < 4; i++) {
				int nextI = node.i + dir[i][0];
				int nextJ = node.j + dir[i][1];
				
				if(isInBoundary(nextI,nextJ) == true) {
					if(visited[map[nextI][nextJ] - 'A'] != true) {
						visited[map[nextI][nextJ] - 'A'] = true;
						dfs(new Node(nextI, nextJ,node.length+1));
						visited[map[nextI][nextJ] - 'A'] = false;
					}
				}
			}
			
			
		
	}
	
	
	public static void main(String args[]) throws IOException {
		
		st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];	
		
		for(int i = 0; i <R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++)
				map[i][j] = input.charAt(j);
 		}
		
		for(int i = 0; i <26; i++)
			visited[i] = false;
		
		visited[map[0][0] - 'A'] = true;
		dfs(new Node(0,0,1));
		
		System.out.println(maxLength);
	}
}
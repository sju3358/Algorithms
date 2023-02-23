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
	
	static boolean[] visited = new boolean[26];

	
	public static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < R && 0 <= j && j < C;
	}
	
	public static void dfs(int curI, int curJ, int curLength) {
			
			
			if(maxLength < curLength)
				maxLength = curLength;
			
			for(int i = 0; i < 4; i++) {
				int nextI = curI + dir[i][0];
				int nextJ = curJ + dir[i][1];
				
				if(isInBoundary(nextI,nextJ) == true) {
					if(visited[map[nextI][nextJ] - 'A'] != true) {
						visited[map[nextI][nextJ] - 'A'] = true;
						dfs(nextI, nextJ, curLength+1);
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
		
		for(int i = 0; i <R; i++) 
			map[i] = br.readLine().toCharArray();
		
		visited[map[0][0] - 'A'] = true;
		dfs(0,0,1);
		
		System.out.println(maxLength);
	}
}
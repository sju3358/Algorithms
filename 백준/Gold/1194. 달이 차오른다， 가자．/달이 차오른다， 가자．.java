import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static char[][] map;
	static boolean[][][] visited;
	
	static int minLength = Integer.MAX_VALUE;
	static boolean arrived = false;
	
	static int dir[][] = new int[][] {{-1,0},{1,0},{0,-1},{0,1}}; 
	
	public static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < N && 0 <= j && j < M;
	}
	
	static class Node{
		int i;
		int j;
		int length;
		int key;
		
		public Node(int i, int j, int length, int key) {
			this.i = i;
			this.j = j;
			this.length = length;
			this.key = key;
		}
	}
	
	public static int getBit(char key) {
		
		if(key == 'a' || key == 'A')
			return 1;
		else if(key == 'b' || key == 'B')
			return 2;
		else if(key == 'c' || key == 'C')
			return 4;
		else if(key == 'd' || key == 'D')
			return 8;
		else if(key == 'e' || key == 'E')
			return 16;
		else if(key == 'f' || key == 'F')
			return 32;
		else
			return 0;
	}
	
	public static void solution(int startI, int startJ) {
		
		
		Queue<Node> nextNode = new LinkedList<>();
		
		nextNode.add(new Node(startI,startJ,0,0));
		visited[startI][startJ][0] = true;
		
		
		while(nextNode.isEmpty() != true) {
			
			Node curNode = nextNode.poll();
			
			if(map[curNode.i][curNode.j] == '1') {
				minLength = Math.min(minLength, curNode.length);
				arrived = true;
				return;
			}else{
				
				for(int i = 0; i < 4; i++) {
					
					int nextI = curNode.i + dir[i][0];
					int nextJ = curNode.j + dir[i][1];
					
					if(isInBoundary(nextI,nextJ) != true)
						continue;
					
					if(visited[nextI][nextJ][curNode.key] == true)
						continue;
		
					if(map[nextI][nextJ] == '#')
						continue;
					
					if('A' <= map[nextI][nextJ] && map[nextI][nextJ] <= 'F') {
						
						if((curNode.key & getBit(map[nextI][nextJ])) == 0) 
							continue;
					} 
					
					int nextKey = curNode.key | getBit(map[nextI][nextJ]);
					visited[nextI][nextJ][nextKey] = true;
					nextNode.add(new Node(nextI,nextJ,curNode.length+1,nextKey));
				}
			}
		}
	}
	
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][128];
		
		int startI = -1, startJ = -1;
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				
				if(map[i][j] == '0') {
					startI = i;
					startJ = j;
				}
			}
		}
		
		
		solution(startI, startJ);
		if(arrived == true)
			System.out.println(minLength);
		else
			System.out.println(-1);
	}
}
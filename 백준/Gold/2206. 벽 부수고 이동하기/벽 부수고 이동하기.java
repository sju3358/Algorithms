import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int i;
		int j;
		int length;
		boolean broken;
		public Node(int i, int j , int length, boolean broken) {
			this.i = i;
			this.j = j;
			this.length = length;
			this.broken = broken;
		}
	}
	
	static int N,M;
	static int map[][];
	static boolean visited[][][];
	static int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
	static boolean arrived;
	
	private static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < N && 0 <= j && j < M;
	}
	
	private static int solution(){
		int minLength = Integer.MAX_VALUE;
		
		Queue<Node> nextNode = new LinkedList<>();
		
		nextNode.add(new Node(0,0,1,false));
		visited[0][0][0] = true;
		
		while(nextNode.isEmpty() != true) {
			Node curNode = nextNode.poll();
			
			if(curNode.i == N-1 && curNode.j == M-1) {
				minLength = Math.min(minLength, curNode.length);
				arrived = true;
			}
			else {
				for(int i = 0; i< 4; i++) {
					int nextI = curNode.i + dir[i][0];
					int nextJ = curNode.j + dir[i][1];
					int nextLength = curNode.length + 1;
					
					if(isInBoundary(nextI, nextJ) != true)
						continue;
					 
					
					if(curNode.broken == false) {
						
						if(map[nextI][nextJ] == 0){
							
							if(visited[nextI][nextJ][0] == true)
								continue;
							
							visited[nextI][nextJ][0] = true;
							nextNode.add(new Node(nextI,nextJ,nextLength,curNode.broken));
						}
						
						if(map[nextI][nextJ] == 1) {
							
							if(visited[nextI][nextJ][1] == true)
								continue;
							
							visited[nextI][nextJ][1] = true;
							nextNode.add(new Node(nextI,nextJ,nextLength,true));
						}
					}
					else {
						if(map[nextI][nextJ] == 0) {
							
							if(visited[nextI][nextJ][1] == true)
								continue;
							
							visited[nextI][nextJ][1] = true;
							nextNode.add(new Node(nextI,nextJ,nextLength,curNode.broken));
						}
					}
					
				}
			}
			
		}
		return minLength;
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int i = 0; i <N; i++) {
			String input = br.readLine().trim();
			for(int j =0; j <M; j++)
				map[i][j] = Integer.parseInt(input.charAt(j) + "");
		}
		
		int length = solution();
		
		if(arrived == true)
			System.out.println(length);
		else
			System.out.println(-1);
	}
}
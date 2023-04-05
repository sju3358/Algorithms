import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	
	static char[][] map;
	static boolean[][] visitedHog;
	static boolean[][] visitedWater;
	
	
	static boolean arrived = false;
	
	
	static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	
	static class Node{
		int i;
		int j;
		int time;
		public Node(int i, int j, int time) {
			this.i = i;
			this.j = j;
			this.time = time;
		}
		public Node(int i, int j) {
			this(i,j,0);
		}
	}
	
	public static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < N && 0 <= j && j < M;
	}
	
	public static int solution(Node start, ArrayList<Node> waters) {
		
		Queue<Node> nextWater = new LinkedList<>();
		Queue<Node> nextHog = new LinkedList<>();
		int minTime = Integer.MAX_VALUE;
		
		for(int i = 0; i < waters.size(); i++) {
			Node water = waters.get(i);
			nextWater.add(new Node(water.i,water.j));
			visitedWater[water.i][water.j] = true;
		}
		
		nextHog.add(new Node(start.i,start.j));
		visitedHog[start.i][start.j] = true;
		
		int curTime = 0;
		
		while(nextWater.isEmpty() != true || nextHog.isEmpty() != true) {
		
			while(nextWater.isEmpty() != true) {
				
				if(nextWater.peek().time != curTime)
					break;
				
				Node water = nextWater.poll();
				
				for(int i = 0; i < 4; i++) {
					int nextI = water.i + dir[i][0];
					int nextJ = water.j + dir[i][1];
					int nextTime = water.time +1;
					
					if(isInBoundary(nextI, nextJ) != true)
						continue;
					
					if(visitedWater[nextI][nextJ] == true)
						continue;
					
					if(map[nextI][nextJ] == 'X' || map[nextI][nextJ] == 'D')
						continue;
					
					map[nextI][nextJ] = '*';
					visitedWater[nextI][nextJ] = true;
					nextWater.add(new Node(nextI,nextJ,nextTime));
				}
			}
			
			while(nextHog.isEmpty() != true) {
				
				if(nextHog.peek().time != curTime)
					break;
				
				Node curHog = nextHog.poll();
				
				if(map[curHog.i][curHog.j] == 'D') {
					arrived = true;
					minTime = Math.min(minTime, curHog.time);
				}
				else {
					for(int i = 0; i <4; i++) {
						int nextI = curHog.i + dir[i][0];
						int nextJ = curHog.j + dir[i][1];
						int nextTime = curHog.time + 1;
						
						if(isInBoundary(nextI, nextJ) != true)
							continue;
						
						if(visitedHog[nextI][nextJ] == true)
							continue;
						
						if(map[nextI][nextJ] == 'X' || map[nextI][nextJ] == '*')
							continue;
						
						visitedHog[nextI][nextJ] = true;
						nextHog.add(new Node(nextI,nextJ,nextTime));
						
					}
				}
			}
			
			curTime++;
		}
		
		
		
		return minTime;
	}
	
	
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," "); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visitedHog = new boolean[N][M];
		visitedWater = new boolean[N][M];
		
		ArrayList<Node> waters = new ArrayList<Node>();
		Node start = null;
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine().trim();
			for(int j = 0; j < M; j++) {
				
				map[i][j] = input.charAt(j);
				
				if(map[i][j] == 'S')
					start = new Node(i,j);
				if(map[i][j] == '*')
					waters.add(new Node(i,j));
			}
		}
		
		int time = solution(start,waters);
		
		if(arrived == true)
			System.out.println(time);
		else
			System.out.println("KAKTUS");
		
	}
}
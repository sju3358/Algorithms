import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	static class Node{
		int i;
		int j;
		char region;
		public Node(int i,int j,char region) {
			this.i = i;
			this.j = j;
			this.region = region;
		}
		public Node(int i, int j) {
			this(i,j,' ');
		}
	}
	
	static Node[] princessList = new Node[7];
	static char[][] map = new char[5][5];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int cnt = 0;
	
	static int cntOfS = 0;
	static int[][] testMap = new int[5][5];
	
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	static {
		try {
			for(int i = 0; i < 5; i++) {
				String input = br.readLine().trim();
				for(int j = 0; j < 5; j++)
					map[i][j] = input.charAt(j);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < 5 && 0 <= j && j < 5;
	}
	
	public static boolean check(int startI, int startJ) {
		
		int count = 0;
		
		boolean[][] visited = new boolean[5][5];
		
		Queue<Node> nextNode = new LinkedList<>();
		
		nextNode.add(new Node(startI,startJ));
		visited[startI][startJ] = true;
		count++;
		
		while(nextNode.isEmpty() != true) {
			Node curNode = nextNode.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextI = curNode.i + dir[i][0];
				int nextJ = curNode.j + dir[i][1];
				
				if(isInBoundary(nextI, nextJ) != true)
					continue;
				
				if(visited[nextI][nextJ] == true)
					continue;
				
				if(testMap[nextI][nextJ] == 0)
					continue;
				
				nextNode.add(new Node(nextI,nextJ));
				visited[nextI][nextJ] = true;
				count++;
			}
		}
		
		
		if(count == 7)
			return true;
		else
			return false;
	}
	
	public static void solution(int cur, int size) {
		if(size == 7) {
			
			if(cntOfS >= 4) {
				
				if(check(princessList[0].i, princessList[0].j) == true)
					cnt++;
			}
		}
		else {
			for(int k = cur; k < 25; k++) {
				int i = k/5;
				int j = k%5;
				
				if(map[i][j] == 'S')
					cntOfS++;
				
				testMap[i][j] = 1;
				princessList[size] = new Node(i,j,map[i][j]);
				solution(k+1,size+1);
				
				testMap[i][j] = 0;
				
				if(map[i][j] == 'S')
					cntOfS--;
				
				
			}
		}
		
	}
	
	public static void main(String args[]) {
		solution(0,0);
		System.out.println(cnt);
	}
}
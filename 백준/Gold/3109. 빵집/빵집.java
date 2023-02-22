import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Node{
	int i;
	int j;
	public Node(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class Main {
	
	static boolean[][] isVisit;
	static char[][] map;
	static int n,m;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int answer = 0;
	static int[] dir_i = {-1, 0,1};
	static int[] dir_j = {1, 1, 1};
	static boolean isArrived;
	static int cnt;
	
	public static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < n && 0 <= j && j < m;
	}
	
	public static void dfs(int curI, int curJ) {
		
		isVisit[curI][curJ] = true;
		
		if(curJ == m-1) {
			isArrived = true;
			answer++;
		}
		else {
			
			for(int i = 0; i <3; i++) {
				int nextI = curI + dir_i[i];
				int nextJ = curJ + dir_j[i];
				
				if(isInBoundary(nextI,nextJ) == true)
					if(isVisit[nextI][nextJ] == false && map[nextI][nextJ] == '.' && isArrived != true) 
						dfs(nextI,nextJ);
					
			}
		}
		
	}
	
	
	public static void main(String args[]) throws IOException {
		
		
		st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		isVisit = new boolean[n][m];
		map = new char[n][m];
		
		for(int i = 0; i <n; i++) {
			String input = br.readLine();
			for(int j = 0; j <m; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for(int i = 0; i <n; i++) {
			isArrived = false;
				dfs(i,0);
		}
		
		System.out.println(answer);
		
	}
}
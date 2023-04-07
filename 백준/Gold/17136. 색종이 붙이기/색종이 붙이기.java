import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	
	static int minCnt = Integer.MAX_VALUE;
	static boolean flag = false;
	
	public static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < 10 && 0 <= j && j < 10;
	}
	
	public static boolean isAnswer(int[][] map) {
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				if(map[i][j] == 1)
					return false;
		return true;
	}
	
	public static boolean check(int start_i, int start_j, int size, int[][] map) {
		
		for(int i = start_i; i < start_i + size; i++) {
			for(int j = start_j; j< start_j + size; j++) {
				if(isInBoundary(i, j) != true)
					return false;
				
				if(map[i][j] == 0)
					return false;
			}
		}
		
		return true;
	}
	
	public static int[][] paste(int start_i, int start_j, int size, int[][] map) {
		for(int i = start_i; i < start_i + size; i++) {
			for(int j = start_j; j< start_j + size; j++) {
				map[i][j] = 0;
			}
		}
		return map;
	}
	
	public static int[][] takeOff(int start_i, int start_j, int size, int[][] map) {
		for(int i = start_i; i < start_i + size; i++) {
			for(int j = start_j; j< start_j + size; j++) {
				map[i][j] = 1;
			}
		}
		return map;
	}

	public static void solution(int i, int j, int[][] map, int numOfPaper[], int cnt) {
		
		if(i == 10)
			return;
		
		if(isAnswer(map) == true) {
			flag = true;
			minCnt = Math.min(minCnt, cnt);
		}
		
		if(map[i][j] == 0) {	
			
			j = j + 1;
			if(j == 10) {
				i = i + 1;
				j = 0;
			}
			
			solution(i,j,map,numOfPaper,cnt);
		}
		else {
			for(int k = 0; k < 5; k++) {
				
				if(numOfPaper[k] == 0)
					continue;
				
				if(check(i,j,k+1,map)) {
					
					numOfPaper[k]--;
					paste(i,j,k+1,map);
					
					solution(i,j,map,numOfPaper,cnt+1);
					
					takeOff(i,j,k+1,map);
					numOfPaper[k]++;
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int map[][] = new int[10][10];
		int numOfPapers[] = {5,5,5,5,5};
		
		
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < 10; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		solution(0,0,map,numOfPapers,0);
		
		if(flag == true)
			System.out.println(minCnt);
		else
			System.out.println(-1);
	}
}
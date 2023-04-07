import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map = new int[10][10];
	static int numOfPaper[] = {5,5,5,5,5};
	
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
	
	public static boolean check(int start_i, int start_j, int size) {
		
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
	
	public static int[][] paste(int start_i, int start_j, int size) {
		for(int i = start_i; i < start_i + size; i++) {
			for(int j = start_j; j< start_j + size; j++) {
				map[i][j] = 0;
			}
		}
		return map;
	}
	
	public static int[][] takeOff(int start_i, int start_j, int size) {
		for(int i = start_i; i < start_i + size; i++) {
			for(int j = start_j; j< start_j + size; j++) {
				map[i][j] = 1;
			}
		}
		return map;
	}

	public static void solution(int i, int j, int cnt) {
		
		if(cnt >= minCnt)
			return;
		
		if(j == 10) {
			solution(i+1,0,cnt);
			return;
		}
		if(i == 10)
			return;

		if(map[i][j] == 0) {	
			solution(i,j+1,cnt);
		}
		else {
			for(int k = 4; k >= 0; k--) {
				
				if(numOfPaper[k] == 0)
					continue;
				
				if(check(i,j,k+1)) {
					
					numOfPaper[k]--;
					paste(i,j,k+1);
					
					if(isAnswer(map) == true) {
						flag = true;
						minCnt = Math.min(minCnt, cnt+1);
					}else
						solution(i,j,cnt+1);
					
					takeOff(i,j,k+1);
					numOfPaper[k]++;
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < 10; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		if(isAnswer(map) == true) {
			flag = true;
			minCnt = 0;
		}else
			solution(0,0,0);
		
		if(flag == true)
			System.out.println(minCnt);
		else
			System.out.println(-1);
	}
}
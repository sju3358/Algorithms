import java.util.Scanner;

public class Solution {
	
	public static boolean isInBoundary(int x, int y, int n) {
		return 0<= x && x < n && 0<= y && y <n;
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for(int test_case = 1; test_case <= T;  test_case++) {
		
			int n = scanner.nextInt();
			
			
			int[][] arr = new int[n][n];
			boolean[][] isVisit = new boolean[n][n];
			
			for(int i = 0; i <n; i++)
				for(int j = 0; j <n; j++)
					isVisit[i][j] = false;
			
			int x = 0; 
			int y = 0;
			
			int dir = 0;
			int[] dirX = {0,1,0,-1};
			int[] dirY = {1,0,-1,0};
			
			int cnt = 1;
			while(cnt <= n*n) {
				
				isVisit[x][y] = true;
				arr[x][y] = cnt++;
				
				
				int nextX = x+dirX[dir];
				int nextY = y+dirY[dir];
				
				if(!isInBoundary(nextX, nextY, n) || isVisit[nextX][nextY]) 
					dir = (dir + 1)%4;
				
				
				x = x + dirX[dir];
				y = y + dirY[dir];
					
			}
			System.out.println("#"+test_case);
			for(int i = 0; i <n; i++) {
				for(int j = 0;j <n; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		}
	}
}
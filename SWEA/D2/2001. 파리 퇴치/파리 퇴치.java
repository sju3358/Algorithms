import java.util.Scanner;

public class Solution {
	
	public static int getDeadFlies(int x, int y, int m, int[][] map) {
		
		int sum = 0;
		for(int i = 0; i <m; i++)
			for(int j = 0; j <m; j++) 
				sum += map[x+i][y+j];
		
		return sum;
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for(int t = 1; t <=T; t++) {
			
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			int[][] map = new int[n][n];
			
			for(int i = 0; i <n; i++)
				for(int j = 0; j <n; j++)
					map[i][j] = scanner.nextInt();
			
			int max = -1;
			
			for(int i = 0; i <= n-m; i++) 
				for(int j = 0; j <= n-m; j++) {
					int sum = getDeadFlies(i,j,m,map);
					if(max < sum)
						max = sum;
				}
			System.out.printf("#%d %d",t,max);
			System.out.println();
		}
		
	}
}
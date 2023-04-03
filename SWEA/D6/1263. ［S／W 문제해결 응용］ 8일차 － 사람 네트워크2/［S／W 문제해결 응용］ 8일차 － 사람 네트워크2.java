import java.util.Scanner;

public class Solution {
	
	static int T;
	
	static int[][] map;
	static int[][] lengths;
	
	public static void getLengths() {
		
		for(int i = 0; i < lengths.length; i++)
			for(int j = 0; j < lengths.length; j++)
				for(int k = 0; k < lengths.length; k++) {
					
					if(lengths[i][k] == -1 || lengths[k][j] == -1)
						continue;
					
					lengths[i][j] = Math.min(lengths[i][j], lengths[i][k] + lengths[k][j]);
				}
	}
	
	public static int solution() {
		int minSum = Integer.MAX_VALUE;
		
		getLengths();
		
		for(int i = 0; i < lengths.length; i++){
			int sum = 0;
			for(int j = 0; j < lengths.length; j++) {
				sum += lengths[i][j];
			}
			minSum = Math.min(minSum, sum);
		}
		
		return minSum;
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		T = scanner.nextInt();
		
		for(int t = 0; t < T; t++) {
			
			int N = scanner.nextInt();
			
			map = new int[N][N];
			lengths = new int[N][N];
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					map[i][j] = scanner.nextInt();
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++) {
					
					if(i == j)
						lengths[i][j] = 0;
					else {
						if(map[i][j] != 0)
							lengths[i][j] = map[i][j];
						else
							lengths[i][j] = 10001;
					}
				}
			
			System.out.println("#" + (t+1) + " " + solution());
		}
	}
}
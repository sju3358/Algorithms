import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] houses;
	static int[][] dp;
	
	public static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b,c));
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		houses= new int[N][N];
		dp = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			houses[i][0] = scanner.nextInt();
			houses[i][1] = scanner.nextInt();
			houses[i][2] = scanner.nextInt();
		}
		
		dp[0][0] = houses[0][0];
		dp[0][1] = houses[0][1];
		dp[0][2] = houses[0][2];
		
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i-1][1] + houses[i][0] , dp[i-1][2] + houses[i][0]);
			dp[i][1] = Math.min(dp[i-1][0] + houses[i][1] , dp[i-1][2] + houses[i][1]);
			dp[i][2] = Math.min(dp[i-1][0] + houses[i][2] , dp[i-1][1] + houses[i][2]);
		}
		
		System.out.println(min(dp[N-1][0],dp[N-1][1],dp[N-1][2]));
	}
}
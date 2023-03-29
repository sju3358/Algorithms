import java.util.Scanner;

public class Main {
	
	static int T;
	static int[][] dp = new int[31][31];
	
	public static int nCm(int n, int m) {
		
		if(n == m)
			return 1;
		if(m == 0)
			return 1;
		
		if(dp[n][m] != -1)
			return dp[n][m];
		else
			return dp[n][m] = nCm(n-1,m-1) + nCm(n-1,m); 
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < 31; i++)
			for(int j = 0; j < 31; j++)
				dp[i][j] = -1;
		
		dp[0][0] = 1;
		dp[1][0] = dp[0][1] = dp[1][1] =1;
		
		T = scanner.nextInt();
		
		for(int t= 0; t < T; t++) {
			int west = scanner.nextInt();
			int east = scanner.nextInt();
			System.out.println(nCm(east,west));
		}
	}
}
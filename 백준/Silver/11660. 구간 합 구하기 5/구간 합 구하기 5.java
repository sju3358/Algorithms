import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n+1][n+1];

		
		for (int i = 1; i <= n; i++) {
			
			st = new StringTokenizer(br.readLine());
            
			for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }
		
		
		
		for(int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int j1 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
			int j2 = Integer.parseInt(st.nextToken());
			
			System.out.println(dp[i2][j2] - dp[i1-1][j2] - dp[i2][j1-1] + dp[i1-1][j1-1]);
		}
		
	}
}
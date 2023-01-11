import java.util.*;

public class Main {
	
	static int[][][] dp = new int[21][21][21];
	
	
	public static int w (int a, int b, int c){
		
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		else if(a > 20 || b > 20 || c > 20) {
			
			if(dp[20][20][20] == -1)
				dp[20][20][20] = w(20,20,20);
			
			return dp[20][20][20];
		}
		else if(a < b && b < c) {
			
			if(dp[a][b][c-1] == -1 )
				dp[a][b][c-1] = w(a,b,c-1);
			
			if( dp[a][b-1][c-1] == -1 ) 
				dp[a][b-1][c-1] = w(a,b-1,c-1);
			
			if( dp[a][b-1][c] == -1)
				dp[a][b-1][c] = w(a,b-1,c);
				
			return dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c];
		}
		else {
			
			if(dp[a-1][b][c] == -1 )
				dp[a-1][b][c] = w(a-1,b,c);
			
			if(dp[a-1][b-1][c] == -1 )
				dp[a-1][b-1][c] = w(a-1,b-1,c);
			
			if( dp[a-1][b][c-1] == -1 ) 
				dp[a-1][b][c-1] = w(a-1,b,c-1);
			
			if( dp[a-1][b-1][c-1] == -1)
				dp[a-1][b-1][c-1] = w(a-1,b-1,c-1);
				
			return dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		while(true) {
			
			for(int i = 0; i<21; i++)
				for(int j = 0; j<21; j++)
					for(int k = 0; k<21; k++)
						dp[i][j][k] = -1;
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if(a == b && b == c && c == -1)
				break;
			
			System.out.printf("w(%d, %d, %d) = %d\n",a,b,c,w(a,b,c));
			
			
				
		}
		sc.close();
	}
}

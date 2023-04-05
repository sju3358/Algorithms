import java.util.Arrays;

class Solution {
    
	public int solution(int[][] triangle) {
       
		int N = triangle.length;
		
		int[][] map = new int[N+1][N+1];
		int[][] dp = new int[N+1][N+1];
		
		for(int i = 0; i <= N; i++) {
			Arrays.fill(map[i], -1);
			Arrays.fill(dp[i], -5000000);
		}
		
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= i; j++) 
				map[i][j] = triangle[i-1][j-1];
			
		dp[1][1] = map[1][1];
		for(int i = 2; i <= N; i++)
			for(int j = 1; j <= i; j++) 
				dp[i][j] = Math.max(dp[i-1][j-1]+map[i][j], dp[i-1][j]+map[i][j]);
			
		return Arrays.stream(dp[N]).max().getAsInt();
    }
    
    public static void main(String args[]) {
    	System.out.println(new Solution().solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
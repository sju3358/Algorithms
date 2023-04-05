
class Solution {

	public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        int[][] map = new int[n+1][m+1];
        
        for(int i = 0; i < puddles.length; i++)
        	map[puddles[i][1]][puddles[i][0]] = -1;
        
        dp[1][1] = 1;
        
        for(int i = 1; i <= n; i++)
        	for(int j = 1; j <= m; j++) {
     
        		if(map[i][j-1] != -1)
        			dp[i][j] += dp[i][j-1];
        		
        		if(map[i-1][j] != -1)
        			dp[i][j] += dp[i-1][j];
        		
        		dp[i][j] = dp[i][j] % 1000000007;
        	}
        
        return dp[n][m];
    }
    
    
    public static void main(String args[]) {
    	
    	System.out.println(new Solution().solution(4,3,new int[][] {{2,2}}));
    }
}
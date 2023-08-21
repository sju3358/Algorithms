import java.util.Arrays;

class Solution {

	private final int maxValueOfFare = 3980001;

	public int solution(int n, int s, int a, int b, int[][] fares) {

		int[][] map = new int[n][n];

		for(int i = 0; i < n; i ++){
			Arrays.fill(map[i],maxValueOfFare);
            map[i][i] = 0;
        }
            
        
        for(int i = 0; i < fares.length; i++) {
			int from = fares[i][0]-1;
			int to = fares[i][1]-1;
			int cost = fares[i][2];
			map[from][to] = map[to][from] = cost;
			
		}

		for(int k = 0; k < n; k++)
			for(int i = 0; i < n ; i++)
				for(int j = 0; j < n; j++)
					map[i][j] = Math.min(map[i][j] , map[i][k] + map[k][j]);

		int cost = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++)
			cost = Math.min(cost, map[s-1][i] + map[i][a-1] + map[i][b-1]);

		return cost;

	}

}
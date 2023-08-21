import java.util.Arrays;

class Solution {

	private final int maxValueOfFare = 3980001;

	private int getMin(int... values){
		int result = Integer.MAX_VALUE;

		for(int value : values){
			result = Math.min(result,value);
		}
		return result;
	}

	public int solution(int n, int s, int a, int b, int[][] fares) {

		int[][] map = new int[n][n];

		for(int i = 0; i < n; i ++)
			Arrays.fill(map[i],maxValueOfFare);


		for(int i = 0; i < fares.length; i++) {
			int from = fares[i][0]-1;
			int to = fares[i][1]-1;
			int cost = fares[i][2];
			map[from][to] = map[to][from] = cost;
			
		}
        
        for(int i = 0; i < n; i++)
            map[i][i] = 0;

		for(int k = 0; k < n; k++)
			for(int i = 0; i < n ; i++)
				for(int j = 0; j < n; j++)
					map[i][j] = Math.min(map[i][j] , map[i][k] + map[k][j]);

		int cost1 = map[s-1][a-1] + map[s-1][b-1];
		int cost2 = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++)
			cost2 = Math.min(cost2, map[s-1][i] + map[i][a-1] + map[i][b-1]);

		return Math.min(cost1,cost2);

	}

	public static void main(String args[]){
		System.out.println(new Solution().solution(7,3,4,1,new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));
	}
}
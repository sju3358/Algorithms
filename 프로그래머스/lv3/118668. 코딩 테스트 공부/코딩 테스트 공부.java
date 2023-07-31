import java.util.*;

class Solution {
	static int[][] dp = new int[151][151];
	static int max_alp = 0;
	static int max_cop = 0;
	static int cnt = Integer.MAX_VALUE/2;

	public int solution(int alp, int cop, int[][] problems) {
		for(int i = 0; i < problems.length; i++){
			max_alp = Math.max(max_alp, problems[i][0]);
			max_cop = Math.max(max_cop, problems[i][1]);
		}

		for(int[] a : dp){
			Arrays.fill(a, Integer.MAX_VALUE/2);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {return a[2] - b[2];});
		pq.add(new int[]{alp, cop, 0});
		dp[alp][cop] = 0;

		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			if(cnt <= cur[2]) continue;
			for(int i = 0; i < problems.length; i++){
				
				if(cur[0] >= problems[i][0] && cur[1] >= problems[i][1]){
					int[] next = new int[]{cur[0]+problems[i][2], cur[1]+problems[i][3], cur[2]+problems[i][4]};
					
					if(next[0] >= max_alp && next[1] >= max_cop){
						dp[max_alp][max_cop] = Math.min(dp[max_alp][max_cop], next[2]);
						cnt = next[2];
						continue;
					}
					if(next[0] >= max_alp) next[0] = max_alp;
					if(next[1] >= max_cop) next[1] = max_cop;

					if(dp[next[0]][next[1]] > next[2]){
						dp[next[0]][next[1]] = next[2];
						pq.add(next);
					}
				}
			}
			// 공부로 1 늘리기
			if(cur[0] < max_alp && dp[cur[0]+1][cur[1]] > cur[2]+1){
				dp[cur[0]+1][cur[1]] = cur[2] + 1;
				pq.add(new int[]{cur[0]+1,cur[1],cur[2]+1});
			}
			if(cur[1] < max_cop && dp[cur[0]][cur[1]+1] > cur[2]+1){
				dp[cur[0]][cur[1]+1] = cur[2]+1;
				pq.add(new int[]{cur[0],cur[1]+1,cur[2]+1});
			}
		}
		return dp[max_alp][max_cop];
	}
}
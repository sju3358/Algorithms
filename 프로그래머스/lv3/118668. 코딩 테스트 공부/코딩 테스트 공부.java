import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {


	int[][] problems;

	int answer = Integer.MAX_VALUE;

	public boolean findAnySolvableProblemByAlp(int curAlp, boolean[] visited){
		for(int i = 0; i < problems.length; i++){

			if(visited[i] == true)
				continue;;

			if(problems[i][0] <= curAlp)
				return true;
		}
		return false;
	}

	public boolean findAnySolvableProblemByCop(int curCop, boolean[] visited){
		for(int i = 0; i < problems.length; i++){

			if(visited[i] == true)
				continue;;

			if(problems[i][1] <= curCop)
				return true;
		}
		return false;
	}

	public void dfs(int curAlp, int curCop, int curCost, int solvedCnt, boolean[] visited){

		if(curCost > answer)
			return;

		if(solvedCnt == visited.length) {
			answer = Math.min(answer, curCost);
			return;
		}

		for(int i = 0; i < problems.length; i++){

			if(visited[i] == true)
				continue;

			int alp_req = problems[i][0];
			int cop_req = problems[i][1];
			int alp_rwd = problems[i][2];
			int cop_rwd = problems[i][3];
			int cost = problems[i][4];

			if(curAlp >= alp_req && curCop >= cop_req){
				visited[i] = true;
				dfs(curAlp + alp_rwd, curCop + cop_rwd, curCost + cost, solvedCnt+1, visited);
				visited[i] = false;
			}
		}
		for(int i = 0; i < problems.length; i++){

		}
		boolean flag1 = findAnySolvableProblemByAlp(curAlp,visited);
		boolean flag2 = findAnySolvableProblemByCop(curCop,visited);

		if(flag1 != true && flag2 != true){
			dfs(curAlp+1,curCop+1,curCost+2,solvedCnt,visited);
		} else {
			if(flag1)
				dfs(curAlp,curCop+1,curCost+1,solvedCnt,visited);
			if(flag2)
				dfs(curAlp+1,curCop,curCost+1,solvedCnt,visited);
		}

	}

	public int solution(int alp, int cop, int[][] problems) {

		this.problems = problems;

		boolean[] visited = new boolean[problems.length];

		dfs(alp,cop,0,0,visited);

		return answer;
	}

	public static void main(String args[]){
		new Solution().solution(10,10,new int[][]{{10,15,2,1,2},{20,20,3,3,4}});
	}
}
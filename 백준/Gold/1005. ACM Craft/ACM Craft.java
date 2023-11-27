import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


	private static int[] topologySort(int[] buildingCosts, int[] indegrees, ArrayList<Integer>[] edegs){

		int[] buildingCostsDp = new int[buildingCosts.length];
		Arrays.fill(buildingCostsDp,0);

		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < indegrees.length; i++) {
			if(indegrees[i] == 0) {
				buildingCostsDp[i] = buildingCosts[i];
				queue.add(i);
			}
		}

		while(!queue.isEmpty()) {
			int currentBuilding = queue.poll();

			for(int i = 0; i < edegs[currentBuilding].size(); i++) {
				int nextBuilding = edegs[currentBuilding].get(i);
				buildingCostsDp[nextBuilding] = Math.max(buildingCostsDp[currentBuilding] + buildingCosts[nextBuilding], buildingCostsDp[nextBuilding]);
				indegrees[nextBuilding]--;

				if(indegrees[nextBuilding] == 0)
					queue.offer(nextBuilding);
			}
		}

		return buildingCostsDp;
	}

	private static int solution(int[] buildingCosts, int[] indegrees, ArrayList<Integer>[] edegs,int target){

		int[] minBuildingCost = topologySort(buildingCosts,indegrees,edegs);
		return minBuildingCost[target];
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++){

			st = new StringTokenizer(br.readLine());
			int countOfBuildings = Integer.parseInt(st.nextToken());
			int countOfRules = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());

			int[] buildingCosts = new int[countOfBuildings];
			int[] indegrees = new int[countOfBuildings];
			ArrayList<Integer>[] edegs = new ArrayList[countOfBuildings];


			for(int j = 0; j < countOfBuildings; j++) {
				buildingCosts[j] = Integer.parseInt(st.nextToken());
				indegrees[j] = 0;
				edegs[j] = new ArrayList<>();
			}


			for(int j = 0; j < countOfRules; j++){
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;

				edegs[from].add(to);
				indegrees[to] += 1;
			}

			int target = Integer.parseInt(br.readLine()) - 1;

			System.out.println(solution(buildingCosts,indegrees,edegs,target));
		}

	}
}
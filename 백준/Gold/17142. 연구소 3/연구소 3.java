import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static class Virus{
		int i;
		int j;
		int activeTime = 0;

		public Virus(int i, int j, int activeTime){
			this.i = i;
			this.j = j;
			this.activeTime = activeTime;
		}
	}

	private static int[][] map;
	private static int n,m;
	private static int targetCount;
	private static ArrayList<Virus> virusList = new ArrayList<>();
	private static boolean isArrive = false;
	private static int minTime = Integer.MAX_VALUE;
	private static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};


	private static boolean isInBoundary(int i , int j){
		return 0 <= i && i < n && 0 <= j && j < n;
	}

	private static int calculateTime(int[] activeVirusIndexList){

		Queue<Virus> activeVirusList = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];

		int activeVirusCount = 0;
		int time = 0;


		for(int i = 0; i < m; i++){
			int index = activeVirusIndexList[i];
			Virus virus = virusList.get(index);
			activeVirusList.add(virus);
			visited[virus.i][virus.j] = true;
		}

		while(activeVirusList.isEmpty() != true) {

			int queueSize = activeVirusList.size();

			for (int i = 0; i < queueSize; i++) {
				Virus virus = activeVirusList.poll();

				for (int j = 0; j < 4; j++) {
					int nextI = virus.i + dir[j][0];
					int nextJ = virus.j + dir[j][1];

					if (isInBoundary(nextI, nextJ) != true)
						continue;
					if (map[nextI][nextJ] == 1)
						continue;
					if (visited[nextI][nextJ] == true)
						continue;

					if(map[nextI][nextJ] != 2) {
						time = Math.max(time, virus.activeTime + 1);
						activeVirusCount++;
					}
					visited[nextI][nextJ] = true;
					activeVirusList.add(new Virus(nextI, nextJ, virus.activeTime + 1));

				}
			}
		}

		return targetCount == activeVirusCount ? time : -1;
	}

	private static void dfs(int size , int[] activeVirusIndexList){

		if(size == m){

			int time = calculateTime(activeVirusIndexList);

			if(time != -1){
				isArrive = true;
				minTime = Math.min(time, minTime);
			}

		}else{

			int curIndex = size == 0 ? -1 :  activeVirusIndexList[size-1];

			for(int i = curIndex+1; i < virusList.size(); i++){
				activeVirusIndexList[size] = i;
				dfs(size+1, activeVirusIndexList);
			}
		}
	}

	private static int solution(){

		int[] activeVirusIndexList = new int[m];

		dfs(0, activeVirusIndexList);

		return isArrive == true ? minTime : -1;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		targetCount = 0;

		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++){
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;

				if(value == 0)
					targetCount += 1;
				if(value == 2) {
					virusList.add(new Virus(i, j,0));
				}
			}
		}

		System.out.println(solution());
	}
}
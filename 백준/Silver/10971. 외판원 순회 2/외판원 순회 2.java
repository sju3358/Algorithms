import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] weight;
	
	static int minCost = Integer.MAX_VALUE;
	
	public static void getPermutation(int[] cur, boolean[] visited, int sizeOfCur, int m) {
		
		if (sizeOfCur == m) {
			
//			System.out.println(Arrays.toString(cur));
			
			if(weight[cur[N-1]][0] > 0) {
				int cost = 0;
				for(int i = 0; i < N-1; i++) {
					cost += weight[cur[i]][cur[i+1]];
				}
				cost += weight[cur[N-1]][0];
				
				if(minCost > cost)
					minCost = cost;
			}
		}
		else {
			
			for (int i = 0; i < N; i++) {
				
				if (visited[i] == true)
					continue;
				
				if(weight[cur[sizeOfCur-1]][i] > 0) {
				
					cur[sizeOfCur] = i; 
					visited[i] = true;
					getPermutation(cur,visited,sizeOfCur+1,m);
					visited[i] = false;
				}
				
			}
		}
	}
	
	public static void solution() {
		
		boolean[] visited = new boolean[N];
		int[] cur = new int[N];
		
		cur[0] = 0;
		visited[0] = true;
		getPermutation(cur, visited, 1, N);
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		
		
		
		weight = new int[N][N];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) 
				weight[i][j] = scanner.nextInt();
			
		solution();
		
		System.out.println(minCost);
	} 
}
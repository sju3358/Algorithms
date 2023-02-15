import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	
	int i;
	int j;
	int cost; 
	
	public Node(int i, int j, int cost) {
		this.i = i;
		this.j = j;
		this.cost = cost;
	}
}




public class Solution {

	static int[] dir_i = {1 ,-1, 0, 0};
	static int[] dir_j = {0 , 0, 1,-1};
	
	static int[][] rooms;
	
	public static boolean isInBoundary(int i, int j, int n) {
		return 0 <= i && i < n && 0 <= j && j < n;
	}
	
	public static int getCost(int i, int j, int n) {
	
		Node maxCost = new Node(-1,-1,0);
		
		boolean[][] isVisit = new boolean[n][n];
		
		Queue<Node> dfsQueue = new LinkedList<>();
		
		isVisit[i][j] = true;
		dfsQueue.add(new Node(i,j,1));
		
		while(dfsQueue.isEmpty() != true) {
			Node node = dfsQueue.poll();
			
			boolean isEnd = true;
			for(int cnt = 0; cnt <4; cnt++) {
				int next_i = node.i + dir_i[cnt];
				int next_j = node.j + dir_j[cnt];
				
				if(isInBoundary(next_i, next_j, n)) {
					
					boolean flag1 = isVisit[next_i][next_j] == false;
					boolean flag2 = rooms[next_i][next_j] - rooms[node.i][node.j] == 1;
					
					if(flag1 && flag2) {
						isVisit[next_i][next_j] = true;
						dfsQueue.add(new Node(next_i, next_j, node.cost+1));
						isEnd = false;
					}			
				}
			}
			
			if(isEnd) {
				if(maxCost.cost < node.cost) {
					maxCost.cost = node.cost;
					maxCost.i = node.i;
					maxCost.j = node.j;
				}
				else if(maxCost.cost == node.cost) {
					if(maxCost.i == -1 || rooms[maxCost.i][maxCost.j] > rooms[node.i][node.j]) {
						maxCost.i = node.i;
						maxCost.j = node.j;
					}
				}
			}
		}
		
		return maxCost.cost;
	}
	
	
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		
		
		for(int test = 1; test <= T; test++) {
			
			int n = scanner.nextInt();
			rooms = new int[n][n];
			
			for(int i = 0; i <n; i++)
				for(int j = 0; j <n; j++)
					rooms[i][j] = scanner.nextInt();
			
			
			int max = -1;
			int min = Integer.MAX_VALUE;
			
			for(int i = 0; i <n; i++)
				for(int j = 0; j <n; j++) {
					int result = getCost(i,j,n);
					
					if(max < result) {
						max = result;
						min = rooms[i][j];
					}
					else if(max == result && min > rooms[i][j] )
							min = rooms[i][j];
				}
			
			System.out.println("#" + test + " " + min + " " + max);
		}
	}

}
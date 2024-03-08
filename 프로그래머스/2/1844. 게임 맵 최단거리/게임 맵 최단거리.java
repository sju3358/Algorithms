import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

	private int[][] minCost;
	private int[][] maps;
	private int n,m;
	private boolean isArrive = false;

	private int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

	private class Node{
		int x;
		int y;
		int cost;
		public Node(int x,int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

	public boolean isInBoundary(int x, int y){
		return 0 <= x && x < this.n && 0 <= y && y < this.m;
	}
	public void bfs(){
		Queue<Node> queue = new LinkedList<>();
		Node start = new Node(0,0,1);

		queue.add(start);

		while(!queue.isEmpty()){
			Node cur = queue.poll();

			int curX = cur.x;
			int curY = cur.y;

			if(curX == this.n - 1 && curY == this.m - 1)
				isArrive = true;

			for(int i = 0; i < 4; i++){
				int nextX = curX + dir[i][0];
				int nextY = curY + dir[i][1];
				int nextCost = cur.cost + 1;

				if(!isInBoundary(nextX,nextY))
					continue;
				if(maps[nextX][nextY] == 0)
					continue;
				if(minCost[nextX][nextY] <= nextCost)
					continue;

				minCost[nextX][nextY] = nextCost;
				queue.add(new Node(nextX,nextY,nextCost));
			}

		}
	}

	public int solution(int[][] maps) {

		this.n = maps.length;
		this.m = maps[0].length;
		minCost = new int[n][m];

		for(int i = 0; i < n; i++)
			Arrays.fill(minCost[i], Integer.MAX_VALUE);

		this.maps = maps;

		bfs();

		return isArrive ? minCost[n-1][m-1] : -1;
	}

	public static void main(String args[]){
		new Solution().solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
	}
}
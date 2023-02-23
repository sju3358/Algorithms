import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int k;
	static int minCost = 2100000000;
	static int[] dp =  new int[200001];

	static class Node{
		int curPos;
		int cost;
		
		public Node(int curPos, int cost) {
			this.curPos = curPos;
			this.cost = cost;
		}
	}

	static void findK(int curPos, int cost) {

		Queue<Node> dfs_queue = new LinkedList<Node>();;

		dfs_queue.add(new Node( curPos,cost ));

		while (dfs_queue.isEmpty() != true) {
			Node curNode = dfs_queue.poll();


			if (curNode.curPos == k) {
				if (minCost > curNode.cost)
					minCost = curNode.cost;
			}
			

			if (curNode.curPos < k) {
				if (curNode.curPos * 2 < 2 * k) {
					if (dp[curNode.curPos * 2] == -1 || dp[curNode.curPos] > curNode.curPos) {
						dp[curNode.curPos] = curNode.cost;
						dfs_queue.add(new Node( curNode.curPos * 2, curNode.cost + 1 ));
					}
				}

				if (curNode.curPos + 1 <= k + 1) {
					if (dp[curNode.curPos + 1] == -1 || dp[curNode.curPos] > curNode.curPos) {
						dp[curNode.curPos] = curNode.cost;
						dfs_queue.add(new Node( curNode.curPos + 1, curNode.cost + 1 ));
					}
				}
			}

			if (curNode.curPos - 1 > 0) {
				if (dp[curNode.curPos  -1] == -1 || dp[curNode.curPos] > curNode.curPos) {
					dp[curNode.curPos] = curNode.cost;
					dfs_queue.add(new Node( curNode.curPos - 1, curNode.cost + 1 ));
				}

			}
		}
	}

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);

		 n = scanner.nextInt();
		 k = scanner.nextInt();
		
		for (int i = 0; i < 200001; i++)
			dp[i] = -1;
		
		if (n >= k)
			System.out.println(n - k);
		else {
			if (n == 0)
				findK(1, 1);
			else
				findK(n, 0);

			System.out.println(minCost);
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	
	static boolean[][] players;
	static boolean[][] resultMap;
	
	public static void bfs(int startNode) {

		boolean[] visited = new boolean[players.length];

		Queue<Integer> nextNode = new LinkedList<Integer>();
		nextNode.add(startNode);
		visited[startNode] = true;

		while (nextNode.isEmpty() != true) {
			int curNode = nextNode.poll();

			for (int i = 0; i < players.length; i++) {
				
				if (visited[i] == true)
					continue;

				if (players[curNode][i] == true) {
					visited[i] = true;
					resultMap[startNode][i] = true;
					nextNode.add(i);
				}
			}
		}
	}

	public static boolean isAnswer(int player) {

		
		for (int i = 0; i < resultMap.length; i++) {
			if (resultMap[player][i] == false) {
				if (resultMap[i][player] == true)
					continue;
				else
					return false;
			}
		}

		return true;
	}

	public static void main(String args[]) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t = 1; t <= T; t++) {
		
			int N = Integer.parseInt(br.readLine().trim());
			int M = Integer.parseInt(br.readLine().trim());
			
			players = new boolean[N][N];
			resultMap = new boolean[N][N];
	
			for (int i = 0; i < N; i++) {
				players[i][i] = true;
				resultMap[i][i] = true;
			}
	
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int winner = Integer.parseInt(st.nextToken()) - 1;
				int loser = Integer.parseInt(st.nextToken()) - 1;
				players[loser][winner] = true;
			}
	
			for (int i = 0; i < N; i++)
				bfs(i);
			
			int answer = 0;
			
			for (int i = 0; i < N; i++)
				if (isAnswer(i))
					answer++;
	
			System.out.println("#" + t + " " + answer);
		}
	}	

}
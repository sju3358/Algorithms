import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


	private static int N;
	private static int M;
	private static char[][] map;

	private static class Node{

		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	private static boolean isInBoundary(int i, int j){
		return 0 <= i && i < N && 0 <= j && j < M;
	}

	private static String solution(int startI, int startJ){


		int cntOfPerson = 0;

		boolean[][] visited = new boolean[N][M];
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

		Queue<Node> queue = new LinkedList<>();

		Node start = new Node(startI,startJ);
		visited[startI][startJ] = true;
		queue.add(start);

		while (queue.isEmpty() != true){
			Node curNode = queue.poll();

			int curI = curNode.i;
			int curJ = curNode.j;

			if(map[curI][curJ] == 'P')
				cntOfPerson += 1;

			for(int i = 0; i < 4; i++){
				int nextI = curI + dir[i][0];
				int nextJ = curJ + dir[i][1];

				if(isInBoundary(nextI, nextJ) != true)
					continue;

				if(visited[nextI][nextJ] == true)
					continue;

				if(map[nextI][nextJ] != 'X') {
					visited[nextI][nextJ] = true;
					queue.add(new Node(nextI, nextJ));
				}
			}
		}

		return cntOfPerson > 0 ? Integer.toString(cntOfPerson) : "TT";
	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		int startI = -1;
		int startJ = -1;

		for(int i = 0; i < N; i++){
			String input = br.readLine();
			for(int j = 0; j < M; j++){
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'I'){
					startI = i;
					startJ = j;
				}
			}
		}

		System.out.println(solution(startI,startJ));
	}
}
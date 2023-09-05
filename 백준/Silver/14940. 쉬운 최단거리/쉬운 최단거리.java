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
	private static int[][] map;

	private static class Node{

		int i;
		int j;
		int length;

		public Node(int i, int j,int length) {
			this.length = length;
			this.i = i;
			this.j = j;
		}
	}

	private static void printMap(){
		for(int i = 0; i < N ;i++) {
			for (int j = 0; j < M; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}

	private static boolean isInBoundary(int i, int j){
		return 0 <= i && i < N && 0 <= j && j < M;
	}

	private static void findMinLength(int startI, int startJ){

		Node start = new Node(startI,startJ,0);

		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

		Queue<Node> queue = new LinkedList<>();

		queue.add(start);

		while (queue.isEmpty() != true){
			Node curNode = queue.poll();

			int curI = curNode.i;
			int curJ = curNode.j;
			int curLength = curNode.length;


			for(int i = 0; i < 4; i++){
				int nextI = curI + dir[i][0];
				int nextJ = curJ + dir[i][1];
				int nextLength = curLength + 1;

				if(isInBoundary(nextI, nextJ) != true)
					continue;
				if(map[nextI][nextJ] == 0)
					continue;

				if(map[nextI][nextJ] == -1 || map[nextI][nextJ] > nextLength) {
					map[nextI][nextJ] = nextLength;
					queue.add(new Node(nextI, nextJ, nextLength));
				}
			}

		}
	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		int startI = -1;
		int startJ = -1;

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				int value = Integer.parseInt(st.nextToken());

				switch (value){
					case 0 :
						map[i][j] = 0;
						break;
					case 1:
						map[i][j] = -1;
						break;
					case 2:
						startI = i;
						startJ = j;
						map[i][j] = 0;
						break;
				}

			}
		}

		findMinLength(startI, startJ);

		printMap();
	}
}
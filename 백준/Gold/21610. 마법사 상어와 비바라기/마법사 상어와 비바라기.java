import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static class Node{
		int i;
		int j;

		public Node(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[][] water;
	static int[][] dir = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
	static Queue<Node> cloud = new LinkedList<>();

	static boolean[][] visited;

	private static int getSumOfMap(){
		int sum = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N ; j++)
				sum += water[i][j];
		return sum;
	}

	private static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < N && 0 <= j && j < N;
	}

	private static void moveCloudAndDropRain(int direction, int length){

		visited = new boolean[N][N];

		int sizeOfCloud = cloud.size();

		for(int i = 0; i < sizeOfCloud; i++){
			Node curNode = cloud.poll();

			int nextI = curNode.i + dir[direction][0] * length;
			int nextJ = curNode.j + dir[direction][1] * length;


			while(nextI >= N)
				nextI -= N;
			while(nextJ >= N)
				nextJ -= N;

			while(nextI < 0)
				nextI +=N;
			while(nextJ < 0)
				nextJ += N;

			cloud.add(new Node(nextI,nextJ));
			water[nextI][nextJ] += 1;
			visited[nextI][nextJ] = true;
		}
	}
	private static void addWater(){

		int[] dirIndex = {1,3,5,7};

		while(cloud.isEmpty() != true){
			Node curNode = cloud.poll();

			for(int i = 0; i < 4; i++){
				int nextI = curNode.i + dir[dirIndex[i]][0];
				int nextJ = curNode.j + dir[dirIndex[i]][1];

				if(isInBoundary(nextI, nextJ) == true && water[nextI][nextJ] > 0)
					water[curNode.i][curNode.j] += 1;
			}
		}
	}

	private static void createCloud(){
		for(int i = 0; i < N; i++)
			for(int j =0; j < N; j++){
				if(water[i][j] >= 2 && visited[i][j] != true){
					cloud.add(new Node(i,j));
					water[i][j] -= 2;
				}
			}
	}

	private static void print(){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(water[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void doMagic(int direction, int length) {

		moveCloudAndDropRain(direction, length);

		addWater();

		createCloud();

	}


	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		water = new int[N][N];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++)
				water[i][j] = Integer.parseInt(st.nextToken());
		}


		cloud.add(new Node(N-1,0));
		cloud.add(new Node(N-1,1));
		cloud.add(new Node(N-2,0));
		cloud.add(new Node(N-2,1));

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int direction = Integer.parseInt(st.nextToken()) - 1;
			int length = Integer.parseInt(st.nextToken());
			doMagic(direction,length);
		}

		System.out.println(getSumOfMap());
	}
}
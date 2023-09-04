import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static boolean[][] map;
	private static int N;
	private static int count = 0;

	private static int[][] dir = {{0,1},{1,1},{1,0}};

	private static int[] dirCnt = {-1,0,1};

	private static  boolean isInBoundary(int i, int j){
		return 0 <= i && i < N && 0 <= j && j < N;
	}

	private static boolean isWall(int i , int j){
		return map[i][j];
	}

	private static boolean isValidDir(int dir){
		return 0 <= dir && dir < 3;
	}

	private static void solution(int curI, int curJ, int curDir){

		if(curJ == N-1 && curI == N-1){
			count += 1;
			return;
		}

		for(int i = 0; i < 3; i++){
			int nextDir = curDir + dirCnt[i];

			if(isValidDir(nextDir) != true)
				continue;

			int nextI = curI + dir[nextDir][0];
			int nextJ = curJ + dir[nextDir][1];

			if(isInBoundary(nextI,nextJ) != true)
				continue;

			if(isWall(nextI, nextJ) == true)
				continue;

			if(nextDir == 1){

				if(nextI-1 < 0)
					continue;

				if(map[nextI-1][nextJ] == true)
					continue;

				if(nextJ-1 < 0)
					continue;

				if(map[nextI][nextJ-1] == true)
					continue;
			}

			map[nextI][nextJ] = true;
			solution(nextI,nextJ,nextDir);
			map[nextI][nextJ] = false;
		}

	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine().trim());

		map = new boolean[N][N];

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				map[i][j] = Integer.parseInt(st.nextToken()) == 1;
			}
		}

		map[0][0] = true;
		map[0][1] = true;

		solution(0,1,0);

		System.out.println(count);
	}
}
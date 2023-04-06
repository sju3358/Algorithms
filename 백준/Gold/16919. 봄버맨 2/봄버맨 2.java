import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	static int R,C,N;
	static int[][] map;
	
	static class Node{
		int i;
		int j;
		
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void print() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++)
				System.out.print(map[i][j] == -1 ? '.' : 'O');
			System.out.println();
		}
	}
	
	public static void printDebug() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++)
				System.out.printf("%2d",map[i][j]);
			System.out.println();
		}
	}
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
//		1
//		2
//		3 ==== 7  == 11  3
//		4 ==== 8  == 12 
//		5 ==== 9 == 13 
//		6 ==== 10 == 14
		
		if(N >= 3)
			N = (N%4)+4;
			
		
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) {
				if(input.charAt(j) == '.')
					map[i][j] = -1;
				else if(input.charAt(j) == 'O')
					map[i][j] = 2;
			}
		}

		
//		System.out.println("1초후");
//		printDebug();

		Queue<Node> bombs = new LinkedList<>();
		
		for(int time = 1; time < N; time++) {
			
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j] == -1)
						map[i][j] = 3;
					else if(map[i][j] > 0)
						map[i][j]--;
				}
			}
			

			for(int i = 0; i < R; i++) 
				for(int j = 0; j < C; j++) 
					if(map[i][j] == 0)
						bombs.add(new Node(i,j));

			
			while(bombs.isEmpty() != true) {
				Node bomb = bombs.poll();
				map[bomb.i][bomb.j] = -1;
				for(int k = 0; k < 4; k++) {
					int nextI = bomb.i + dir[k][0];
					int nextJ = bomb.j + dir[k][1];
					
					if(0 > nextI || 0 > nextJ || R <= nextI || C <= nextJ)
						continue;
					
					map[nextI][nextJ] = -1;	
				}
			}
//			System.out.println((time+1) + "초후");
//			printDebug();
			
		}
		print();
	}
}
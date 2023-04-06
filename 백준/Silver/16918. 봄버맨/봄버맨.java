import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	static int R,C,N;
	static Node[][] map;
	
	static class Node{
		int i;
		int j;
		int bomb;
		
		public Node(int i, int j, int bomb) {
			this.i = i;
			this.j = j;
			this.bomb = bomb;
		}
	}
	
	static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void print() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++)
				System.out.print(map[i][j].bomb == -1 ? '.' : 'O');
			System.out.println();
		}
	}
	
	public static void printDebug() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++)
				System.out.printf("%2d",map[i][j].bomb);
			System.out.println();
		}
	}
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new Node[R][C];
		
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) {
				if(input.charAt(j) == '.')
					map[i][j] = new Node(i,j,-1);
				else if(input.charAt(j) == 'O')
					map[i][j] = new Node(i,j,2);
			}
		}

		
		Queue<Node> bombs = new LinkedList<>();
		
		for(int time = 1; time < N; time++) {
			
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j].bomb == -1)
						map[i][j].bomb = 3;
					else if(map[i][j].bomb > 0)
						map[i][j].bomb = map[i][j].bomb - 1;
				}
			}
			

			for(int i = 0; i < R; i++) 
				for(int j = 0; j < C; j++) 
					if(map[i][j].bomb == 0)
						bombs.add(map[i][j]);

			
			while(bombs.isEmpty() != true) {
				Node bomb = bombs.poll();
				bomb.bomb = -1;
				for(int k = 0; k < 4; k++) {
					int nextI = bomb.i + dir[k][0];
					int nextJ = bomb.j + dir[k][1];
					
					if(0 > nextI || 0 > nextJ || R <= nextI || C <= nextJ)
						continue;
					
					map[nextI][nextJ].bomb = -1;	
				}
			}

		}
		print();
	}
}
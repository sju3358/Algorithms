import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[9][9];
		
		for(int i = 0; i<9; i++)
			map[i] = new int[9];
		
		
		for(int i = 0; i<9; i++)
			for(int j = 0; j<9; j++)
				map[i][j] = sc.nextInt();
		
		
		int max = -1;
		int index_i=-1, index_j = -1;
		
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				if(max < map[i][j]) {
					max = map[i][j];
					index_i = i+1;
					index_j = j+1;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(index_i + " " + index_j);
 		
		sc.close();
	}
}

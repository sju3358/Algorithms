
import java.util.*;

public class Solution {
	
	public static boolean checkRow(int arr[][]) {
		for(int i = 0; i < 9; i++) {
			
			boolean[] map = new boolean[10];
			
			for(int cnt = 0; cnt < 10; cnt++)
				map[cnt] = false;
			
			for(int j = 0; j < 9; j++) {
				
			
				if(map[arr[i][j]] == true)
					return false;
				else
					map[arr[i][j]] = true;
				
			}
			
		}
		
		return true;
	}
	public static boolean checkCol(int arr[][]) {
		
		for(int j = 0; j < 9; j++) {
			
			boolean[] map = new boolean[10];
			
			for(int cnt = 0; cnt < 10; cnt++)
				map[cnt] = false;
			
			for(int i = 0; i < 9; i++) {
				
			
				if(map[arr[i][j]] == true)
					return false;
				else
					map[arr[i][j]] = true;
				
			}
			
		}
		
		return true;
		
		
	}
	public static boolean checkBox(int arr[][]) {
		
		for(int idx_i = 0; idx_i < 9; idx_i = idx_i + 3) {
			for(int idx_j = 0; idx_j < 9; idx_j = idx_j+3) {
			
				boolean[] map = new boolean[10];
			
				for(int cnt = 0; cnt < 10; cnt++)
					map[cnt] = false;
			
			
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j<3; j++) {
						if(map[arr[idx_i+i][idx_j+j]] == true)
							return false;
						else
							map[arr[idx_i+i][idx_j+j]] = true;
					}
				}
			}
		}
		
		return true;
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case ++) {
			
			int[][] arr = new int[9][9];
			
			for(int i = 0; i<9; i++) {
				for(int j = 0; j<9; j++)
					arr[i][j] = sc.nextInt();
			}
			
			int result = 0;
			
			if(checkRow(arr) && checkCol(arr) && checkBox(arr))
				result = 1;
			else
				result = 0;
			
			System.out.println("#" + test_case + " " + result);
			
			
		}
		
		
		sc.close();
	}

}

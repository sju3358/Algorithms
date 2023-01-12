import java.util.*;

public class Main {
	
	public static int checkRow(boolean[][] map) {
		
		int result = 0;
		
		for(int i = 0; i<5; i++) {
			int cnt = 0;
			
			for(int j = 0; j<5; j++) {
				if(map[i][j] == true)
					cnt++;
			}
			
			if(cnt == 5)
				 result++;
		}
		
		return result;
	}
	public static int checkColumn(boolean[][] map) {
		
		int result = 0;
		
		for(int j = 0; j<5; j++) {
			int cnt = 0;
			
			for(int i = 0; i<5; i++) {
				if(map[i][j] == true)
					cnt++;
			}
			
			if(cnt == 5)
				 result++;
		}
		
		return result;
		
	}
	public static int checkDiagnal(boolean[][] map) {
		
		int result = 0;
		
		int cnt = 0;
		for(int i = 0; i < 5; i++)
			if(map[i][i] == true)
				cnt++;
		
		if(cnt == 5)
			result++;
		
		cnt = 0;
		for(int i = 0; i < 5; i++)
			if(map[4-i][i] == true)
				cnt++;
		if(cnt == 5)
			result++;
		
		return result;
			
		
	}
	
	public static boolean checkNumber(int number, int[][] bingo, boolean[][] map) {
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				if(bingo[i][j] == number) {
					map[i][j] = true;
				}
		
		
		if(checkRow(map) + checkColumn(map) + checkDiagnal(map) >= 3)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] bingo = new int[5][5];
		boolean[][] map = new boolean[5][5];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				bingo[i][j] = sc.nextInt();
				map[i][j] = false;
			}
		}
		
		for(int i = 0; i <  25; i++) {
			int number = sc.nextInt();
			
			if(checkNumber(number,bingo,map)) {
				System.out.println(i+1);
				break;
			}
			
		}
		
		
				
		
		sc.close();
	}
}

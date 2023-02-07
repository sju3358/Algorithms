import java.util.Scanner;

public class Solution {
	
	
	
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		
		for(int test_case = 1 ; test_case<= T; test_case++) {
			
			int N = scanner.nextInt();
			scanner.nextLine();
			
			int[][] map = new int[N][N];
			
			
			for(int i = 0; i <N; i++){
				
				String input = scanner.nextLine();
				
				for(int j = 0; j <input.length(); j++)
					map[i][j] = input.charAt(j) - '0';
			}

			int x = N/2;
			int y = N/2;
			int sum = map[x][y];
			
			
			for(int cnt = 1; cnt <= N/2; cnt++) {
				
				x = N/2;
				y = N/2;
				
				for(int flag = 0; flag < 4*cnt; flag++) {
					
					if(flag == 0) {
						x = x - cnt;
					}
					else if(flag <= 1*cnt) {
						x++;
						y--;
					}
					else if(flag <= 2*cnt) {
						x++;
						y++;
					}
					else if(flag <= 3*cnt) {
						x--;
						y++;
					}
					else if(flag <= 4*cnt) {
						x--;
						y--;
					}
					
					sum += map[x][y];
				}
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
		
		scanner.close();
	}
}
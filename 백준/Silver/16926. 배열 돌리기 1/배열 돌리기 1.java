import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int N,M,R;
	
	public static void rotateArr() {
		int[][] newArr = new int[N][M];
		
		for(int row = N, col = M, start_i = 0, start_j = 0; row > 0 && col > 0;start_i++, start_j++, row -=2, col -= 2) {
			
			// ㅓ
			for(int cnt = 0, j = start_j; cnt < col-1; cnt++, j++)
				newArr[start_i][j] = arr[start_i][j+1];
				

			// ㅜ			
			for(int cnt = 0, i = start_i+1; cnt < row-1; cnt++, i++)
				newArr[i][start_j] = arr[i-1][start_j];
				
			
			// ㅏ
			for(int cnt = 0, j = start_j+1; cnt < col-1; cnt++, j++)
				newArr[start_i+(row-1)][j] = arr[start_i+(row-1)][j-1];
			
			
			
			// ㅗ
			for(int cnt = 0, i = start_i; cnt < row-1; cnt++, i++)
				newArr[i][start_j+(col-1)] = arr[i+1][start_j+(col-1)];
	
		}
		
		
		arr = newArr;
	}
	
	
	
	public static void main (String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		N = scanner.nextInt();
		M = scanner.nextInt();
		R = scanner.nextInt();
		
		arr = new int[N][M];
		for(int i = 0; i <N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = scanner.nextInt();
		
		for(int i = 0; i <R; i++)
			rotateArr();
		
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <M; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}
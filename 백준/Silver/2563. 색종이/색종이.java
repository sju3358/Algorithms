import java.util.*;

public class Main {
	public static void pasteBlackPaper(int[][] arr, int left, int top) {
		
		for(int i = top; i < top+10; i++) {
			for(int j = left; j < left+10; j++)
				arr[i][j] = 1;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[100][100];
		
		for(int i = 0; i<100; i++) {
			for(int j = 0; j<100; j++) {
				arr[i][j] = 0;
			}
		}
		
		int n = sc.nextInt();
		
		for(int i = 0; i<n; i++) {
			int left = sc.nextInt();
			int top = sc.nextInt();
			pasteBlackPaper(arr, left, top);
		}
		
		int result = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j<100; j++) {
				if(arr[i][j] == 1)
					result++;
			}
		}
 		
		System.out.println(result);
		sc.close();
	}
}

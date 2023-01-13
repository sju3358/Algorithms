
import java.util.*;

public class Solution {

	
	public static int maxOfRow(int arr[][]) {
		int max = -1;
		
		for(int i = 0; i<100; i++) {
			int sumOfRow = 0;
			for(int j = 0; j<100; j++) {
				sumOfRow += arr[i][j];
			}
			if(max < sumOfRow)
				max = sumOfRow;
		}
		return max;
	}
	public static int maxOfColumn(int arr[][]) {
		int max = -1;
		
		for(int j = 0; j<100; j++) {
			int sumOfCol = 0;
			for(int i = 0; i<100; i++) {
				sumOfCol += arr[i][j];
			}
			if(max < sumOfCol)
				max = sumOfCol;
		}
		return max;
	}
	public static int maxOfDiag(int arr[][]) {
		
		int sumOfDiag1 = 0;
		int sumOfDiag2 = 0;
		for(int i = 0; i<100; i++) {
			sumOfDiag1 += arr[i][i];
			sumOfDiag2 += arr[99-i][i];
		}
		
		return sumOfDiag1 > sumOfDiag2 ? sumOfDiag1 : sumOfDiag2;
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		for(int test_case = 1; test_case <= 10; test_case ++) {
			sc.nextInt();
			
			int[][] arr = new int[100][100];
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++){
					arr[i][j] = sc.nextInt();
				}
			}
			int max = Math.max(maxOfRow(arr), maxOfColumn(arr));
			max = Math.max(max, maxOfDiag(arr));
			System.out.println("#" + test_case + " " + max);
			
			
		}
		
		
		sc.close();
	}

}

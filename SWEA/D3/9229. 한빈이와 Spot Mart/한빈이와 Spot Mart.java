import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for(int t = 1; t<=T; t++) {
			
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			int max = -1;
			
			int[] arr = new int[N];
			for(int i = 0; i <arr.length; i++) {
				arr[i] = scanner.nextInt();
			}
			
			for(int i = 0; i < arr.length-1; i++) {
				for(int j = i+1; j <arr.length; j++) {
					int sum = arr[i] + arr[j];
					if(max < sum && sum <= M)
						max = sum;
				}
			}
			
			System.out.print("#" + t + " " + max + "\n");
			
		}
		
	}
}
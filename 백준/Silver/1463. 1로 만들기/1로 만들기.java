import java.util.Scanner;

public class Main {
	
	static int[] arr;
	static int N;
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		arr = new int[N+1];
		
		
		
		for(int i = 0; i <= N; i++)
			arr[i] = -1;
		

		for (int i = 1; i <= N; i++) {
			
			int cost1 = arr[i-1] + 1;
			int cost2 = 2100000000;
			int cost3 = 2100000000;

			boolean flag1 = i % 3 == 0;
			boolean flag2 = i % 2 == 0;

			if (flag1 || flag2) {
				
				if (flag1) 
					cost3 = arr[i / 3] + 1;

				if (flag2) 
					cost2 = arr[i / 2] + 1;
			}
			
			arr[i] = Math.min(cost2, cost3);
			arr[i] = Math.min(arr[i], cost1);
			 
		}
		System.out.println(arr[N]);
	}
}
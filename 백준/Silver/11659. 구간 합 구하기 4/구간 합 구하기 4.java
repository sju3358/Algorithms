import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int t = scanner.nextInt();
		
		int[] sumOfInput = new int[n];

		sumOfInput[0] = scanner.nextInt();
		for(int i = 1; i < n; i++) {
			int input = scanner.nextInt();
			sumOfInput[i] = sumOfInput[i-1] + input;
		}
		
		for(int k = 0; k < t; k++) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			if(i == 1)
				System.out.println(sumOfInput[j-1]);
			else
				System.out.println(sumOfInput[j-1] - sumOfInput[i-2]);
		}
		
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int n = Integer.parseInt(bufferedReader.readLine());

		int[] receivedAt = new int[n];
		int[] stack_height = new int[n];
		int[] stack_index = new int[n];
		int sizeOfStack = 0;
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		for(int i = 0; i <n; i++) {
			
			int top = Integer.parseInt(stringTokenizer.nextToken());

			
			while(sizeOfStack > 0 && top > stack_height[sizeOfStack-1])
				sizeOfStack--;
			if(sizeOfStack > 0)
				receivedAt[i] = stack_index[sizeOfStack-1] + 1;
			
			stack_height[sizeOfStack] = top;
			stack_index[sizeOfStack] = i;
			sizeOfStack++;
		}
		
		for(int number : receivedAt)
			System.out.print(number + " ");
	}
}
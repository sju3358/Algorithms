import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	
	static int[] numbers;
	
	public static int findNumber(int target) {
		
		int isFound = 0;
		
		
		int low = 0;
		int high = numbers.length-1;
		
		
		while(low <= high) {
			int mid = (low + high)/2;
			
			if(numbers[mid] == target) {
				isFound = 1;
				break;
			}
			else if( numbers[mid]  < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		
		
		
		return isFound;
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		numbers = new int[n];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i <n; i++) 
			numbers[i] = Integer.parseInt(st.nextToken());

		
		Arrays.sort(numbers);
		
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i <k; i++) 
			System.out.println(findNumber(Integer.parseInt(st.nextToken())));
	}
}
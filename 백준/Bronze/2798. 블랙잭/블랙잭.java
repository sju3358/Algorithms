import java.util.Scanner;

public class Main {
	
	public static void main (String args[]) {
		
		Scanner scanner = new Scanner(System.in);
	
	    int max = -1;

	    int n = scanner.nextInt();
	    int m = scanner.nextInt();
	    int[] arr = new int[n];
	    
	    for(int i = 0; i<n; i++)
	        arr[i] = scanner.nextInt();

	    for(int i = 0; i<n-2; i++)
	        for(int j=i+1; j<n-1; j++)
	            for(int k = j+1; k<n; k++){
	                int score = arr[i] + arr[j] + arr[k];
	                if(max < score && score <= m)
	                	max = score;
	            }
	    System.out.println(max);
	}
}
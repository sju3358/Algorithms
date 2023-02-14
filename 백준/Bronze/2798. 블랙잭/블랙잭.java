import java.util.Scanner;

public class Main {
	
	static int[] arr = new int[100];
	
	public static void main (String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		int n,m;
	    int i,j,k;
	    int dif = 999999999,result = 0;
	    int temp;

	    n = scanner.nextInt();
	    m = scanner.nextInt();

	    for(i = 0; i<n; i++)
	        arr[i] = scanner.nextInt();

	    for(i = 0; i<n-2; i++)
	        for(j=i+1; j<n-1; j++)
	            for(k = j+1; k<n; k++)
	            {
	                temp = arr[i] + arr[j] + arr[k];
	                int cnt = m-temp;
	                if(cnt >= 0 && cnt < dif)
	                {
	                    dif = cnt;
	                    result = temp;
	                }
	            }
	    System.out.println(result);
	}
}
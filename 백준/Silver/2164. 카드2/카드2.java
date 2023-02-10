import java.util.Scanner;

public class Main {

	
	static int[] queue = new int[1000000];
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean flag = true;
		
	    int n = scanner.nextInt();
	    
	    
	    int tail = n-1;
	    int head = 0;
	    
	    for(int i = 0; i<n; i++)
	        queue[i] = i+1;
	    
	    while(head != tail)
	    {
	        if(flag) 
	        { 
	            head++;
	            flag = false;
	        }
	        else
	        {
	            queue[++tail] = queue[head++];
	            flag = true;
	        }
	    }
	    System.out.println(queue[tail]);
	}
}

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			double result = 0;
			
			for(int i = 0; i < 10; i++)
				result += sc.nextInt();
			
			result /= 10;	
			
			System.out.println("#" + test_case + " " +Math.round(result));

		}
		
		sc.close();
		
	}

}

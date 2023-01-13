
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			
			int max = -1;
			
			for(int i = 0; i < 10; i++) {
				
				int temp = sc.nextInt();
				
				if(max < temp)
					max = temp;
			
			}
			
			System.out.println("#" + test_case + " " + max);

		}
		
		sc.close();
		
	}

}

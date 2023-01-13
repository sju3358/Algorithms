
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case ++) {
			
			int test_case_num = sc.nextInt();
			
			int[] map = new int[101];
			
			
			for(int i = 0; i < 1000; i++)
				map[sc.nextInt()]++;
			
			int max = -1;
			int max_idx = -1;
			for(int i = 0; i<100; i++) {
				if(max <= map[i]) {
					max = map[i];
					max_idx = i;
				}
			}
			System.out.println("#" + test_case_num + " " + max_idx);
			
			
		}
		
		
		sc.close();
	}

}


import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> inputs = new ArrayList<Integer>();
		
		int N = sc.nextInt();
		
		int sum = 0;
		
		while(N != 0) {
			sum = sum + N%10;
			N = N/10;
		}
		
		
		System.out.println(sum);
		
		sc.close();
		
	}

}

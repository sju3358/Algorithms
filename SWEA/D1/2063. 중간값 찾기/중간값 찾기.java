
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> inputs = new ArrayList<Integer>();
		
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++)
			inputs.add(sc.nextInt());
		
		Collections.sort(inputs);
		
		System.out.println(inputs.get(N/2));
		
		sc.close();
		
	}

}

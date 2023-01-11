import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		int[] input = new int[100];
		int n = sc.nextInt();
		int result = 0;
		int target;
		
		for(int i = 0; i < n;i++)
			input[i] = sc.nextInt();
		
		target = sc.nextInt();
		
		for(int i = 0; i < n; i++)
			if(target == input[i])
				result++;
		
		System.out.println(result);
	}
}

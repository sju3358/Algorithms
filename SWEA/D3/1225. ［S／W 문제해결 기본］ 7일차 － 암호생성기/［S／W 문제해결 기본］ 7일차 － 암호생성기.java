import java.util.*;

public class Solution {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		
		for(int t = 0; t < 10; t++) {
			
			Queue<Integer> password = new LinkedList<>(); 
			
			scanner.nextInt();
			
			for(int i = 0; i < 8; i++) 
				password.add(scanner.nextInt());
			
			int cnt = 0;
			while(true) {
				
				int nextNum = password.peek() - (cnt+1);
				if(nextNum <= 0)
					nextNum = 0;
				
				password.add(nextNum);
				password.poll();
				cnt = (cnt+1)%5;
				
				if(nextNum == 0)
					break;
			}
			
			System.out.print("#" + (t+1) + " ");
			for(int num : password)
				System.out.print(num + " ");
			
			System.out.println();
		}
	}
}
import java.util.Scanner;
import java.util.*;



public class Main {
	
	
	
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		PriorityQueue<Integer> absPQ = new PriorityQueue<>((num1, num2)->{
			if(Math.abs(num1) == Math.abs(num2))
				return num1 - num2;
			else
				return Math.abs(num1) - Math.abs(num2);
		});
		
		for(int i = 0; i <n; i++) {
			int input = scanner.nextInt();
			
			if(input == 0) {
				if(absPQ.isEmpty() == true)
					System.out.println(0);
				else
					System.out.println(absPQ.poll());
			}
			else
				absPQ.add(input);
		}
		
	}
}
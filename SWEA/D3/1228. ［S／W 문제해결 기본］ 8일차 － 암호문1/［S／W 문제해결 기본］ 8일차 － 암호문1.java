import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		for(int t = 1; t <=10; t++) {
			ArrayList<Integer> password = new ArrayList<Integer>();
			
			int n = scanner.nextInt();
			
			for(int i = 0; i <n; i++)
				password.add(scanner.nextInt());
			
			n = scanner.nextInt();
			scanner.nextLine();
			String[] instructions = scanner.nextLine().split(" ");
			
			for(int i = 0; i <instructions.length; i++) {
				if(instructions[i].equals("I")) {
					int x = Integer.parseInt(instructions[i+1]);
					int y = Integer.parseInt(instructions[i+2]);
					
					for(int j = 0; j < y; j++) {
						password.add(x+j, Integer.parseInt(instructions[i+2+j+1]));
					}
				}
			}
			System.out.print("#"+t + " ");
			for(int i = 0; i <10; i++) {
				System.out.print(password.get(i) + " ");
			}
			System.out.println();
		}
		
	}
}
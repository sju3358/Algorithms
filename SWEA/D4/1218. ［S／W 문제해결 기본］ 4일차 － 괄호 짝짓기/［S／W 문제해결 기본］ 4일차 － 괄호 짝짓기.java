import java.util.*;

public class Solution {
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		for(int t = 1; t <=10 ; t++) {
			Stack<Character> stack = new Stack<>();
			
			scanner.nextInt();
			scanner.nextLine();
			String string = scanner.nextLine();
			
			for(int i = 0; i <string.length(); i++)
			{
				if(stack.empty() ==  true)
					stack.push(string.charAt(i));
				else if(stack.peek() == '(' && string.charAt(i) == ')') 
					stack.pop();
				else if(stack.peek() == '{' && string.charAt(i) == '}') 
					stack.pop();
				else if(stack.peek() == '[' && string.charAt(i) == ']') 
					stack.pop();
				else if(stack.peek() == '<' && string.charAt(i) == '>') 
					stack.pop();
				else
					stack.push(string.charAt(i));
			}
			System.out.println("#" + t + " " + (stack.empty() ? 1 : 0));
		}
		
		scanner.close();
	}
}
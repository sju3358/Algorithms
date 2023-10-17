import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		long count = 0;

		for(int i = 0; i < n; i++){
			int input = Integer.parseInt(br.readLine());

			if(stack.isEmpty() == true)
				stack.push(input);
			else {
				if(stack.peek() > input)
					stack.push(input);
				else if(stack.peek() == input)
					continue;
				else{
					int lastValue = stack.peek();
					while(stack.isEmpty() != true && stack.peek() <= input){
						stack.pop();
					}
					count += input - lastValue;
					stack.push(input);
				}
			}
		}

		if(stack.size() > 1){
			int lastValue = stack.peek();
			while(stack.size() >1)
				stack.pop();
			int firstValue = stack.peek();
			count += firstValue - lastValue;
		}

		System.out.println(count);
	}
}
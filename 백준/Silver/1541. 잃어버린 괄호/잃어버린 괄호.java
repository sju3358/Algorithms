import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	
	
	public static void main(String args[]) throws IOException {

		Queue<Integer> answers = new LinkedList<>(); 
		
		Queue<Integer> numbers = new LinkedList<>();
		Queue<String> ops = new LinkedList<>();
		
		String input = br.readLine();
		
		st = new StringTokenizer(input,"+-");
		
		while(st.hasMoreTokens())
			numbers.add(Integer.parseInt(st.nextToken()));

		for(int i = 0; i < input.length(); i++)
			if(input.charAt(i) == '+' || input.charAt(i) == '-')
				ops.add(input.charAt(i) + "");
		
		int answer = numbers.poll();
		while(numbers.isEmpty() != true) {
			String op = ops.poll();
			
			if(op.equals("+") == true)
				answer += numbers.poll();
			else {
				answers.add(answer);
				answer = numbers.poll();
			}
		}
		answers.add(answer);
		
		int result = answers.poll();
		while(answers.isEmpty() != true)
			result -= answers.poll();

		System.out.println(result);
	}
}
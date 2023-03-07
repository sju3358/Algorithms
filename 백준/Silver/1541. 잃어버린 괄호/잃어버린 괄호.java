import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String args[]) throws IOException {


		ArrayList<Integer> numbers = new ArrayList<>();

		String input = br.readLine();

		int sum = 0;
		
		
		String number = "";
		for (int i = 0; i < input.length(); i++){

			if (input.charAt(i) == '-' || input.charAt(i) == '+') {
				sum += Integer.parseInt(number);
				number = "";

				if (input.charAt(i) != '+') {
					numbers.add(sum);
					sum = 0;
				}
			}
			else
				number += input.charAt(i);
		}

		sum += Integer.parseInt(number);
		numbers.add(sum);

		int answer = numbers.get(0);

		if (numbers.size() > 1){
			for (int i = 1; i < numbers.size(); i++)
				answer = answer - numbers.get(i);
		}

		System.out.println(answer);
	}
}
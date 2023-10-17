import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


	private static String reverse(String input){
		String reversed = "";
		for(int i = input.length()-1; i >=0; i--)
			reversed += input.charAt(i);
		return reversed;
	}

	private static int compare(String a, String b){
		for(int i = 0; i < a.length(); i++)
			if(a.charAt(i) != b.charAt(i))
				return a.charAt(i) - b.charAt(i);
		return 0;
	}


	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String answer = "";
		answer += input.charAt(0);


		for(int index = 1; index < input.length(); index++){
			String nextAnswer1 = answer + input.charAt(index);
			String nextAnswer2 = reverse(answer);
			nextAnswer2 += input.charAt(index);
			nextAnswer2 = reverse(nextAnswer2);

			if(compare(nextAnswer1,nextAnswer2) < 0)
				answer = nextAnswer1;
			else
				answer = nextAnswer2;
		}

		System.out.println(answer);
	}
}
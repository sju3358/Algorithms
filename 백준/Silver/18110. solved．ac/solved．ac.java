import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


	private static int N;
	private static int M;


	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if(N == 0){
			System.out.println(0);
			return;
		} else {

			int[] numbers = new int[N];

			for (int i = 0; i < N; i++)
				numbers[i] = Integer.parseInt(br.readLine());

			Arrays.sort(numbers);

			double trimmed_avg = N * 0.15;
			int rounded_avg = (int)Math.round(trimmed_avg);

			int sum = 0;
			for (int i = rounded_avg; i < N - rounded_avg; i++)
				sum += numbers[i];

			double answer = (double) sum / (N - (2 * rounded_avg));

			System.out.println(Math.round(answer));
		}
	}
}
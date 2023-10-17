import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[31];

		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 3;
		dp[3] = 0;
		dp[4] = 11;

		for(int i = 5; i <= n; i++){
			if(i%2 == 1)
				dp[i] = 0;
			else {
				dp[i] = dp[i - 2] * 3;
				for(int k = 4; i-k >=0; k+=2){
					dp[i] += dp[i-k] * 2;
				}
				dp[i] += 2;
			}
		}

		System.out.println(dp[n]);

	}
}
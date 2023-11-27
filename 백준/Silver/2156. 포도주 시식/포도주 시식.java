import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int solution(int[] wines){

		int[] dp = new int[wines.length];
		Arrays.fill(dp, -1);

		if(wines.length == 1)
			return wines[0];
		else if(wines.length == 2)
			return wines[0] + wines[1];
		else {

			dp[0] = wines[0];
			dp[1] = wines[0] + wines[1];
			dp[2] = Math.max(wines[0] + wines[1] , wines[0] + wines[2]);
			dp[2] = Math.max(dp[2] , wines[1] + wines[2]);

			for (int i = 3; i < dp.length; i++) {
					dp[i] = Math.max(dp[i], dp[i - 1]);
					dp[i] = Math.max(dp[i], dp[i - 2] + wines[i]);
					dp[i] = Math.max(dp[i], dp[i - 3] + wines[i] + wines[i - 1]);
			}

			return dp[dp.length - 1];
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] wines = new int[N];

		for(int i = 0; i < N; i++)
			wines[i] = Integer.parseInt(br.readLine());

		System.out.println(solution(wines));
	}
}
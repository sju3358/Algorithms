import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[] volumes;
	private static boolean[][] dp;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		volumes = new int[N];
		dp = new boolean[N][M+1];


		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			volumes[i] = Integer.parseInt(st.nextToken());

		if(S + volumes[0] <= M)
			dp[0][S+volumes[0]] = true;

		if(S - volumes[0] >= 0)
			dp[0][S-volumes[0]] = true;

		for(int song = 1; song < N; song++) {
			for (int volume = 0; volume < M+1; volume++) {
				if(dp[song-1][volume] == true){

					if(volume + volumes[song] <= M)
						dp[song][volume+volumes[song]] = true;

					if(volume - volumes[song] >= 0)
						dp[song][volume-volumes[song]] = true;
				}
			}
		}

		int answer = -1;

		for(int i = 0; i < M+1; i++)
			if(dp[N-1][i] == true)
				answer = Math.max(answer , i);

		System.out.println(answer);
	}
}
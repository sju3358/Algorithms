import java.io.*;
import java.util.*;

public class Main {

	private static int countOfPalindrome = 0;
	private static String originString;

	private static boolean[][] palindrome;
	private static int[] dp;

	private static int solution(){

		Arrays.fill(dp, Integer.MAX_VALUE);

		for(int i = 0; i < dp.length; i++){
			if(palindrome[0][i] == true)
				dp[i] = 1;
		}

		for(int right = 1; right < dp.length; right++){
			for(int left = 1; left <= right; left++){
				if(palindrome[left][right] == true){
					dp[right] = Math.min(dp[right], dp[left-1] + 1);
				}
			}
		}

		return dp[dp.length-1];
	}

	public static void makePalindrome(){

		//길이가 1
		for(int i = 0; i < palindrome.length; i++)
			palindrome[i][i] = true;

		//길이가 2이상
		for(int length = 2; length <= palindrome.length; length++){
			for(int right = length-1; right < palindrome.length; right++){

				int left = right - length + 1;

				if(originString.charAt(right) != originString.charAt(left))
					continue;

				if(right - left < 3){
					palindrome[left][right] = true;
				} else {
					if(palindrome[left+1][right-1] == true)
						palindrome[left][right] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		originString = br.readLine().trim();

		palindrome = new boolean[originString.length()][originString.length()];
		dp = new int[originString.length()];

		makePalindrome();
		System.out.println(solution());
	}
}
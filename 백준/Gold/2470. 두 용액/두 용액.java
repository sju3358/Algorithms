import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

	private static long[] liquids;

	private static long[] solution(){

		Arrays.sort(liquids);

		int minValueLeftIndex = 0;
		int minValueRightIndex = liquids.length-1;
		long minValue = liquids[minValueLeftIndex] + liquids[minValueRightIndex];

		int left = 0;
		int right = liquids.length-1;
		while(left < right){

			long value = liquids[left] + liquids[right];
			if(Math.abs(value) < Math.abs(minValue)){
				minValue = value;
				minValueLeftIndex = left;
				minValueRightIndex = right;
			}

			if(value > 0)
				right--;
			else
				left++;
		}

		return new long[]{liquids[minValueLeftIndex],liquids[minValueRightIndex]};
	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		liquids = new long[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < liquids.length; i++)
			liquids[i] = Long.parseLong(st.nextToken());

		long[] answer = solution();
		System.out.println(answer[0] + " " + answer[1]);
	}
}
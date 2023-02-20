import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static long lines[];
	
	public static long cutLine(long[] lines, long pivot) {
		long sum = 0;
		for (long line : lines)
			sum += line / pivot;

		return sum;
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		lines = new long[k];
		
		for(int i = 0; i <k; i++)
			lines[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(lines);
		
		
		long start = 1;
		long end = lines[lines.length-1];
		long mid;
		while (start < end) {

			if (end - start == 1) {
				long cutResult1 = cutLine(lines, start);
				long cutResult2 = cutLine(lines, end);

				if (cutResult2 < n)
					end = start;
				break;
			}

			mid = (start + end) / 2;

			long cutResult = cutLine(lines,mid);

			if (cutResult >= n)
				start = mid;
			else
				end = mid - 1;
		}

		System.out.println(end);
		
	}
}
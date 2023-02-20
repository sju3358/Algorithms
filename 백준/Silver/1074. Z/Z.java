import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static int solution(int n, int r, int c) {
		int cnt = 0;
		
		while (n > 0) {
			if (0 <= r && r < (n / 2) && 0 <= c && c < (n / 2)) {
				cnt += 0;
			}
			else if (0 <= r && r < (n / 2) && (n / 2) <= c && c < n) {
				cnt += (n / 2) * (n / 2);
				c = c - (n / 2);
			}
			else if ((n / 2) <= r && r < n && 0 <= c && c < (n / 2)) {
				cnt += (n / 2) * (n / 2) * 2;
				r = r - (n / 2);
			}
			else if ((n / 2) <= r && r < n && (n / 2) <= c && c < n) {
				cnt += (n / 2) * (n / 2) * 3;
				r = r - (n / 2);
				c = c - (n / 2);
			}

			n = n / 2;
		}

		return cnt;
	}
	
	public static void main(String args[]) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int end = 1;
		for (int i = 0; i < end; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int sizeOfMap = 1;
			for (int j = 0; j < n; j++)
				sizeOfMap *= 2;
			
			for (int j = 0; j < n; j++)
				sizeOfMap *= 2;
			
			System.out.println(solution(sizeOfMap, r, c));
		}
		

		
	}
	
	
}
import java.io.*;
import java.util.*;

public class Main {

	static int N, S;
	static long[] arr;
	static List<Long> left = new ArrayList<>();
	static List<Long> right = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new long[N];

		st = new StringTokenizer(input.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		solve(0, N / 2, 0, left);
		solve(N / 2, N, 0, right);

		Collections.sort(left);
		Collections.sort(right);

		long ans = getCnt();

		if (S == 0)
			ans--;

		System.out.println(ans);
	}

	public static void solve(int idx, int end, long sum, List<Long> list) {

		if (idx == end) {
			list.add(sum);
			return;
		}

		solve(idx + 1, end, sum + arr[idx], list);
		solve(idx + 1, end, sum, list);
	}

	public static long getCnt() {

		int pl = 0; 
		int pr = right.size() - 1; 
		long cnt = 0;

		while (pl < left.size() && pr >= 0) {

			long sum = left.get(pl) + right.get(pr);

			if (sum == S) {
				long a = left.get(pl);
				long cnt1 = 0;
				while (pl < left.size() && left.get(pl) == a) {
					pl++;
					cnt1++;
				}

				long b = right.get(pr);
				long cnt2 = 0;
				while (pr >= 0 && right.get(pr) == b) {
					pr--;
					cnt2++;
				}

				cnt += cnt1 * cnt2;
			}

			else if (sum < S)
				pl++;
			else
				pr--;
		}

		return cnt;
	}
}
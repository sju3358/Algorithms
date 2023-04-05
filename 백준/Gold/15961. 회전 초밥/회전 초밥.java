import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	
	static int N,D,K,C;
	
	static int[] dishes;
	static int[] selectDishesCount;
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		D = scanner.nextInt();
		K = scanner.nextInt();
		C = scanner.nextInt();
		
		dishes = new int[N];
		
		for(int i = 0; i < N; i++)
			dishes[i] = scanner.nextInt();
		
		selectDishesCount = new int[D+1];
		selectDishesCount[C] = 1;
		
		int maxCnt = -1;
		int cnt = 1;
		
		for(int i = 0; i < K; i++) {
			
			if(selectDishesCount[dishes[i]] == 0)
				cnt++;	
			selectDishesCount[dishes[i]]++;
		}
		
		maxCnt = cnt;
		
		int start = 0;
		int end = K-1;
		
		for(int i = 0; i < N; i++) {
			
			selectDishesCount[dishes[start]]--;
			if(selectDishesCount[dishes[start]] == 0)
				cnt--;
			
			start++;
			if(start == N)
				start = 0;
			
			end++;
			if(end == N)
				end = 0;
			
			if(selectDishesCount[dishes[end]] == 0)
				cnt++;
			selectDishesCount[dishes[end]]++;
			
			maxCnt = Math.max(maxCnt, cnt);
		}
		
		System.out.println(maxCnt);
	}
}
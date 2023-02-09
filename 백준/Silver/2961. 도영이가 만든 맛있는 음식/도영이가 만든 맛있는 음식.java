import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	

	
	static ArrayList<Long> sumOfSelectedSourIngredeints = new ArrayList<>();
	static ArrayList<Long> sumOfSelectedBitterIngredients = new ArrayList<>();
	
	static int[] sourIngredients;
	static int[] bitterIngredients;
	
	static int N;
	
	
	public static long getABS(long a, long b) {
		if(a > b)
			return a-b;
		else
			return b-a;
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
	
		sourIngredients = new int[N];
		bitterIngredients = new int[N];

		
		for(int i =0; i <N; i++) {
			sourIngredients[i] = scanner.nextInt();
			bitterIngredients[i] = scanner.nextInt();
		}
		
		
		
		for(int i = 1; i <=N; i++) {
			selectSourIngredients(i);
			selectBitterIngredients(i);
		}
		
		
		
		long min = Long.MAX_VALUE;
		
		
		
		
		
		for(int i = 0; i < sumOfSelectedSourIngredeints.size(); i++) {
			
			long differ = getABS(sumOfSelectedSourIngredeints.get(i),sumOfSelectedBitterIngredients.get(i));
			if(min > differ)
				min = differ;
		}
		
		System.out.println(min);

	}
	
	public static void selectSourIngredients(int m) {
		int[] curSeq = new int[m];
		getSumOfSelectedSourIngredients(curSeq,0,m);
	}
	
	public static void getSumOfSelectedSourIngredients(int[] curSeq, int cnt, int m) {
		if(cnt == m) {
			long sumOfSourIngredients = 1;
			for(int i  = 0; i <m; i++)
				sumOfSourIngredients *= sourIngredients[curSeq[i]];
			sumOfSelectedSourIngredeints.add(sumOfSourIngredients);
		}
		else {
			int start;
			if(cnt == 0)
				start = 0;
			else
				start = curSeq[cnt-1] + 1;
			
			for(int i = start; i < N; i++) {
				curSeq[cnt] = i;
				getSumOfSelectedSourIngredients(curSeq,cnt+1,m);
			}
		}
	}
	
	public static void selectBitterIngredients(int m) {
		int[] curSeq = new int[m];
		getSumOfSelectedBitterIngredients(curSeq,0,m);
	}
	
	public static void getSumOfSelectedBitterIngredients(int[] curSeq, int cnt, int m) {
		if(cnt == m) {
			long sumOfBitterIngredients = 0;
			for(int i  = 0; i <m; i++)
				sumOfBitterIngredients += bitterIngredients[curSeq[i]];
			sumOfSelectedBitterIngredients.add(sumOfBitterIngredients);
		}
		else {
			int start;
			if(cnt == 0)
				start = 0;
			else
				start = curSeq[cnt-1] + 1;
			
			for(int i = start; i < N; i++) {
				curSeq[cnt] = i;
				getSumOfSelectedBitterIngredients(curSeq,cnt+1,m);
			}
		}
	}
}
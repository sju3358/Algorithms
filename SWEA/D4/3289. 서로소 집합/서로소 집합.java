import java.util.Scanner;

public class Solution {

	static int N,M;
	static int T;
	
	static int[] set;
	
	
	public static void makeSet(int N) {
		set = new int[N];
		for(int i = 0; i < N; i++)
			set[i] = i;
	}
	
	public static int findParent(int n) {
		if(set[n] == n)
			return n;
		else
			return set[n] = findParent(set[n]);
	}
	
	public static boolean unionSet(int a, int b) {
		int parentA = findParent(a);
		int parentB = findParent(b);
		if(parentA != parentB) {
			set[parentB] = set[parentA];
			return true;
		}
		else
			return false;
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		T = scanner.nextInt();
		
		for(int t = 1; t <=T; t++) {
			
			N = scanner.nextInt();
			M = scanner.nextInt();
			
			makeSet(N);
			
			StringBuilder answer = new StringBuilder();
			
			for(int i = 0; i < M; i++) {
				int func = scanner.nextInt();
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				
				if(func == 0)
					unionSet(a-1,b-1);
				else if(func == 1) {
					int parentA = findParent(a-1);
					int parentB = findParent(b-1);
					answer.append(parentA == parentB ? "1" : "0");
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
		
		
	}
}
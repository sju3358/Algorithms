import java.util.Scanner;

public class Main {

	
	public static void getPermutation(int[] seq,int[] cur, boolean[] isVisited, int sizeOfCur, int m) {
		
		if (sizeOfCur == m) {
			for(int i = 0; i <sizeOfCur; i++)
				System.out.print(seq[cur[i]] + " ");
			System.out.println();
		}
		else {
			
			for (int i = 0; i < seq.length; i++) {
				
				if (isVisited[i] == true)
					continue;
				
				cur[sizeOfCur++] = i; 
				isVisited[i] = true;
				getPermutation(seq,cur,isVisited,sizeOfCur--,m);
				isVisited[i] = false;
				
			}
		}
	}



	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		
		int[] seq = new int[n];
		boolean[] isVisited = new boolean[n];
		
	
		for (int i = 0; i < n; i++) {
			seq[i] = i+1;
			isVisited[i] = false;
		}
		

		int[]  cur = new int[m];
		getPermutation(seq, cur, isVisited,0, m);
		
	}
}
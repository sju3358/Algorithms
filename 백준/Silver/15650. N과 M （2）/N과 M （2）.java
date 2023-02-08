import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void Solution(int[] curIndex,int curSize, int []seq, boolean[] isVisit, int m) {
		if(curSize == m) {
			for(int i = 0; i <curIndex.length; i++)
				System.out.print(seq[curIndex[i]] + " ");
			System.out.println();
			
		}
		else {
			
			int start;
			if(curSize == 0)
				start = 0;
			else
				start = curSize-1;
			
			for(int i = curIndex[start]; i < seq.length; i++) {
				if(isVisit[i] == false) {
					isVisit[i] = true;
					curIndex[curSize] = i; 
					Solution(curIndex,curSize+1,seq,isVisit,m);
					isVisit[i] = false;
				}
			}
		}
	}

	public static void main(String args[]) {
		
		
		//선언
		Scanner scanner = new Scanner(System.in);
		int[] seq;
		boolean[] isVisit;
		int[] curIndex;
		
		
		//input
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		//초기화
		seq = new int[n];
		isVisit = new boolean[n];
		curIndex = new int[m];
		
		for(int i = 0; i < n; i++) {
			seq[i] = i+1;
			isVisit[i] = false;
		}
		
		//Solution
		Solution(curIndex,0,seq,isVisit,m);
		
	}
}
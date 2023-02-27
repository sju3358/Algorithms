import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;


class House{
	int i;
	int j;
	public House(int i, int j) {
		this.i = i;
		this.j = j;
	}
}



public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int startI, startJ;
	static int endI, endJ;
	static int minLength;
	static House[] customs;
	
	
	
	public static void getPermutation(int n, int m, int[] curIndex, boolean[] isVisit, int cnt) {
		
		if(cnt == m) {
			int curI = startI;
			int curJ = startJ;
			int sumOfLength = 0;
			for(int i = 0; i <  curIndex.length; i++) {
				House house = customs[curIndex[i]];
				sumOfLength += Math.abs(curI - house.i) + Math.abs(curJ - house.j);
				curI = house.i;
				curJ = house.j;
			}
			
			sumOfLength += Math.abs(curI - endI) + Math.abs(curJ - endJ);
			
			if(minLength > sumOfLength)
				minLength = sumOfLength;
			
		
		}
		else {
			for(int i = 0; i < n; i++) {
				if(isVisit[i] == false) {
					isVisit[i] = true;
					curIndex[cnt] = i;
					getPermutation(n,m,curIndex,isVisit,cnt+1);
					isVisit[i] = false;
				}
			}
		}
		
	}
	
	public static void nPm() {
		int[] curIndex = new int[customs.length];
		boolean[] isVisit = new boolean[customs.length];
		getPermutation(customs.length, customs.length, curIndex,isVisit,0);
	}
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int n = Integer.parseInt(br.readLine());
			customs = new House[n];
			minLength = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine(), " ");
			
			startI = Integer.parseInt(st.nextToken());
			startJ = Integer.parseInt(st.nextToken());
			
			endI = Integer.parseInt(st.nextToken());
			endJ = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < n; i++) {
				int indexI = Integer.parseInt(st.nextToken());
				int indexJ = Integer.parseInt(st.nextToken());
				customs[i] = new House(indexI,indexJ);
			}
			
			nPm();
						
			System.out.println("#"+t+" "+minLength);
		}
	}
}
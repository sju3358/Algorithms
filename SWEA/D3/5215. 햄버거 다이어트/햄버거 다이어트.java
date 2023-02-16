import java.util.Scanner;


class Hamburger{
	int score;
	int cal;
	
	public Hamburger(int score, int cal) {
		this.score = score;
		this.cal = cal;
	}
}


public class Solution {
	
	
	static int answer;
	static int maxCal;
	static Hamburger[] list;
	
	public static void getMaxScore(int n) {
		for(int i = 1; i <= n; i++) {
			int[] curIndex = new int[i];
			getCombination(n,i,curIndex,0);
		}
	}
	
	public static void getCombination(int n, int m, int[] curIndex, int cnt) {
		if(cnt == m) {
			int sumOfScore = 0;
			int sumOfCal = 0;
			for(int i = 0; i <m; i++) {
				sumOfScore += list[curIndex[i]].score;
				sumOfCal += list[curIndex[i]].cal;
			}
			
			if(sumOfCal <= maxCal) {
				if(answer < sumOfScore)
					answer = sumOfScore;
			}
		}
		else {
			int start = cnt == 0 ? 0 : curIndex[cnt-1] + 1;
			
			for(int i = start; i < n; i++) {
				curIndex[cnt] = i;
				getCombination(n,m,curIndex,cnt+1);
			}
		}
	}
	
	public static void main(String args[]) {  
		 
		Scanner scanner = new Scanner(System.in); 
		
		int T = scanner.nextInt();
		
		for(int test = 1; test <= T; test++) {
			
			answer = -1;
			int n = scanner.nextInt();
			list = new Hamburger[n];
			maxCal = scanner.nextInt();
			
			for(int i = 0; i <n; i++) {
				int score = scanner.nextInt();
				int cal = scanner.nextInt();
				
				list[i] = new Hamburger(score,cal);
			}
			
			getMaxScore(n);
			
			System.out.println("#" + test + " " + answer);
		}
		
	}
	
	
}
import java.util.Scanner;

public class Solution {

	
	static int countOfWin;
	static int countOfLose;
	static int[] you = new int[9];
	static int[] me = new int[9];
	static int[] forCheck;
	
	
	public static void whoIsWin(int[] array) {

		int sumOfIWin = 0;
		int sumOfYouWin = 0;
		
		for(int i = 0; i <9; i++) {
			if(me[array[i]] == you[i])
				continue;
			else if(me[array[i]] > you [i])
				sumOfIWin += me[array[i]] + you[i];
			else if(me[array[i]] < you [i])
				sumOfYouWin += me[array[i]] + you[i];
		}
		
		if(sumOfIWin == sumOfYouWin)
			return;
		else if(sumOfIWin > sumOfYouWin)
			countOfWin++;
		else if(sumOfIWin < sumOfYouWin)
			countOfLose++;
	}
	
	public static void getSumOfWinAndLose() {
		int[] curIndex = new int[9];
		boolean[] isVisit = new boolean[9];
		
		getPermutation(curIndex, isVisit, 0);
	}
	
	public static void getPermutation(int[] curIndex, boolean[] isVisit, int cnt) {
		if(cnt == 9) {
			whoIsWin(curIndex);
		}
		else {
			for(int i = 0; i <9; i++) {
				if(isVisit[i] == false) {
					isVisit[i] = true;
					curIndex[cnt] = i;
					getPermutation(curIndex, isVisit, cnt+1);
					isVisit[i] = false;
				}
			}
		}
	}
	
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		
		for(int test = 1; test <= T; test++) {
			
			countOfWin = 0;
			countOfLose = 0;

			forCheck = new int[18];
			for(int i = 0; i < 9; i++) {
				you[i] = scanner.nextInt();
				forCheck[you[i] - 1] = 1;
			}
			
			int cnt = 0;
			for(int i = 0; i <18; i++) {
				if(forCheck[i] != 1)
					me[cnt++] = i+1;
			}
			getSumOfWinAndLose();
			
			System.out.println("#" + test  + " " + countOfLose + " "  +countOfWin);
			
		}
	}
}
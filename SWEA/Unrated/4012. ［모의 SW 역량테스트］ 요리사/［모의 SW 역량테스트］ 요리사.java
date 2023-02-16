import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	
	
	static int min;
	static int[][] list;
	public static void main(String args[]) throws NumberFormatException, IOException {	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test ++) {
			
			min = Integer.MAX_VALUE;
			
			int n = Integer.parseInt(br.readLine());
			list = new int[n][n];
			for(int i = 0; i <n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()); 
				for(int j = 0; j <n; j++)
					list[i][j] = Integer.parseInt(st.nextToken());
			}
			
			nCm(n,n/2);
			
			System.out.println("#" + test + " " + min);
		}
		
	}
	
	public static void nCm(int n, int m) {
		int[] curIndex = new int[m];
		
		getCombination(n,m,curIndex,0);
	}
	
	public static void getCombination(int n, int m, int[] curIndex, int cnt) {
		if(cnt == m) {
			int diff = getDiff(curIndex);
			
			if(min > diff)
				min = diff;
		}
		else {
			
			int start = cnt == 0 ? 0 : curIndex[cnt-1] + 1;
			
			for(int i = start; i < n; i++) {
					curIndex[cnt] = i;
					getCombination(n,m,curIndex,cnt+1);
			}
		}
	}
	
	public static int getDiff(int[] selectedArr1) {
		
		int[] temp = new int[selectedArr1.length * 2];
		for(int i = 0; i <selectedArr1.length; i++)
			temp[selectedArr1[i]] = 1;
		
		int cnt = 0;
		int[] selectedArr2 = new int[selectedArr1.length];
		for(int i = 0; i < temp.length; i++)
			if(temp[i] !=1)
				selectedArr2[cnt++] = i;
			
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i = 0; i < selectedArr1.length - 1; i++) {
			for(int j = i + 1; j <selectedArr1.length; j++) {
				sum1 += list[selectedArr1[i]][selectedArr1[j]];
				sum1 += list[selectedArr1[j]][selectedArr1[i]];
			}
		}
		
		for(int i = 0; i < selectedArr2.length - 1; i++) {
			for(int j = i + 1; j <selectedArr2.length; j++) {
				sum2 += list[selectedArr2[i]][selectedArr2[j]];
				sum2 += list[selectedArr2[j]][selectedArr2[i]];
			}
		}
		
		
			
		return Math.abs(sum1 - sum2);
	}
}
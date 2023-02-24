import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int L,C;
	
	
	static char[] alphabets;
	static HashSet<Character> vowels;
	
	public static void dfs(String curString , int curIndex, int sumOfVowel, int sumOfCon) {
		
		if(curString.length() == L) {
			if(sumOfVowel >= 1 && sumOfCon >= 2)
				System.out.println(curString);
			return;
		}
		
		for(int i = curIndex+1; i < C; i++) {
			char nextChar = alphabets[i];
			
			if(vowels.contains(nextChar) == true) {
				dfs(curString + nextChar, i, sumOfVowel+1, sumOfCon);
			}
			else {
				dfs(curString + nextChar, i, sumOfVowel, sumOfCon+1);
			}
		}
		
	}
	
	public static void main(String args[]) throws IOException {
		
		
		st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabets = new char[C];
		
		vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('o');
		vowels.add('u');
		vowels.add('i');
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < C; i++)
			alphabets[i] = st.nextToken().charAt(0);
			
		
		Arrays.sort(alphabets);
		
		for(int i = 0; i < C; i++){
			if(vowels.contains(alphabets[i]) == true) {
				dfs(alphabets[i] + "",i, 1, 0);
			}
			else
				dfs(alphabets[i] + "",i, 0, 1);
		}
	}
}
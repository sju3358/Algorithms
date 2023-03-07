import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static Set<Long> savedNumbers;
	static PriorityQueue<Long> numbers;
	static ArrayList<Character> locker;
	
	public static long convertHexToDex(String numberHex) {
	
		int pivot = 1;
		long number = 0;
		for(int i = numberHex.length()-1; i>=0; i--) {
			char hex = numberHex.charAt(i);
			
			if('0' <= hex && hex <='9')
				number += (hex-'0')*pivot;
			else
				number += (hex-'A' + 10) * pivot;
			pivot = pivot * 16;
		}
			
		
		return number;
	}
	
	public static void rotateLocker() {
		char temp = locker.get(locker.size()-1);
		locker.remove(locker.size()-1);
		locker.add(0,temp);
	}
	
	public static void getNumbers(int N) {

		int duplicatedCount = 0;
		
		int pivot = N/4;
		
		while(duplicatedCount < 4) {
			duplicatedCount = 0;
			
			String numberHex = "";
			for(int i = 0; i < locker.size(); i++) {
				if(i % pivot == 0) {
					
					long number = convertHexToDex(numberHex);
					
					if(savedNumbers.contains(number) == true)
						duplicatedCount++;
					else {
						savedNumbers.add(number);
						numbers.add(number*-1);
					}
					
					numberHex = "";
				}
				numberHex += locker.get(i);
			}
			
			rotateLocker();
		}	
	}

	public static void main(String args[]) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t= 1; t<=T; t++) {
			
			savedNumbers = new HashSet<>();
			numbers = new PriorityQueue<>();
			locker = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String input = br.readLine();
			
			for(int i = 0; i <input.length(); i++)
				locker.add(input.charAt(i));
			
			getNumbers(N);
			
			for(int i = 0; i < K-1; i++)
				numbers.poll();
			
			System.out.println("#"+t+" "+numbers.peek()*(-1));
		}
		
	}
}
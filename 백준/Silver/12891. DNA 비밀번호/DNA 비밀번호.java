import java.util.Scanner;

public class Main {
	
	public static boolean isValidPassword(int[] curLetters, int[] maxLetters) {
		for(int i = 0; i < 4; i++)
			if(curLetters[i] < maxLetters[i])
				return false;
		return true;
	}
	
	public static void main(String args[]) {
		
		int result = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		int[] curLetters = new int[4];
		int[] maxLetters = new int[4];
		
		int S = scanner.nextInt();
		int P = scanner.nextInt();
		scanner.nextLine();
		String randomSeq = scanner.nextLine();
		
		char[] seq = new char[S];
		
		for(int i = 0; i<S; i++)
			seq[i] = randomSeq.charAt(i);
			
		for(int i = 0; i <4; i++) {
			curLetters[i] = 0;
			maxLetters[i] = scanner.nextInt();
		}
		
		
		
		int i = 0;
		int j = P-1;
		
		for(int index = i; index < P; index ++){
			switch(seq[index]) {
				case 'A':
					curLetters[0]++;
					break;
				case 'C':
					curLetters[1]++;
					break;
				case 'G':
					curLetters[2]++;
					break;
				case 'T':
					curLetters[3]++;
					break;
			}
		}
		
		while(true) {
			
			if(isValidPassword(curLetters,maxLetters))
				result++;
			
			if(j == S-1)
				break;
			
			switch(seq[i++]) {
				case 'A':
					curLetters[0]--;
					break;
				case 'C':
					curLetters[1]--;
					break;
				case 'G':
					curLetters[2]--;
					break;
				case 'T':
					curLetters[3]--;
					break;
			}
			
			switch(seq[++j]) {
				case 'A':
					curLetters[0]++;
					break;
				case 'C':
					curLetters[1]++;
					break;
				case 'G':
					curLetters[2]++;
					break;
				case 'T':
					curLetters[3]++;
					break;
			}
		}
		System.out.println(result);
	}
}
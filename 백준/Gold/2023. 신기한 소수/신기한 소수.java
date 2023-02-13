import java.util.Scanner;

public class Main {
	
	static String[] startNumbers = {"2","3","5","7"};
	static String[] endNumbers = {"1","3","7","9"};
	
	
	public static boolean isPrimeNumber(int n) {
		
		for(int i = 2; i*i <= n; i++)
			if(n%i == 0)
				return false;
		return true;
	}
	
	public static void getPrimeNumber(String cur, int n) {
		if(cur.length() == n) {
				System.out.println(cur);
		}
		else {
			if(cur.length() == 0) {
				for(int i = 0; i < startNumbers.length; i++)
					if(isPrimeNumber(Integer.parseInt(cur+startNumbers[i])))
						getPrimeNumber(cur+startNumbers[i],n);
			}
			else {
				for(int i = 0; i < endNumbers.length; i++) {
					if(isPrimeNumber(Integer.parseInt(cur+endNumbers[i])))
						getPrimeNumber(cur+endNumbers[i],n);
				}
			}
		}
	}
	
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		getPrimeNumber("",n);
	}
}
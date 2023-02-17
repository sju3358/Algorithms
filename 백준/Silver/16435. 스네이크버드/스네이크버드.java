import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] fruits;
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		fruits = new int[n];
		
		int l = scanner.nextInt();
		
		for(int i = 0; i <n; i++)
			fruits[i] = scanner.nextInt();
		
		Arrays.sort(fruits);
		
		for(int i = 0; i < n && l >= fruits[i]; i++)
			l++;
		
		System.out.println(l);
 	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String args[]){
		
		BigInteger bigInteger1 = new BigInteger("1");
		BigInteger bigInteger2 = new BigInteger("1");
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		for(int i = 0; i < r; i++) {
			BigInteger temp = new BigInteger("" + n);
			bigInteger1 = bigInteger1.multiply(temp);
			n--;
		}
		
		for(int i = 1; i <= r; i++) {
			BigInteger temp = new BigInteger("" + i);
			bigInteger2 = bigInteger2.multiply(temp);
		}
		
		BigInteger result = bigInteger1.divide(bigInteger2);
		System.out.println(result);
	}
}
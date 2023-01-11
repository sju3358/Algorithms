import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		int totalPrice = sc.nextInt();
		int n = sc.nextInt();
		int currentPrice = 0;
		
		for(int i = 0; i<n; i++) {
			int price = sc.nextInt();
			int amount = sc.nextInt();
			
			currentPrice += price*amount;
		}
		
		if(totalPrice == currentPrice)
			System.out.println("Yes");
		else
			System.out.println("No");
		
		
		
		
		sc.close();
	}
}

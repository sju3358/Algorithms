import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> numList = new ArrayList<>();
		
		int sum = 0;
		
		for(int i = 0; i<5; i++) {
			int temp = sc.nextInt();
			numList.add(temp);
			sum += temp;
		}
		
		Collections.sort(numList);
		
		System.out.println(sum/5);
		System.out.println(numList.get(2));
		
		sc.close();
	}
}

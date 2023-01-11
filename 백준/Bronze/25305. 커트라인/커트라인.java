import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> scores = new ArrayList<>();
		
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i = 0; i< N; i++) {
			int temp = sc.nextInt();
			scores.add(temp);
		}
		
		Collections.sort(scores,Collections.reverseOrder());
		
		System.out.println(scores.get(k-1));
		
		sc.close();
	}
}

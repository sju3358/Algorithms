import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		Queue<Integer> seq = new LinkedList<Integer>();
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i = 0; i <n; i++)
			seq.add(i+1);
		
		while(seq.isEmpty() != true) {
			for(int i = 0; i < k-1 ; i++)
				seq.add(seq.poll());
			answer.add(seq.poll());
		}
		
		System.out.print('<');
		for(int i = 0; i < answer.size()-1; i++)
			System.out.print(answer.get(i) + ", ");
		System.out.print("" + answer.get(answer.size()-1) + '>');
	}
}
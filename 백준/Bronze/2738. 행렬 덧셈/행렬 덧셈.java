import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<ArrayList<Integer>> matrixA = new ArrayList<>();
		ArrayList<ArrayList<Integer>> matrixB = new ArrayList<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		int N, M;
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		for(int i = 0; i < M; i++) {
			ArrayList<Integer> input = new ArrayList<>();
			for(int j = 0; j< N; j++) {
				int temp = sc.nextInt();
				input.add(temp);
			}
			matrixA.add(input);
		}
		
		for(int i = 0; i < M; i++) {
			ArrayList<Integer> input = new ArrayList<>();
			for(int j = 0; j< N; j++) {
				int temp = sc.nextInt();
				input.add(temp);
			}
			matrixB.add(input);
		}
		
		
		for(int i = 0; i < M; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j = 0; j< N; j++) {
				temp.add(matrixA.get(i).get(j) + matrixB.get(i).get(j));
			}
			result.add(temp);
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j< N; j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
				
		
		sc.close();
	}
}

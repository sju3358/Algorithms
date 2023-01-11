import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] unit = {1,1,2,2,2,8};
		int input;
		int[] result = new int[6];
		
		for(int i = 0; i < 6; i++) {
			input = sc.nextInt();
			result[i] = unit[i] - input;
			System.out.print(result[i] + " ");
		}
	}
}

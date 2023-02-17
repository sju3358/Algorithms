import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] numbers = new int[9];
	static int[] answers;
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		int[] curIndex = new int[7];
		getDwarf(curIndex,0,0);
		
		for(int index : answers)
			System.out.println(numbers[index]);
	}
	
	public static void getDwarf(int[] curIndex,int sum, int cnt) {
		if(cnt == 7) {
			if(sum == 100) {
				Arrays.sort(curIndex);
				answers = Arrays.copyOf(curIndex, curIndex.length);
			}
		}
		else {
			int start = cnt == 0 ? 0 : curIndex[cnt-1] + 1;
			for(int i = start; i < 9; i++) {
				curIndex[cnt] = i;
				getDwarf(curIndex,sum + numbers[i] ,cnt+1);
			}
		}
	}
	
}
import java.util.Scanner;

public class Main {

	public static void onOrOffSwitches(int[] switches, int index) {
		
			if(switches[index] == 1)
				switches[index] = 0;
			else
				switches[index] = 1;
		
	}
	
	public static void boy(int[] switches, int pivot) {
		for(int i = 0; i <switches.length; i++) {
			if((i+1) % pivot == 0) {
				onOrOffSwitches(switches,i);
			}
 		}
	}
	
	public static void girl(int[] switches, int pivot) {
		
		pivot = pivot -1;
		
		int index = 0;
		int left = pivot - index;;
		int right = pivot + index;;
		
		while(0 <= left && right < switches.length) {
			
			
			
			if(switches[left] == switches[right]) {
				onOrOffSwitches(switches,left);
				
				if(left != right)
					onOrOffSwitches(switches,right);
			}
			else
				break;
			
			index++;
			left = pivot - index;
			right = pivot + index;
		}
		
		
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] switches = new int[n];
		
		for(int i = 0; i < n; i++)
			switches[i] = scanner.nextInt();
		
		
		n = scanner.nextInt();
		int[][] students = new int[n][2];
		
		for(int i = 0; i <n; i++)
		{
			students[i][0] = scanner.nextInt();
			students[i][1] = scanner.nextInt();
		}
		
		for(int i = 0; i <n; i++) {
			switch(students[i][0]) {
				case 1: boy(switches,students[i][1]);
					break;
				case 2: girl(switches,students[i][1]);
					break;
			}
		}
		
		for(int i = 0; i < switches.length; i++) {
			if((i+1) % 20 == 0)
				System.out.println(switches[i]);
			else
				System.out.print(switches[i] + " ");
		}
	}
}
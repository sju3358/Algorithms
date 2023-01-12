import java.util.*;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		int[] freq = new int[8001]; // -4000 ~ 4000
		
		double average = 0;
		int median = 0;
		int mode = 0;
		int range = 0;
		
		for(int i = 0; i < 8001 ; i++)
			freq[i] = 0;
		
		int N = sc.nextInt();
		
		
		int max = -4001;
		int min = 4001;
		for(int i = 0; i < N; i++) {
			
			int number = sc.nextInt();
			
			numbers.add(number);
			
			average += number;
			
			freq[number+4000]++;
			
			if(max < number)
				max = number;
			if(min > number)
				min = number;
		}
		Collections.sort(numbers);
		
		
		average /= N;
		median = numbers.get(N/2);
		range = max - min;
		
		max = 0;
		for(int i = 0; i < 8001; i++)
			if(max < freq[i])
				max = freq[i];
		
		ArrayList<Integer> means = new ArrayList<Integer>();
		for(int i = 0; i < 8001; i++)
			if(max == freq[i])
				means.add(i);
		
		Collections.sort(means);
		
		if(means.size() > 1)
			mode = means.get(1);
		else
			mode = means.get(0);
		
		mode = mode - 4000;
		
		System.out.println(Math.round(average));
		System.out.println(median);
		System.out.println(mode);
		System.out.println(range);
		
		
		
		
		sc.close();
	}
}

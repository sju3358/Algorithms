import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {

	private static class Jewelry{

		int weight;
		int value;

		public Jewelry(int weight, int value){
			this.weight = weight;
			this.value = value;
		}
	}

	private static TreeSet<Integer> bags;
	private static HashMap<Integer, Integer> bagsCount;
	private static PriorityQueue<Jewelry> jewelries;

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		jewelries = new PriorityQueue<>((jewelry1, jewelry2) -> {
			if(jewelry1.value == jewelry2.value)
				return jewelry1.weight - jewelry2.weight;
			else
				return jewelry2.value - jewelry1.value;
		});
		bags = new TreeSet<>();
		bagsCount = new HashMap<>();

		for(int i = 0; i < N; i++){

			st = new StringTokenizer(br.readLine());

			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			jewelries.add(new Jewelry(weight,value));
		}

		for(int i = 0; i < K; i++){
			int bag = Integer.parseInt(br.readLine().trim());
			bags.add(bag);

			if(bagsCount.containsKey(bag))
				bagsCount.put(bag, bagsCount.get(bag) + 1);
			else
				bagsCount.put(bag,1);
		}

		Long maxValue = 0L;

		while(jewelries.isEmpty() != true){

			Jewelry jewelry = jewelries.poll();
			Integer upperBound = bags.ceiling(jewelry.weight);

			if(upperBound != null){
				maxValue += jewelry.value;

				bagsCount.put(upperBound, bagsCount.get(upperBound) - 1);
				if(bagsCount.get(upperBound) == 0){
					bags.remove(upperBound);
					bagsCount.remove(upperBound);
				}

			}
		}

		System.out.println(maxValue);
	}
}
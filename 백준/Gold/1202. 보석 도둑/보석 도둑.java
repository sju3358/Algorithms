import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
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

	private static Jewelry[] jewelries;
	private static TreeSet<Integer> bags;
	private static HashMap<Integer, Integer> bagsCount;

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		jewelries = new Jewelry[N];
		bags = new TreeSet<>();
		bagsCount = new HashMap<>();

		for(int i = 0; i < N; i++){

			st = new StringTokenizer(br.readLine());

			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			jewelries[i] = new Jewelry(weight,value);
		}

		for(int i = 0; i < K; i++){
			int bag = Integer.parseInt(br.readLine().trim());
			bags.add(bag);

			if(bagsCount.containsKey(bag))
				bagsCount.put(bag, bagsCount.get(bag) + 1);
			else
				bagsCount.put(bag,1);
		}

		Arrays.sort(jewelries,(jewelry1, jewelry2) -> jewelry2.value - jewelry1.value);

		Long maxValue = 0L;

		for(int i = 0; i < jewelries.length; i++){

			Integer upperBound = bags.ceiling(jewelries[i].weight);

			if(upperBound != null){
				maxValue += jewelries[i].value;

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
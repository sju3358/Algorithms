import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


	private static int[] inDegrees;
	private static boolean[][] map;

	public static String topologySort(){

		ArrayList<Integer> result = new ArrayList<>();

		Queue<Integer> queue = new LinkedList<>();


		for(int i = 0; i < inDegrees.length; i++){
			if(inDegrees[i] == 0)
				queue.add(i);
		}

		while(queue.isEmpty() != true){

			int curNode = queue.poll();

			result.add(curNode);

			for(int i = 0; i < map.length; i++){

				if(curNode == i)
					continue;

				if(map[curNode][i] == true){

					if(inDegrees[i] > 0)
						inDegrees[i]--;

					if(inDegrees[i] == 0)
						queue.add(i);
				}

			}
		}


		if(result.size() != inDegrees.length)
			return "0";

		String answer = "";
		for(int i = 0; i < result.size(); i++){
			answer += (result.get(i)+1) + "\n";
		}
		return answer;
	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		inDegrees = new int[N];
		map = new boolean[N][N];

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());

			int countOfSingers = Integer.parseInt(st.nextToken());

			int prevSinger = Integer.parseInt(st.nextToken())-1;
			for(int j = 0; j < countOfSingers-1; j++){

				int nextSinger = Integer.parseInt(st.nextToken())-1;

				if( map[prevSinger][nextSinger] == false) {
					map[prevSinger][nextSinger] = true;
					inDegrees[nextSinger]++;
				}

				prevSinger = nextSinger;
			}
		}

		System.out.println(topologySort());
	}
}
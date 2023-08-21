import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static class Node{
		int value;
		String history;
		public Node(int value, String history){
			this.value = value;
			this.history = history;
		}
	}
	private static boolean[] visited;
	private static int minCost;
	private static String minHistory;
	private static int instructionD(int value){
		value = value * 2;
		value = value % 10000;
		return value;
	}

	private static int instructionS(int value){
		value = value-1;
		if(value < 0)
			value = 9999;

		return value;
	}

	private static int instructionL(int value){
		int Lvalue = value / 1000;

		value =  value - Lvalue * 1000;
		value = value * 10;
		value = value +  Lvalue;
		return value;
	}

	private static int instructionR(int value){
		int Rvalue = value % 10;
		value = value  / 10;
		value = value + 1000*Rvalue;
		return value;
	}

	private static void solution(int start, int target){

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start, ""));

		while(queue.isEmpty() != true){

			Node curNode = queue.poll();
			int curValue = curNode.value;

			if(curNode.history.length() > minCost)
				continue;

			if(curNode.value == target){
				if(minCost > curNode.history.length()){
					minCost = curNode.history.length();
					minHistory = curNode.history;
				}
			}

			int nextValue;

			nextValue = instructionL(curValue);
			if(visited[nextValue] != true) {
				queue.add(new Node(nextValue, curNode.history + "L"));
				visited[nextValue] = true;
			}

			nextValue = instructionR(curValue);
			if(visited[nextValue] != true) {
				queue.add(new Node(nextValue, curNode.history + "R"));
				visited[nextValue] = true;
			}

			nextValue = instructionD(curValue);
			if(visited[nextValue] != true) {
				queue.add(new Node(nextValue, curNode.history + "D"));
				visited[nextValue] = true;
			}

			nextValue = instructionS(curValue);
			if(visited[nextValue] != true) {
				queue.add(new Node(nextValue, curNode.history + "S"));
				visited[nextValue] = true;
			}
		}


	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++){


			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			visited = new boolean[10000];
			minCost = Integer.MAX_VALUE;
			solution(start,target);

			System.out.println(minHistory);
		}
	}
}
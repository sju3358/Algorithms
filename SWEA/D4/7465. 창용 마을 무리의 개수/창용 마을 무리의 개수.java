import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static Scanner scanner = new Scanner(System.in);
	
	static int T;
	static int N,M;
	static boolean[] visited;
	static int answer;
	static ArrayList<ArrayList<Integer>> persons;
	
	
	public static void getLength(int start) {
		
		Queue<Integer> nextPerson = new LinkedList<>();
		nextPerson.add(start);
		visited[start] = true;
		
		while(nextPerson.isEmpty() != true) {
			int curPerson = nextPerson.poll();
			
			for(int i = 0; i < persons.get(curPerson).size(); i++) {
				int temp = persons.get(curPerson).get(i);
				if(visited[temp] == false) {
					visited[temp] = true;
					nextPerson.add(temp);
				}
			}
		}
	}
	
	public static void main(String args[]) {
		
		T = scanner.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			N = scanner.nextInt();
			M = scanner.nextInt();
			
			persons = new ArrayList<ArrayList<Integer>>();
			visited = new boolean[N];
			for(int i = 0; i < N; i++)
				persons.add(new ArrayList<Integer>());
			
			for(int i = 0; i < M; i++) {
				int person1 = scanner.nextInt();
				int person2 = scanner.nextInt();
				
				person1--;
				person2--;
				
				persons.get(person1).add(person2);
				persons.get(person2).add(person1);
			}
			
			answer = 0;
			for(int i = 0; i < N; i++)
				if(visited[i] == false) {
					getLength(i);
					answer++;
				}
			
			System.out.println("#" + t + " " + answer);
			
		}
		
	}
}
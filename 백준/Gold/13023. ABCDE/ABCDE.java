import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	
	static boolean[] visited;
	
	static ArrayList<ArrayList<Integer>> friends;
	
	static Scanner scanner = new Scanner(System.in);
	
	static int isExist = 0;
	
	
	public static void main(String args[]) {
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		friends = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <n ;i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			friends.add(temp);
		}
		
		for(int i = 0; i < m; i++) {
			int friend1 = scanner.nextInt();
			int friend2 = scanner.nextInt();
			friends.get(friend1).add(friend2);
			friends.get(friend2).add(friend1);
		}
		
		for(int i = 0; i < n; i++) {
			if(isExist == 0) {
				visited = new boolean[n];
				visited[i] = true;
				dfs(i,1);
			}
		}
		
		System.out.println(isExist);
	}
	
	public static void dfs(int curFriend, int length) {
		
		if(length == 5) {
			isExist = 1;
			return;
		}
		else {
			for(int i = 0; i < friends.get(curFriend).size(); i++) {
				int nextFriend = friends.get(curFriend).get(i);
				if(visited[nextFriend] == false && isExist == 0) {
					
					visited[nextFriend] = true;
					dfs(nextFriend, length+1);
					
					if(isExist == 0)
						visited[nextFriend] = false;
				}
			}
			
		}
	}
}
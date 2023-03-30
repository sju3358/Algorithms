import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N,M;
	static int[][] map;
	
	static int[] dirI = {1,-1,0,0};
	static int[] dirJ = {0,0,1,-1};
	
	static class Node{
		int i;
		int j;
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static int maxSafeArea = -1;
	
	public static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < N && 0 <= j && j < M; 
	}
	
	public static void solution(int[][] newMap) {
		
		
		Queue<Node> nextNode = new LinkedList<>();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(newMap[i][j] == 2)
					nextNode.add(new Node(i,j));
					
		
		while(nextNode.isEmpty() != true) {
			Node curNode = nextNode.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextI = curNode.i + dirI[i];
				int nextJ = curNode.j + dirJ[i];
				
				if(isInBoundary(nextI,nextJ) != true)
					continue;
				
				if(newMap[nextI][nextJ] == 0) {
					newMap[nextI][nextJ] = 2;
					nextNode.add(new Node(nextI,nextJ));
				}
			}
		}
		
		int safeArea = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(newMap[i][j] == 0)
					safeArea++;
		
		if(maxSafeArea < safeArea)
			maxSafeArea = safeArea;
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		map = new int[N][M];
		Node seq[] = new Node[N*M];
		
		int cnt = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) {
				map[i][j] = scanner.nextInt();
				seq[cnt++] = new Node(i,j);
			}
		
		
		for(int i = 0; i  < seq.length - 2; i++) {
			

			Node wall1 = seq[i];
			if(map[wall1.i][wall1.j] != 0)
				continue;
			
			for(int j = i+1; j < seq.length - 1; j++) {
				
				
				Node wall2 = seq[j];
				if(map[wall2.i][wall2.j] != 0)
					continue;
					
				for(int k = j+1; k < seq.length; k++) {
					
					
					
					Node wall3 = seq[k];
					if(map[wall3.i][wall3.j] != 0)
						continue;
					
					int[][] newMap = new int[N][M];
					
					for(int t1 = 0; t1 < N; t1++)
						for(int t2 = 0; t2 <M; t2++)
							newMap[t1][t2] = map[t1][t2];
					
					newMap[wall1.i][wall1.j] = 1;
					newMap[wall2.i][wall2.j] = 1;
					newMap[wall3.i][wall3.j] = 1;
					
					
					
					solution(newMap);
				}
			}
		}
		
		
		
		System.out.println(maxSafeArea);
	}
}
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



class Pair{
	int x;
	int y;
	
	public Pair() {}
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}



public class Solution {
	
	
	static int SIZE_OF_MAP = 100;
	
	public static boolean isInBound(Pair pair) {
		
		if(0 <= pair.x && pair.x < SIZE_OF_MAP && 0 <= pair.y && pair.y < SIZE_OF_MAP)
			return true;
		else
			return false;
		

	}
	
	public static boolean bps(int[][] map, boolean[][] isVisited, Pair start) {
		
		Queue<Pair> bpsQueue = new LinkedList<>(); 
		
		bpsQueue.add(start);
		isVisited[start.x][start.y] = true;
		
		while(bpsQueue.isEmpty() == false) {
			Pair curNode = bpsQueue.peek();
			bpsQueue.poll();
			
			if(map[curNode.x][curNode.y] == 2)
				return true;
			
			Pair nextNode1 = new Pair(curNode.x, curNode.y - 1);
			Pair nextNode2 = new Pair(curNode.x, curNode.y + 1);
			Pair nextNode3 = new Pair(curNode.x+1, curNode.y);
			
			
			boolean isInBound1 = isInBound(nextNode1);
			boolean isInBound2 = isInBound(nextNode2);
			
			if(isInBound1 || isInBound2) {

				boolean isAnyNode = false;;
				if(isInBound1 && map[nextNode1.x][nextNode1.y] != 0 && isVisited[nextNode1.x][nextNode1.y] == false) {
					bpsQueue.add(nextNode1);
					isVisited[nextNode1.x][nextNode1.y] = true;
					isAnyNode = true;
				}
				if(isInBound2 && map[nextNode2.x][nextNode2.y] != 0 && isVisited[nextNode2.x][nextNode2.y] == false) {
					bpsQueue.add(nextNode2);
					isVisited[nextNode2.x][nextNode2.y] = true;
					isAnyNode = true;
				}
				
				if(!isAnyNode)
					if(isInBound(nextNode3) && map[nextNode3.x][nextNode3.y] != 0 && isVisited[nextNode3.x][nextNode3.y] == false) {
						isVisited[nextNode3.x][nextNode3.y] = true;
						bpsQueue.add(nextNode3);
					}
						
			}
			else {
				if(isInBound(nextNode3) && map[nextNode3.x][nextNode3.y] != 0 && isVisited[nextNode3.x][nextNode3.y] == false) {
					isVisited[nextNode3.x][nextNode3.y] = true;
					bpsQueue.add(nextNode3);
				}

			}
			
		}
		
		return false;
	}
	
	public static int findStartingPoint(int[][] map) {

		int startingPoint = -1;
		
		
		
		
		for(int i = 0; i < map.length; i++) {
			if(map[0][i] == 1) {
				
				boolean[][] isVisited = new boolean[SIZE_OF_MAP][SIZE_OF_MAP];
				
				for(int j = 0; j <map.length; j++)
					for(int k = 0; k <map.length; k++)
						isVisited[i][j] = false;
				
				if(bps(map,isVisited, new Pair(0,i)))
					startingPoint = i;
			}
		}
		
		return startingPoint;
		
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++) {
			
			int[][] map = new int[SIZE_OF_MAP][SIZE_OF_MAP];
			
			scanner.nextInt();
			
			for(int i = 0; i < SIZE_OF_MAP; i++) {
				for(int j = 0; j <SIZE_OF_MAP; j++) {
					map[i][j] = scanner.nextInt();
				}
			}
			
			
			int startIndex = findStartingPoint(map);
			
			System.out.println("#" + test_case + " " + startIndex);
			
		}
		
		scanner.close();
	}
}
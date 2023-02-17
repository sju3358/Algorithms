import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int i;
	int j;
	
	public Node(int i , int j) {
		this.i = i;
		this.j = j;
	}
}

class NodePair{
	Node curNode;
	Node fromNode;

	
	public NodePair(Node node, Node fromNode) {
		this.curNode = node;
		this.fromNode = fromNode;
	}
	

}
public class Main {
	
	static int[][] map;
	static ArrayList<Node> chickenShops = new ArrayList<Node>();
	static int minChickenLenght = Integer.MAX_VALUE;
	
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static boolean isInBoundary(int i, int j, int n) {
		return 0 <= i && i < n && 0 <= j && j < n;
	}
	
	public static int getChickenLength(int[][] map, Node[] chickenList) {
		int chickenLength = 0;
		
		boolean[][] isVisit = new boolean[map.length][map.length];
		
		Queue<NodePair> queue = new LinkedList<>();
		
		for(int i = 0; i < chickenList.length; i++) 
			queue.add(new NodePair(chickenList[i],chickenList[i]));
		
		
		while(queue.isEmpty() != true) {
			NodePair curNode = queue.poll();
			
			for(int i = 0; i <4; i++) {
				int nextI = curNode.curNode.i + dir[i][0];
				int nextJ = curNode.curNode.j + dir[i][1];
				
				
				if(isInBoundary(nextI, nextJ,map.length) == true) {
					if(isVisit[nextI][nextJ] == false) {
						isVisit[nextI][nextJ] = true;
						if(map[nextI][nextJ] == 1) {
							int lengthI = Math.abs(curNode.fromNode.i - nextI);
							int lengthJ = Math.abs(curNode.fromNode.j - nextJ);
							chickenLength += lengthI + lengthJ;
						}
						Node nextNode = new Node(nextI, nextJ);
						queue.add(new NodePair(nextNode, curNode.fromNode));
					}
					
				}
			}
			
		}
		
		return chickenLength;
	}
	
	public static boolean isNodeIn(Node node, int[] indexList) {
		
		for(int i = 0; i <indexList.length; i++) {
			if(node.equals(chickenShops.get(indexList[i])))
			return true;
		}
		return false;
	}
	
	public static void getCombination(int m, int[] curIndex, int cnt) {
		if(cnt == m) {
			int[][] newMap = map.clone();
			Node[] selectedChickenList = new Node[m];
			
			int indexOfSelectedChickenList = 0;
			
			for(int i = 0; i < curIndex.length; i++) {
				selectedChickenList[indexOfSelectedChickenList++] = chickenShops.get(curIndex[i]);
			}
			

			int chickenLength = getChickenLength(newMap, selectedChickenList);
			if(minChickenLenght >  chickenLength)
				minChickenLenght = chickenLength;
		}
		else {
			int start = cnt == 0 ? 0 : curIndex[cnt-1] + 1;
			for(int i = start; i < chickenShops.size(); i++) {
				curIndex[cnt] = i;
				getCombination(m, curIndex, cnt + 1);
			}
		}
	}
	
	
	public static void getMinLenght(int m) {
		int[] curIndex = new int[m];
		getCombination(m,curIndex,0);
	}
	

	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		map = new int[n][n];
		
		for(int i = 0; i <n; i++) {
			for(int j = 0; j <n; j++) {
				
				int input = scanner.nextInt();
				
				map[i][j] = input;
				
				if(input == 2)
					chickenShops.add(new Node(i,j));
			}
		}
		
		getMinLenght(m);
		
		System.out.println(minChickenLenght);
	}
	
}
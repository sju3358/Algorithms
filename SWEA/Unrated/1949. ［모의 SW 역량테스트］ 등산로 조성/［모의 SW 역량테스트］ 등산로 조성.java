import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static ArrayList<Node> topList;
	static int[][] map;
	static boolean[][] visited;
	
	
	static int N,K;
	static int maxLength;
	
	static int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
	
	private static class Node{
		int i;
		int j;
		int length;
		public Node(int i, int j, int length) {
			this.i = i;
			this.j = j;
			this.length = length;
		}
	}
	
	public static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < N && 0 <= j && j < N;
	}
	
	public static void getMaxLength(int curI, int curJ, boolean isCut, int length) {

		if(maxLength < length)
			maxLength = length;
		
		for(int i = 0; i < 4; i++) {
			int nextI = curI + dir[i][0];
			int nextJ = curJ + dir[i][1];
			
			if(isInBoundary(nextI, nextJ)){
				
				if(map[nextI][nextJ] < map[curI][curJ] && visited[nextI][nextJ] == false) {
					visited[nextI][nextJ] = true;
					getMaxLength(nextI,nextJ, isCut, length+1);
					visited[nextI][nextJ] = false;
				}
				else {
					int diff = map[nextI][nextJ] - map[curI][curJ];
					if(diff + 1 <= K && isCut == false && visited[nextI][nextJ] == false) {
						visited[nextI][nextJ] = true;
						map[nextI][nextJ] = map[nextI][nextJ] - (diff+1);
						getMaxLength(nextI,nextJ,true, length+1);
						map[nextI][nextJ] = map[nextI][nextJ] + (diff+1);
						visited[nextI][nextJ] = false;
					}
				}
				
			}
		}
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			
			//최대값 구하기
			int maxHeight = -1;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j < N; j++) {
					int height = Integer.parseInt(st.nextToken());
					map[i][j] = height;
					
					if(maxHeight < height)
						maxHeight = height;
				}
			}
			
			
			//최대값 리스트 구하기
			topList = new ArrayList<>();
			
			for(int i = 0; i <N; i++) 
				for(int j = 0; j < N; j++) 
					if(map[i][j] == maxHeight)
						topList.add(new Node(i,j,1));
				
			
			
			//최대 길이 구하기
			maxLength = -1;
			
			for(int i = 0; i < topList.size(); i++) {
				Node startNode = topList.get(i);
				visited = new boolean[N][N];
				visited[startNode.i][startNode.j] = true;
				getMaxLength(startNode.i,startNode.j,false,startNode.length);
			}
			
			//정답 출력
			System.out.println("#" + t + " " + maxLength);
		
			
		}
	}
}
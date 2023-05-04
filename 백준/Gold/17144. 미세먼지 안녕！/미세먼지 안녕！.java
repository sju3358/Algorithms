import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
	    int i;
	    int j;
	    int amount;
	    
	    public Node(int i, int j, int amount) {
	    	this.i = i;
	    	this.j = j;
	    	this.amount = amount;
	    }
	}
	
	static int[][] map;
	static int R,C,T;
	static int[] filter = new int[2];
	
	static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	
	static void print() {
		System.out.println("---------------------");
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
	
	static boolean isInBoundary(int i, int j) {
		return 0 <= i && i <R && 0 <= j && j < C;
	}
	
	static void spread(){
		
		Queue<Node> nextNode = new LinkedList<>();
		
		for(int i = 0; i < R; i++)
			for(int j = 0; j < C; j++)
				if(map[i][j] > 0)
					nextNode.add(new Node(i,j,map[i][j]));
		
		int[][] newMap = new int[R][C];
		
		while(nextNode.isEmpty() != true) {
			
			Node curNode = nextNode.poll();
			
			int cnt = 0;
			for(int i = 0; i < 4; i++) {
				int nextI = curNode.i + dir[i][0];
				int nextJ = curNode.j + dir[i][1];
				
				if(isInBoundary(nextI, nextJ) != true)
					continue;
				
				if(nextI == filter[0] && nextJ == 0)
					continue;
				
				if(nextI == filter[1] && nextJ == 0)
					continue;
				
				newMap[nextI][nextJ] += curNode.amount/5;
				cnt++;
			}
			
			newMap[curNode.i][curNode.j] += curNode.amount - (curNode.amount/5)*cnt; 
		}
		
		map = newMap;
	}
	
	static void rotate(){
	
		//1번 방향
				
		for(int i = filter[0]; i >0; i--)
			map[i][0] = map[i-1][0];
		
		for(int j = 0; j < C-1; j++)
			map[0][j] = map[0][j+1];
		
		for(int i = 0 ; i < filter[0]; i++)
			map[i][C-1] = map[i+1][C-1];
		
		map[filter[0]][0] = 0;
		
		for(int j = C-1; j > 0; j--)
			map[filter[0]][j] = map[filter[0]][j-1];
		
		//2번방향
		
		for(int i = filter[1]; i < R-1; i++)
			map[i][0] = map[i+1][0];
		
		for(int j = 0; j < C-1; j++)
			map[R-1][j] = map[R-1][j+1];
		
		for(int i = R-1; i > filter[1]; i--)
			map[i][C-1] = map[i-1][C-1];
		
		map[filter[1]][0] = 0;
		
		for(int j = C-1; j > 0; j--)
			map[filter[1]][j] = map[filter[1]][j-1];
		
	}
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
	
		map = new int[R][C];
	
		int cnt = 0;
		
	    for(int i =0; i < R; i++) {
	    	
	    	st = new StringTokenizer(br.readLine());
	    
	        for(int j = 0; j < C; j++) {
	        	map[i][j] = Integer.parseInt(st.nextToken());
	        	
	        	if(map[i][j] == -1) {
	        		filter[cnt++] = i;
	        	}
	        }
	    }
	        
	        
	
	    for(int t = 0; t< T; t++) {
	        spread(); //print(); 
	        rotate(); //print();
	    }
	
	    int result = 0;
	
	    for(int i = 0; i < R; i++)
	        for(int j = 0; j < C; j++)
	            result += map[i][j];
	
	    System.out.println(result);
	}
}
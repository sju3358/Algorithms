import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node{
	    int node;
	    int cost;
	    
	    public Node(int node, int cost) {
	    	this.node = node;
	    	this.cost = cost;
	    			
	    }
	}

	static int[][] map;
	static int[] dp;
	
	static int N,M;

	public static int solution(int start, int end){


	    PriorityQueue<Node> nextNode = new PriorityQueue<>(
	    		(x1,x2) -> {return x1.cost - x2.cost;});
	
	    dp[start] = 0;
	    nextNode.add(new Node(start,0));
	
	    while(nextNode.isEmpty() != true){
	
	        Node curNode = nextNode.poll();
	
	        int cur = curNode.node;
	        int cost = curNode.cost;
	        
	        for(int next = 0; next < N; next++) {
	        	
	        	if(map[cur][next] > 100000)
	        		continue;
	        	
	            if(dp[next] > map[cur][next] + cost){
	                dp[next] = map[cur][next] + cost;
	                nextNode.add(new Node(next, dp[next]));
	            }
	        }
	
	    }
	
	    return dp[end];
	}

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		 
		dp = new int[N];
		map = new int[N][N];
	
		Arrays.fill(dp, 100000001);
		for(int i = 0; i < N; i++) 
			Arrays.fill(map[i], 100001);
		
	    for(int i = 0; i < M ; i++){
	    	st = new StringTokenizer(br.readLine());
	        int from = Integer.parseInt(st.nextToken()) - 1; 
	        int to = Integer.parseInt(st.nextToken()) - 1;
	        int cost = Integer.parseInt(st.nextToken());	  
	        map[from][to] = Math.min(map[from][to],cost);
	    }

	    st = new StringTokenizer(br.readLine());
	    int start = Integer.parseInt(st.nextToken()) - 1;
	    int end = Integer.parseInt(st.nextToken()) - 1;
	    System.out.println(solution(start, end));
	}
}
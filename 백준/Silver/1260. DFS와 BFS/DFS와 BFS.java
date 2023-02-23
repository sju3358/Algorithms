import java.util.*;

public class Main {

	static boolean[][] graph;
	
	
	static boolean[] isVisit;
    static ArrayList<Integer> result;
    
    
	static void dfs(int curNode){
	    for (int i = 0; i < graph.length; i++){
	        if (graph[curNode][i] && !isVisit[i]){
	            isVisit[i] = true;
	            result.add(i);
	            dfs(i);
	        }
	    }
	}


	static void bfs(int start){
		
	    Queue<Integer> dfsQueue = new LinkedList<Integer>();;
	    
	    isVisit[start] = true;
	    dfsQueue.add(start);
	    result.add(start);

	    while (!dfsQueue.isEmpty()){
	        int cur = dfsQueue.poll();
	        
	        for (int i = 0; i < graph.length; i++){
	            if (graph[cur][i] && !isVisit[i]){
	                dfsQueue.add(i);
	                isVisit[i] = true;
	                result.add(i);
	            }
	        }
	    }
	}


	public static void main(String args[]) {
	    
		Scanner scanner = new Scanner(System.in);
		

	    int N = scanner.nextInt();
	    int M = scanner.nextInt();
	    int start = scanner.nextInt();

	    graph = new boolean[N][N];

	    for (int i = 0; i < M; i++)
	    {
	        int temp1 = scanner.nextInt();
	        int temp2 = scanner.nextInt();
	        graph[temp1-1][temp2-1] = true;
	        graph[temp2-1][temp1-1] = true;
	    }
	    
	    
	    isVisit = new boolean[graph.length];
	    result = new ArrayList<Integer>();;
	    
	    
	    isVisit[start-1] = true;
	    result.add(start-1);
	    dfs(start-1);
	    for(int n : result) 
	    	System.out.print(n+1 + " ");
	    
	   
	    System.out.println();

	    
	    isVisit = new boolean[graph.length];
	    result = new ArrayList<Integer>();;
	    
	    bfs(start-1);
	    for(int n : result) 
	    	System.out.print(n+1 + " ");
	    
	    
	    
	}
}
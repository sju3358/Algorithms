import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	
	public static boolean isPossible(int[] map, int pivotLength){

	    Stack<Integer> roads = new Stack<Integer>();
	    roads.push(map[0]);

	    int index = 1;

	    while(index < map.length){

	        if(roads.peek() == map[index]){
	            roads.push(map[index++]);
	            continue;
	        }

	        if(roads.peek() + 1 == map[index]){
	            if(roads.size() < pivotLength)
	                return false;
	            else {
	                while (roads.empty() != true)
	                    roads.pop();
	                roads.push(map[index++]);
	            }
	        }
	        else if(roads.peek() - 1 == map[index]){

	            while(roads.empty() != true)
	                roads.pop();

	            while(index < map.length && roads.size() < pivotLength){
	                if(roads.empty() || roads.peek() == map[index])
	                    roads.push(map[index++]);
	                else
	                    break;
	            }

	            if (roads.size() < pivotLength)
	                return false;

	            while (roads.size() > 1)
	                roads.pop();

	            if(index < map.length){
	                if(map[index] == roads.peek())
	                    index++;
	            }

	        } else
	            return false;
	    }

	    return true;

	}


	public static void main (String args[]) throws IOException{
	    


	    int T = Integer.parseInt(br.readLine());
	    
	    for(int t = 1; t <= T; t++){

	       

	        int answer = 0;

	        st = new StringTokenizer(br.readLine());
	        int n = Integer.parseInt(st.nextToken());
	        int length = Integer.parseInt(st.nextToken());
	        
	        int[][] map = new int[n][n];
	        
	        for(int i = 0; i < n; i++){
	            st = new StringTokenizer(br.readLine());
	            for(int j = 0; j < n; j++){
	               map[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }

	        for(int i = 0; i < n; i++){
	 
	        	int[] subMap = new int[n];
	        	
	        	for(int j = 0; j < n; j++)
	        		subMap[j] = map[i][j];
	        		
	        	if(isPossible(subMap, length))
	                answer++;
	        }

	        
	        for(int j = 0; j < n; j++) {
	            
	        	int[] subMap = new int[n];
	        	
	        	for(int i = 0; i < n; i++)
	        		subMap[i] = map[i][j];
	        		
	        		
	        	if(isPossible(subMap, length))
	                answer++;
	        }
	        

	        System.out.println("#" + t + " " + answer);
	        

	    }


	}

}
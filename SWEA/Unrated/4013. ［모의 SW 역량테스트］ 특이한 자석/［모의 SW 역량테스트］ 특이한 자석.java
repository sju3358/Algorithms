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
	
	static ArrayList<ArrayList<Integer>> magnets;

	static class RotateInfo{
	    int magnetIndex;
	    int dir;
	    
	    public RotateInfo(int magnetIndex, int dir) {
	    	this.magnetIndex = magnetIndex;
	    	this.dir = dir;
	    }
	}

	static void rotateMagnets(int magnetIndex, int dir, ArrayList<ArrayList<Integer>> magnets){

	    boolean visited[] = {false,false,false,false};
	    Queue<RotateInfo> nextRotate = new LinkedList<>();
	    visited[magnetIndex] = true;
	    nextRotate.add(new RotateInfo(magnetIndex,dir));

	    while(nextRotate.isEmpty() != true){
	        RotateInfo curRotate = nextRotate.poll();

	        //왼쪽 자석
	        if(curRotate.magnetIndex - 1 >= 0){
	            int nextIndex = curRotate.magnetIndex - 1;

	            if(visited[nextIndex] != true) {

	                visited[nextIndex] = true;

	                if (magnets.get(nextIndex).get(2) != magnets.get(curRotate.magnetIndex).get(6))
	                    nextRotate.add(new RotateInfo(nextIndex, curRotate.dir * -1));
	            }
	        }


	        //오른쪽 자석
	        if(curRotate.magnetIndex + 1 < 4){
	            int nextIndex = curRotate.magnetIndex + 1;

	            if(visited[nextIndex] != true) {
	                
	                visited[nextIndex] = true;

	                if (magnets.get(nextIndex).get(6) != magnets.get(curRotate.magnetIndex).get(2))
	                    nextRotate.add(new RotateInfo(nextIndex, curRotate.dir * -1));
	            }
	        }

	        //현재자석 돌리기.
	        if(curRotate.dir == 1){
	            int temp = magnets.get(curRotate.magnetIndex).get(7);
	            magnets.get(curRotate.magnetIndex).remove(7);
	            magnets.get(curRotate.magnetIndex).add(0, temp);
	        }

	        if(curRotate.dir == -1){
	            int temp = magnets.get(curRotate.magnetIndex).get(0);
	            magnets.get(curRotate.magnetIndex).remove(0);
	            magnets.get(curRotate.magnetIndex).add(temp);
	        }
	    }
	}

	public static void main(String args[]) throws IOException{
	   
	    int T = Integer.parseInt(br.readLine());

	    for(int t = 1 ; t <= T; t++){

	        int k = Integer.parseInt(br.readLine());

	        magnets = new ArrayList<ArrayList<Integer>>();

	        for(int i = 0; i < 4; i++){
	            ArrayList<Integer> magnet = new ArrayList<Integer>();
	            st = new StringTokenizer(br.readLine());
	            for(int j = 0 ; j < 8; j++){
	                int pole = Integer.parseInt(st.nextToken());
	                magnet.add(pole);
	            }
	            magnets.add(magnet);
	        }

	        for(int i = 0; i < k; i++) {
	        	
	        	st = new StringTokenizer(br.readLine());
	            
	        	int magnetIndex = Integer.parseInt(st.nextToken());
	        	int dir = Integer.parseInt(st.nextToken());
	        
	            rotateMagnets(magnetIndex-1,dir,magnets);
	        }

	        int score = 0;
	        if(magnets.get(0).get(0) == 1)
	            score += 1;
	        if(magnets.get(1).get(0) == 1)
	            score += 2;
	        if(magnets.get(2).get(0) == 1)
	            score += 4;
	        if(magnets.get(3).get(0) == 1)
	            score += 8;

	        System.out.println("#" + t + " " + score);
	        
	    }
	}


	

}
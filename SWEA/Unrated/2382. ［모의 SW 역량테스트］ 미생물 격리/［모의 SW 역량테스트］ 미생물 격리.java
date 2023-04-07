import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	static class Group{
	    int i;
	    int j;
	    int size;
	    int dir; //0 : 상, 1 : 하, 2 : 좌, 3 : 우
	    
	    public Group(int i, int j , int size, int dir) {
	    	this.i = i;
	    	this.j = j;
	    	this.size = size;
	    	this.dir = dir;
	    }
	}
	
	static int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static Queue<Group>[][] map;
	static int changeDir(int dir){
	    if(dir == 0)
	        return 1;
	    else if(dir == 1)
	        return 0;
	    else if(dir == 2)
	        return 3;
	    else if(dir == 3)
	        return 2;
	    return -1;
	}

	static boolean isOnBoundary(int i, int j, int n){
	    return i == 0 || j == 0 || j == n-1 || i == n-1;
	}

	static void moveGroup(){

	    int N = map.length;

	    //군집 리스트 생성
	    ArrayList<Group> groupList = new ArrayList<>();
	    for(int i = 0; i < map.length; i++){
	        for(int j = 0; j < map.length; j++){
	            while(map[i][j].isEmpty() != true) {
	                groupList.add(map[i][j].poll());
	            }
	        }
	    }

	    //군집 리스트 이동
	    for(int i = 0; i < groupList.size(); i++) {
	        Group group = groupList.get(i);

	        int nextI = group.i + dirs[group.dir][0];
	        int nextJ = group.j + dirs[group.dir][1];


	        if (isOnBoundary(nextI, nextJ, N) == true) {
	            group.dir = changeDir(group.dir);
	            group.size = group.size / 2;
	        }

	        if(group.size > 0)
	            map[nextI][nextJ].add(new Group(nextI,nextJ,group.size,group.dir));
	    }

	    //겹친 군집 하나로 묶기
	    for(int i = 0; i < map.length; i++){
	        for(int j = 0; j < map.length; j++){
	            if(map[i][j].isEmpty() != true){

	                int max = -1;
	                int maxDir = -1;
	                int sumOfSize = 0;

	                while(map[i][j].isEmpty() != true){
	                    Group curGroup = map[i][j].poll();
	                    if(max < curGroup.size){
	                        max = curGroup.size;
	                        maxDir = curGroup.dir;
	                    }
	                    sumOfSize+= curGroup.size;
	                }

	                map[i][j].add(new Group(i,j,sumOfSize,maxDir));
	            }
	        }
	    }
	}

	public static void main(String args[]) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    
		int T = Integer.parseInt(br.readLine().trim());

		
		for(int t = 1; t <=T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine()," "); 
	        int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());
	        int K = Integer.parseInt(st.nextToken());

	        map = new Queue[N][N];
	        
	        for(int i = 0 ; i < N; i++){
	            for(int j = 0; j < N; j++)
	            	map[i][j] = new LinkedList<>();
	        }


	        for(int k = 0; k< K; k++) {
	        	int i,j,size,dir;
	        	st = new StringTokenizer(br.readLine()," ");
	            i = Integer.parseInt(st.nextToken());
	            j = Integer.parseInt(st.nextToken());
	            size = Integer.parseInt(st.nextToken());
	            dir = Integer.parseInt(st.nextToken());
	            map[i][j].add(new Group(i,j,size,dir-1));
	        }

	        for(int m = 0; m < M; m++)
	            moveGroup();

	        int sum = 0;

	        for(int i = 0; i < N; i++){
	            for(int j = 0; j < N; j++)
	                while(map[i][j].isEmpty() != true) {
	                    sum += map[i][j].poll().size;
	                }
	        }

	        System.out.println("#"+t+" "+sum);
	    }
	}
}
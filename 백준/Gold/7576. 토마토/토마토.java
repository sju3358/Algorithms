import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
    static int dir[][] = { {-1,0}, {1,0}, {0,1}, {0,-1}};
    
    static int[][] tomatoMap;
	static Queue<Tomato> nextTomato = new LinkedList<>();
	
	static int totalDay = 0;
	static int totalTomatoes = 0;
    static int ripenTomatoes = 0;
    
    
    static int N,M;
    
    
	static class Tomato{
		int i;
		int j;
		int day;
		public Tomato(int i, int j, int day) {
			this.i = i;
			this.j = j;
			this.day = day;
		}
	}
	
	public static boolean isInBound(int x, int y) {
	    return 0 <= x && x < N && 0 <= y && y < M;
	}

	public static void bfs() {
		 
	
		while(nextTomato.isEmpty() != true) {
			
			Tomato curTomato = nextTomato.poll();
			
			if(totalDay < curTomato.day)
				totalDay = curTomato.day;
			
			
			for(int i = 0; i < 4; i++) {
				int nextI = curTomato.i + dir[i][0];
				int nextJ = curTomato.j + dir[i][1];
				
				if(isInBound(nextI, nextJ) == false)
					continue;
				
				if(tomatoMap[nextI][nextJ] == 0) {
					tomatoMap[nextI][nextJ] = 1;
					nextTomato.add(new Tomato(nextI, nextJ, curTomato.day + 1));
					ripenTomatoes++;
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException{

	    st = new StringTokenizer(br.readLine());
	    
	    M = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());

	    tomatoMap = new int[N][M];

	    

	    for(int i = 0; i< N; i++) {
	    	
	    	st = new StringTokenizer(br.readLine());
	    	
	    	for(int j = 0; j < M; j++) {
	    		int tomato = Integer.parseInt(st.nextToken());
	    		tomatoMap[i][j] = tomato;
	    		
	    		if(tomato == 1) {
	    			nextTomato.add(new Tomato(i, j, 0));
	    			ripenTomatoes++;
	    		}
	    		
	    		if(tomato != -1) 
	    			totalTomatoes++;
	    		
	    	}
	    }
	    
	    bfs();

	    
	    if(ripenTomatoes == totalTomatoes) {
	    	System.out.println(totalDay);
	    }
	    else
	    	System.out.println(-1);
	}
}
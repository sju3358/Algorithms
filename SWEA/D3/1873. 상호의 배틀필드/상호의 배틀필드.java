import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] map;
	
	static enum DIR {UP,DOWN,RIGHT,LEFT};
	
	static int curI;
	static int curJ;
	static DIR curDir;
	
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T;  t++) {
			
			
			//초기화 및 입력
			init();
			
			
			//입력 수행
			int cnt = Integer.parseInt(br.readLine());
			String input = br.readLine();
			
			for(int i = 0; i < cnt; i++) 
				executeInstruction(input.charAt(i));
					
			//마지막 탱크위치 표시
			markTank();
			
			//정답 출력
			System.out.print("#"+t + " ");
			printMap();
		}
	}
	
	public static void init() throws NumberFormatException, IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		//map 입력
		map = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j);
				
				if(map[i][j] == '<') {
					curI = i;
					curJ = j;
					curDir = DIR.LEFT;
					
				}else if(map[i][j] == '>') {
					curI = i;
					curJ = j;
					curDir = DIR.RIGHT;
					
				}else if(map[i][j] == '^') {
					curI = i;
					curJ = j;
					curDir = DIR.UP;
					
				}else if(map[i][j] == 'v') {
					curI = i;
					curJ = j;
					curDir = DIR.DOWN;
				}
			}
		}
	}
	
	public static void printMap() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j <map[0].length; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}
	
	public static void markTank() {
		
		if(curDir == DIR.UP) {
			map[curI][curJ] = '^';
		}else if(curDir == DIR.DOWN) {
			map[curI][curJ] = 'v';
		}else if(curDir == DIR.LEFT) {
			map[curI][curJ] = '<';
		}else if(curDir == DIR.RIGHT) {
			map[curI][curJ] = '>';
		}
		
	}
	
	public static void executeInstruction(char instruction) {
		switch(instruction) {
		case 'U':
			Up();
			break;
		case 'D':
			Down();
			break;
		case 'R':
			Right();
			break;
		case 'L':
			Left();
			break;
		case 'S':
			Shoot();
			break;
		}
	}
	
	public static void Up() {
		curDir = DIR.UP;
		
		if(isInBoundary(curI-1,curJ) && map[curI-1][curJ] == '.') { 
			map[curI][curJ] = '.';
			curI = curI - 1;
		}
		
	}
	
	public static void Down() {
		curDir = DIR.DOWN;
		
		if(isInBoundary(curI+1,curJ) && map[curI+1][curJ] == '.') {
			map[curI][curJ] = '.';
			curI = curI + 1;
		}
	}
	
	public static void Left() {
		curDir = DIR.LEFT;
		
		if(isInBoundary(curI,curJ-1) && map[curI][curJ-1] == '.') {
			map[curI][curJ] = '.';
			curJ = curJ - 1;
		}
	}
	
	public static void Right() {
		curDir = DIR.RIGHT;
		
		if(isInBoundary(curI,curJ+1) && map[curI][curJ+1] == '.') { 
			map[curI][curJ] = '.';
			curJ = curJ + 1;
		}
	}
	
	public static void Shoot() {
		if(curDir == DIR.UP) {
			int i = curI - 1;
			int j = curJ;
			
			for(; i >= 0; i--) {
				if(map[i][j] == '*' || map[i][j] == '#') {
					if(map[i][j] == '*')
						map[i][j] = '.';
					break;
				}
			}
		}else if(curDir == DIR.DOWN) {
			int i = curI + 1;
			int j = curJ;
			
			for(; i < map.length; i++) {
				if(map[i][j] == '*' || map[i][j] == '#') {
					if(map[i][j] == '*')
						map[i][j] = '.';
					break;
				}
			}
		}else if(curDir == DIR.LEFT) {
			int i = curI;
			int j = curJ - 1;
			
			for(; j >= 0; j--) {
				if(map[i][j] == '*' || map[i][j] == '#') {
					if(map[i][j] == '*')
						map[i][j] = '.';
					break;
				}
			}
		}else if(curDir == DIR.RIGHT) {
			int i = curI;
			int j = curJ + 1;
			
			for(; j < map[0].length; j++) {
				if(map[i][j] == '*' || map[i][j] == '#') {
					if(map[i][j] == '*')
						map[i][j] = '.';
					break;
				}
			}
		}
		
	}
	
	public static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < map.length && 0 <= j && j < map[0].length;
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static boolean[][] visited = new boolean[100][100];
	private static boolean[][] whiteClothes = new boolean[100][100];
	
	private static int answer = 0;
	
	private static int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}}; 
	
	private static class Node {
		int i;
		int j;
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	
	//i와j가 0과99사이인지 판별
	private static boolean isInBoundary(int i, int j) {
		return 0 <= i && i < 100 && 0 <= j && j < 100;
	}
	
	private static int getAnswer(int startI, int startJ) {
		
		//bfs를 이용하여 둘레 길이 구하기
		
		Queue<Node> nextNode = new LinkedList<>();
		nextNode.add(new Node(startI,startJ));
		visited[startI][startJ] = true;
		
		
		while(nextNode.isEmpty() != true) {
			Node curNode = nextNode.poll();
			
			//상하 좌우 중
			//1. 범위를 벗어난곳이 있거나 
			//2. 붙이지 않은 곳이 있을때 
			//모서리 이므로 둘레 + 1
			for(int i = 0; i <4; i++) {
				int nextI = curNode.i + dir[i][0];
				int nextJ = curNode.j + dir[i][1];
				
				if(isInBoundary(nextI,nextJ)) {
					if(whiteClothes[nextI][nextJ] == true && visited[nextI][nextJ] == false) {
						visited[nextI][nextJ] = true;
						nextNode.add(new Node(nextI,nextJ));
					}
					else if(whiteClothes[nextI][nextJ] == false)
						answer++;
				}
				else
					answer++;
			}
			
		}
		
		return answer;
	}
	
	
	private static void pasteScarf(int x, int y) {
		
		//x,y를 기준으로 가로세로가 10인 정사각형 검은 스카프를 붙인다.
		for(int i = x; i < x + 10; i++) {
			for(int j = y; j < y + 10; j++)
				whiteClothes[i][j] = true;
		}
	}


	public static void main(String args[]) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		
		
		//입력
		for(int i = 0; i <n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			pasteScarf(x,y); //검은 스카프 붙이기
		}
		
		
		//검은 스카프인 영역을 찾아서 해당 영역의 검은스카프 둘레길이 구하기
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++)
				if(whiteClothes[i][j] == true && visited[i][j] == false) {
					getAnswer(i,j);
				}
		}
				
		//정답출력
		System.out.println(answer);
	}
}
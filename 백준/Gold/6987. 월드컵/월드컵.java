import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;





public class Main {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static boolean isPossibleGame;
	static int[][] resultOfGame;
	
	static int[][] gameWith = new int[][] {{0,1},{0,2},{0,3},{0,4},{0,5},{1,2},{1,3},{1,4},{1,5},{2,3},{2,4},{2,5},{3,4},{3,5},{4,5}};
	
	public static boolean check(int[][] gameTable) {
		for(int i = 0; i < 6; i++)
			for(int j = 0; j <3; j++)
				if(resultOfGame[i][j] != gameTable[i][j])
					return false;
		return true;
	}
	
	public static void bfs(int[][] gameTable, int round) {
		if(round == 15) {
			
			if(check(gameTable) == true)
				isPossibleGame = true;
			return;
		}
		else {

				int i = gameWith[round][0];
				int j = gameWith[round][1];
				
				if(gameTable[i][0] < resultOfGame[i][0] && gameTable[j][2] < resultOfGame[j][2]) {
					gameTable[i][0] =  gameTable[i][0] + 1;
					gameTable[j][2] = gameTable[j][2] + 1;
					
					bfs(gameTable.clone(), round+1);
					
					gameTable[i][0] =  gameTable[i][0] - 1;
					gameTable[j][2] = gameTable[j][2] - 1;
				}
						
						
						
				if(gameTable[i][1] < resultOfGame[i][1] && gameTable[j][1] < resultOfGame[j][1]) {
					gameTable[i][1] =  gameTable[i][1] + 1;
					gameTable[j][1] = gameTable[j][1] + 1;
					
					bfs(gameTable.clone(), round+1);
					
					gameTable[i][1] =  gameTable[i][1] - 1;
					gameTable[j][1] = gameTable[j][1] - 1;
				}
				
				if(gameTable[i][2] < resultOfGame[i][2] && gameTable[j][0] < resultOfGame[j][0]) {
					
					
					
					gameTable[i][2] =  gameTable[i][2] + 1;
					gameTable[j][0] = gameTable[j][0] + 1;
					
					bfs(gameTable.clone(), round+1);
					
					gameTable[i][2] =  gameTable[i][2] - 1;
					gameTable[j][0] = gameTable[j][0] - 1;

				}
		}
	}
	
	public static char isPossible() throws IOException{
		
		isPossibleGame = false;
		resultOfGame = new int[6][3];

		int sumOfWin = 0;
		int sumOfTie = 0;
		int sumOfLose = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < 6; i++) {
			resultOfGame[i][0] = Integer.parseInt(st.nextToken());
			resultOfGame[i][1] = Integer.parseInt(st.nextToken());
			resultOfGame[i][2] = Integer.parseInt(st.nextToken());
			
			if(resultOfGame[i][0] == 6 || resultOfGame[i][1] == 6 || resultOfGame[i][2] == 6)
				return '0';
			
			
			sumOfWin += resultOfGame[i][0];
			sumOfTie += resultOfGame[i][1];
			sumOfLose += resultOfGame[i][2];
		}
		
		if(sumOfTie % 2 == 1)
			return '0';
		else if(sumOfWin != sumOfLose)
			return '0';
		
		int[][] gameTable = new int[6][3];

		boolean[][] isVisit = new boolean[6][6];
		for(int i = 0; i <6; i++)
			isVisit[i][i] = true;
		bfs(gameTable,0);
		
		return isPossibleGame == true ? '1' : '0';
	}
	
	public static void main(String args[]) throws IOException  {
		
		
		
		
		for(int i = 0; i < 4; i++) {
			System.out.print(isPossible() + " ");
		}
		
		
	}
}
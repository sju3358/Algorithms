import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static boolean isFind = false;
	private static int[][] map;
	private static boolean[][] visitedOfSquare;
	private static boolean[][] visitedOfRow;
	private static boolean[][] visitedOfCol;
	private static boolean isAnswerFind = false;

	private static int getSquareIndex(int i, int j){
		int squareIndex = -1;

		switch (i/3){
			case 0:
				switch (j/3){
					case 0:
						squareIndex = 0;
						break;
					case 1:
						squareIndex = 1;
						break;
					case 2:
						squareIndex = 2;
						break;
				}
				break;
			case 1:
				switch (j/3){
					case 0:
						squareIndex = 3;
						break;
					case 1:
						squareIndex = 4;
						break;
					case 2:
						squareIndex = 5;
						break;
				}
				break;
			case 2:
				switch (j/3){
					case 0:
						squareIndex = 6;
						break;
					case 1:
						squareIndex = 7;
						break;
					case 2:
						squareIndex = 8;
						break;
				}
				break;
		}

		return squareIndex;
	}

	private static void printMap(){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void solution(int i, int j){
		if(isAnswerFind == true)
			return;

		if(j == 9){
			j = 0;
			i += 1;
		}

		if(i == 9){
			printMap();
			isAnswerFind = true;
			return;
		}

		if(map[i][j] != 0){
			solution(i, j+1);
		}
		else {


			int squareIndex = getSquareIndex(i,j);

			for (int nextDigit = 1; nextDigit <= 9; nextDigit++) {

				if (visitedOfSquare[squareIndex][nextDigit-1] == true)
					continue;
				if (visitedOfRow[i][nextDigit-1] == true)
					continue;
				if (visitedOfCol[j][nextDigit-1] == true)
					continue;

				map[i][j] = nextDigit;
				visitedOfSquare[squareIndex][nextDigit-1] = true;
				visitedOfRow[i][nextDigit-1] = true;
				visitedOfCol[j][nextDigit-1] = true;

				solution(i, j+1);

				map[i][j] = 0;
				visitedOfSquare[squareIndex][nextDigit-1] = false;
				visitedOfRow[i][nextDigit-1] = false;
				visitedOfCol[j][nextDigit-1] = false;
			}
		}
	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		map = new int[9][9];
		visitedOfSquare = new boolean[9][9];
		visitedOfRow =  new boolean[9][9];
		visitedOfCol =  new boolean[9][9];


		for(int i = 0; i < 9; i++){

			String input = br.readLine();

			for(int j = 0; j < 9; j++){
				int digit = input.charAt(j) - '0';

				map[i][j] = digit;

				if(digit > 0) {
					int squareIndex = getSquareIndex(i,j);
					visitedOfSquare[squareIndex][digit-1] = true;
					visitedOfRow[i][digit-1] = true;
					visitedOfCol[j][digit-1] = true;
				}
			}
		}

		solution(0,0);

	}

}
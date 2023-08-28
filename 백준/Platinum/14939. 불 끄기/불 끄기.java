import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static private boolean[][] map;

	static private class Node{
		boolean[][] switches;
		int clickCount = 0;

		public Node(boolean[][] switches, int clickCount){
			this.switches = switches;
			this.clickCount = clickCount;
		}
	}

	static private ArrayList<Node> mapList = new ArrayList<>();

	static private int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

	static private boolean isInBoundary(int i, int j){
		return 0 <= i && i < 10 && 0 <= j && j < 10;
	}

	static private void clickSwitch(int curI, int curJ, boolean[][] map){

		map[curI][curJ] = !map[curI][curJ];

		for(int i = 0; i < 4; i++){
			int nextI = curI + dir[i][0];
			int nextJ = curJ + dir[i][1];

			if(isInBoundary(nextI, nextJ))
				map[nextI][nextJ] = !map[nextI][nextJ];

		}
	}


	static private boolean isAllZero(boolean[] lastLine){
		for(int i = 0; i < 10; i++)
			if(lastLine[i] == true)
				return false;
		return true;
	}

	static private int getCount(Node node){

		int clickCount = node.clickCount;
		boolean[][] switches = node.switches;

		for(int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(switches[i-1][j] == true){
					clickSwitch(i,j,switches);
					clickCount++;
				}
			}
		}

		return isAllZero(switches[9]) == true ? clickCount : -1;
	}


	static private boolean[][] getCopyOfMap(){
		boolean[][] deepCopiedMap = new boolean[10][10];

		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				deepCopiedMap[i][j] = map[i][j];

		return deepCopiedMap;
	}

	static private void getFirstLinePermutation(boolean[][] map, int curIndex, int count){

		if(curIndex == 10){
			mapList.add(new Node(getCopyOfMap(),count));
		} else {
			clickSwitch(0,curIndex,map);
			getFirstLinePermutation(map, curIndex + 1, count + 1);
			clickSwitch(0,curIndex,map);
			getFirstLinePermutation(map, curIndex + 1, count);
		}
	}


	static private int solution(){

		int minCount = Integer.MAX_VALUE;
		boolean findAnswer = false;

		getFirstLinePermutation(map,0,0);

		for(Node node : mapList){
			int count = getCount(node);
			if(count != -1){
				minCount =  Math.min(minCount , count);
				findAnswer = true;
			}
		}

		return findAnswer == true ? minCount : -1;

	}


	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		map = new boolean[10][10];

		for(int i = 0; i <10; i++){
			String input = br.readLine();
			for(int j = 0; j < 10; j++){
				if(input.charAt(j) == 'O')
					map[i][j] = true;
			}
		}

		System.out.println(solution());
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	static int[][] imageDatas;
	
	public static boolean isCheck(int startI, int startJ, int size) {
		
		int pivot = imageDatas[startI][startJ];

		for (int i = startI; i < startI + size; i++)
			for (int j = startJ; j < startJ + size; j++)
				if (imageDatas[i][j] != pivot)
					return false;


		return true;
	}
	
	
	
	public static String zipImages(int i, int j, int size) {
		
		String result = "";

		
		if(isCheck(i, j, size)){
			result+=imageDatas[i][j];
		}
		else {
			int nextSize = size / 2;
			result+=("(");
			result+=(zipImages(i,j,nextSize));
			result+=(zipImages(i,j+nextSize,nextSize));
			result+=(zipImages(i + nextSize, j, nextSize));
			result+=(zipImages(i+nextSize,j+nextSize,nextSize));
			result+=(")");
		}
		return result;
	}
	
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		imageDatas = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++)
				imageDatas[i][j] = input.charAt(j) - '0';
		}

		System.out.println(zipImages(0, 0, n));
		
	}
	
}
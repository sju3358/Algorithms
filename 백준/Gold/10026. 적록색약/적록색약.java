import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	
	static int dir_i[] = {0, 0, 1,-1};
	static int dir_j[] = {1,-1, 0, 0};
	
	static char[][] map;
	
	
	static class Node {
		int i;
		int j;
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}


	public static boolean isInBoundary(int i, int j, int n) {
		return 0 <= i && i < n && 0 <= j && j < n;
	}

	

	//적록색약X
	public static int dfs1() {
		

		int cnt = 0;
		int n = map.length;
		boolean[][] isVisit = new boolean[n][n];
		

		

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isVisit[i][j] != true) {
					cnt++;
					Queue<Node> index = new LinkedList<>();
					index.add(new Node( i,j ));
					
					char pivot = map[i][j];
					isVisit[i][j] = true;
					
					while (index.isEmpty() != true) {
						Node curNode = index.poll();
						
						for (int k = 0; k < 4; k++) {
							int next_i = curNode.i + dir_i[k];
							int next_j = curNode.j + dir_j[k];

							if (isInBoundary(next_i, next_j, n)) {
								boolean flag1 = map[next_i][next_j] == pivot;
								boolean flag2 = isVisit[next_i][next_j] != true;
								if (flag1 && flag2) {
									isVisit[next_i][next_j] = true;
									index.add(new Node( next_i,next_j ));
								}
							}
						}
					}
				}
			}
		}

		return cnt;

	}

	//적록색약
	public static int dfs2() {
		
		int cnt = 0;
		int n = map.length;
		boolean[][] isVisit = new boolean[n][n];



		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isVisit[i][j] != true) {
					cnt++;
					Queue<Node> index = new LinkedList<>();
					index.add(new Node( i,j ));

					char pivot = map[i][j];
					isVisit[i][j] = true;

					while (index.isEmpty() != true) {
						Node curNode = index.poll();
						
						for (int k = 0; k < 4; k++) {
							int next_i = curNode.i + dir_i[k];
							int next_j = curNode.j + dir_j[k];

							if (isInBoundary(next_i, next_j, n) && isVisit[next_i][next_j] != true) {
								if (pivot == 'B' && map[next_i][next_j] == pivot) {
									isVisit[next_i][next_j] = true;
									index.add(new Node( next_i,next_j ));
								}
								else if (pivot != 'B' && map[next_i][next_j] != 'B') {
									isVisit[next_i][next_j] = true;
									index.add( new Node( next_i,next_j ));
								}
							}
						}
					}
				}
			}
		}

		return cnt;
	}


	public static void main(String args[]) throws NumberFormatException, IOException {

		
		
		int n = Integer.parseInt(br.readLine());

		map = new char[n][n];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++)
				map[i][j] = input.charAt(j);
		
		}

		int answer1 = dfs1();
		int answer2 = dfs2();

		System.out.println(answer1 + " " + answer2);

	}
}
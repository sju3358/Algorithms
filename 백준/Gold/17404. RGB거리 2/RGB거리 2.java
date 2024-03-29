import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Arrays;
	import java.util.HashMap;
	import java.util.PriorityQueue;
	import java.util.StringTokenizer;
	import java.util.TreeSet;


	public class Main {


		private static int[][] colors;
		private static int n;

		private static int getMinValue(int... values){
			int minValue = Integer.MAX_VALUE;
			for(int value : values)
				minValue = Math.min(value, minValue);
			return minValue;
		}

		private static int solution(){
			int minCost = Integer.MAX_VALUE;

			for(int i = 0; i < 3; i++){

				int[][] dpColor = new int[n][3];

				for(int j = 0; j < 3; j++){
					Arrays.fill(dpColor[j],0);
					dpColor[0][j] = (i == j ? colors[0][j] : 1001);
				}


				for(int j = 1; j < n-1; j++){
					dpColor[j][0] = Math.min(dpColor[j-1][1], dpColor[j-1][2]) + colors[j][0];
					dpColor[j][1] = Math.min(dpColor[j-1][0], dpColor[j-1][2]) + colors[j][1];
					dpColor[j][2] = Math.min(dpColor[j-1][0], dpColor[j-1][1]) + colors[j][2];
				}

				dpColor[n-1][0] =  (i != 0 ? Math.min(dpColor[n-2][1], dpColor[n-2][2]) + colors[n-1][0] : Integer.MAX_VALUE);
				dpColor[n-1][1] =  (i != 1 ? Math.min(dpColor[n-2][0], dpColor[n-2][2]) + colors[n-1][1] : Integer.MAX_VALUE);
				dpColor[n-1][2] =  (i != 2 ? Math.min(dpColor[n-2][0], dpColor[n-2][1]) + colors[n-1][2] : Integer.MAX_VALUE);

				minCost = Math.min(minCost, getMinValue(dpColor[n-1][0],dpColor[n-1][1],dpColor[n-1][2]));
			}
			return minCost;
		}

		public static void main(String args[]) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			n = Integer.parseInt(br.readLine());

			colors = new int[n][3];

			for(int i = 0; i < n ; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				colors[i][0] = Integer.parseInt(st.nextToken());
				colors[i][1] = Integer.parseInt(st.nextToken());
				colors[i][2] = Integer.parseInt(st.nextToken());
			}

			System.out.println(solution());

		}
	}
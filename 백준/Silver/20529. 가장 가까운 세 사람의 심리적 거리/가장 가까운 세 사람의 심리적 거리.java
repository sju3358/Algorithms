import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int getLength(String mbti1, String mbti2){
		int length = 0;

		for(int i = 0; i < 4; i++){
			if(mbti1.charAt(i) != mbti2.charAt(i))
				length +=1;
		}

		return length;
	}

	private static int getLength(String mbti1, String mbti2, String mbti3){
		return getLength(mbti1,mbti2) + getLength(mbti1,mbti3) + getLength(mbti2,mbti3);
	}

	private static int getSumOfLength(String[] mbtiList){

		if(mbtiList.length <= 1) {
			return 0;
		} else if(mbtiList.length == 2) {
			return getLength(mbtiList[0], mbtiList[1]);
		} else if(mbtiList.length == 3){
			return getLength(mbtiList[0], mbtiList[1], mbtiList[2]);
		} else {

			int minLength = Integer.MAX_VALUE;

			for(int i = 0; i < mbtiList.length - 2; i++)
				for(int j =i+1; j < mbtiList.length - 1; j++)
					for(int k = j+1; k < mbtiList.length; k++)
						minLength = Math.min(minLength, getLength(mbtiList[i], mbtiList[j],mbtiList[k]));
			return minLength;
		}
	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for(int t = 0; t < T; t++){

			int N = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine());
			if(N > 32) {
				System.out.println(0);
				continue;
			}


			String[] mbtiList = new String[N];
			for(int i = 0; i < N; i++) {
				mbtiList[i] = st.nextToken();
			}


			System.out.println(getSumOfLength(mbtiList));
		}
	}
}
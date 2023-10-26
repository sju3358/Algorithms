import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

	//i 번째가 제곱 ㄴㄴ수인지 저장. 0 : min, 1 : min+1 ..... n : min + n
	private static boolean[] isSquareNoNoNumber;


	//변형 에라토스 테네스의 체
	private static void findSquareNoNoNumber(Long min, Long max){

		for (long number = 2; number * number <= max; number++) {

			long powOfNumber = number * number;


			long start = -1;
			if(min % powOfNumber == 0)
				start = min / powOfNumber;
			else
				start = (min / powOfNumber) + 1;



			for (long i = start; powOfNumber * i <= max; i++) {
				// 제곱수의 배수로 나누어 떨어지므로 제곱ㄴㄴ수가 아님
				int noneSquareNoNoNumberIndex = (int)(i * powOfNumber - min);
				isSquareNoNoNumber[noneSquareNoNoNumberIndex] = false;
			}
		}
	}


	private static Long solution(Long min, Long max){

		long answer = 0;

		//제곱 ㄴㄴ수를 찾음
		findSquareNoNoNumber(min, max);


		//제곱 ㄴㄴ수의 개수를 찾음
		for(int i = 0; i < isSquareNoNoNumber.length; i++)
			if(isSquareNoNoNumber[i] == true)
				answer = answer + 1;

		return answer;
	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Long min = Long.parseLong(st.nextToken());
		Long max = Long.parseLong(st.nextToken());

		int sub = (int)(max - min + 1);
		isSquareNoNoNumber = new boolean[sub];
		Arrays.fill(isSquareNoNoNumber, true);

		System.out.println(solution(min,max));
	}
}
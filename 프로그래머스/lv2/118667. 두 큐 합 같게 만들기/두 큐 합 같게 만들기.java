import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {


	public int solution(int[] queue1, int[] queue2) {

		Queue<Long> queueA = new LinkedList<>();
		Queue<Long> queueB = new LinkedList<>();

		long sumOfQueueA = 0L;
		long sumOfQueueB = 0L;



		for(int i = 0 ; i < queue1.length; i++){
			sumOfQueueA += (long)queue1[i];
			sumOfQueueB += (long)queue2[i];
			queueA.add((long)queue1[i]);
			queueB.add((long)queue2[i]);
		}

		if((sumOfQueueA + sumOfQueueB) % 2 == 1)
			return -1;

		int answer = 0;

		while(sumOfQueueA != sumOfQueueB){

			if(answer > (queue1.length + queue2.length) * 2)
				return -1;

			if(sumOfQueueA > sumOfQueueB ){
				Long temp = queueA.poll();
				queueB.add(temp);
				sumOfQueueA = sumOfQueueA - temp;
				sumOfQueueB = sumOfQueueB + temp;
			} else {
				Long temp = queueB.poll();
				queueA.add(temp);
				sumOfQueueB = sumOfQueueB - temp;
				sumOfQueueA = sumOfQueueA + temp;
			}
			answer = answer + 1;
		}

		return answer;
	}

	public static void main(String args[]){
		new Solution().solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
	}
}
import java.util.Stack;
class Solution {
	
	public int getGCD(int x, int y) {
		
		int a = Math.min(x, y);
		int b = Math.max(x, y);
		
		if(b%a == 0)
			return a;
		else
			return getGCD(a,b%a);
	}
	
	public int getLCM(int x, int y) {
		
		return x*y/getGCD(x,y);
	}
	
	public int solution(int[] arr) {
		
		Stack<Integer> numbers = new Stack<Integer>();
		
		for(int i = 0; i < arr.length; i++)
			numbers.push(arr[i]);
		
		while(numbers.size() > 1) {
			int a = numbers.pop();
			int b = numbers.pop();
			numbers.push(getLCM(a,b));
		}
		
		return numbers.pop();
    }
	
	public static void main(String args[]) {
		System.out.println(new Solution().solution(new int[] {2,4,8}));
	}
    
    
}
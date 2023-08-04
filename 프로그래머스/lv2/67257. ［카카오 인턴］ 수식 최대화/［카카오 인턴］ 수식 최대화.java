import java.util.LinkedList;
import java.util.Vector;

class Solution {

	private final String[][] oprOrders = {{"+","-","*"},{"+","*","-"},{"-","+","*"},{"-","*","+"},{"*","+","-"},{"*","-","+"}};
	private final LinkedList<String> originPolynomial = new LinkedList<>();

	public boolean isOpr(String value){
		if(value.equals("+") || value.equals("*") || value.equals("-"))
			return true;
		else
			return false;
	}

	public Long calculate(String number1, String opr, String number2){
		Long arg1 = Long.parseLong(number1);
		Long arg2 = Long.parseLong(number2);

		if(opr.equals("+"))
			return arg1 + arg2;
		else if(opr.equals("-"))
			return arg1 - arg2;
		else
			return arg1 * arg2;
	}

	private LinkedList<String> getCopy(){
		LinkedList<String> temp = new  LinkedList<String>();
		for(int i = 0; i < originPolynomial.size(); i++)
			temp.add(originPolynomial.get(i));
		return temp;
	}
	public Long getResult(String[] oprOrder, LinkedList<String> polynomial){

		for(int i = 0; i < 3; i++){
			String opr = oprOrder[i];

			for(int j = 0; j < polynomial.size()-1; j++){
				String temp = polynomial.get(j);
				if(temp.equals(opr)){
					Long newValue = calculate(polynomial.get(j-1),polynomial.get(j),polynomial.get(j+1));
					polynomial.remove(j+1);
					polynomial.remove(j);
					polynomial.set(j-1,Long.toString(newValue));
					j = 0;
				}
			}
		}

		return Long.parseLong(polynomial.get(0));
	}

	public long solution(String expression) {

		long answer = 0;


		String value = "";
		for(int i = 0; i < expression.length(); i++){
			String temp = Character.toString(expression.charAt(i));
			if(isOpr(temp) == true){
				originPolynomial.add(value);
				originPolynomial.add((temp));
				value = "";
			} else {
				value += temp;
			}
		}
		originPolynomial.add(value);

		for(int i = 0; i < oprOrders.length; i++) {
			long result = getResult(oprOrders[i],getCopy());
			result = Math.max(result, -1 * result);
			answer = Math.max(result, answer);
		}

		return answer;
	}

	public static void main(String args[]){
		new Solution().solution("100-200*300-500+20");
	}
}
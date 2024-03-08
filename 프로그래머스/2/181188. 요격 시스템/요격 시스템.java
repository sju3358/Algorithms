import java.util.ArrayList;
import java.util.List;

class Solution {

	private class Misile{
		int s;
		int e;
		Misile(int s, int e){
			this.s = s;
			this.e = e;
		}
	}

	public boolean isCrossMatch(Misile m1, Misile m2){
		return m1.e > m2.s;
	}

	public int solution(int[][] targets) {
		List<Misile> misiles = new ArrayList<>();
		for(int i = 0; i <targets.length;i++)
			misiles.add(new Misile(targets[i][0],targets[i][1]));
		misiles.sort((m1,m2) ->{
			if(m1.s != m2.s)
				return m1.s - m2.s;
			else
				return m1.e - m2.e;
		});

		int count = 0;
		int curS = misiles.get(0).s;
		int curE = misiles.get(0).e;

		for(int i = 1; i < misiles.size(); i++){
			Misile curMisile = misiles.get(i);

			if(isCrossMatch(new Misile(curS,curE),curMisile)){
				curS = curMisile.s;
				curE = Math.min(curE, curMisile.e);
			}else{
				count += 1;
				curS = curMisile.s;
				curE = curMisile.e;
			}
		}
		count += 1;


		return count;
	}
}
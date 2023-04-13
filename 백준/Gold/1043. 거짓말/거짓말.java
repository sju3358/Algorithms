import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static boolean knowingPeoples[];
	static ArrayList<Integer> partys[];
	static int numOfPeople,numOfParty;

	private static boolean check(ArrayList<Integer> party){
	    for(int i = 0; i < party.size(); i++)
	        if(knowingPeoples[party.get(i)] == true)
	            return false;
	    return true;
	}

	private static int solution(){

		Queue<ArrayList<Integer>> nextParty = new ArrayDeque<>();

	    for(int i = 0; i < partys.length; i++)
	        nextParty.add(partys[i]);

	    while(true){

	        boolean flag = true;

	        for(int i = 0; i < nextParty.size(); i++){
	            ArrayList<Integer> party = nextParty.poll();
	            if(check(party) == false) {
	                for (int j = 0; j < party.size(); j++)
	                    knowingPeoples[party.get(j)] = true;
	                flag = false;
	            }
	            else{
	                nextParty.add(party);
	            }
	        }

	        if(flag == true)
	            break;
	    }

	    return nextParty.size();
	}

	public static void main(String args[]) throws IOException{

	    
		st = new StringTokenizer(br.readLine());
	    numOfPeople = Integer.parseInt(st.nextToken());
	    numOfParty = Integer.parseInt(st.nextToken());;

	    knowingPeoples = new boolean[numOfPeople+1];
	    partys = new ArrayList[numOfParty];
	    
	    st = new StringTokenizer(br.readLine());
	    int sumOfKnowingPeople = Integer.parseInt(st.nextToken());
	    
	    
	    for(int i = 0; i < sumOfKnowingPeople; i++){
	        int knowingPeople = Integer.parseInt(st.nextToken());
	        knowingPeoples[knowingPeople] = true;
	    }

	    for(int i = 0; i < numOfParty; i ++){
	    	
	    	partys[i] = new ArrayList<Integer>();
	    	
	    	st = new StringTokenizer(br.readLine());
	        int sumOfPartyPeople = Integer.parseInt(st.nextToken());
	        for(int j = 0; j < sumOfPartyPeople; j++){
	            int person = Integer.parseInt(st.nextToken());
	            partys[i].add(person);
	        }
	    }

	   System.out.println(solution());
	}
}
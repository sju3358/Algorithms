import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T;
	static Deque<Integer> dequeue;
	static String functions;
	static boolean RFlag = false;
	
	
	
	public static void init() {
		functions = "";
		RFlag = false;
	}
	
	
	public static void input() throws IOException{
		
		dequeue = new LinkedList<>();
		functions = br.readLine();
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(),"[,]");
		for(int i = 0; i <n; i++)
			dequeue.add(Integer.parseInt(st.nextToken()));
	}
	
	
	public static boolean executeFunctions() {
		
		for(int i = 0; i < functions.length(); i++) {
			if(functions.charAt(i) == 'R') 
				RFlag = !RFlag;
			else {
				if(dequeue.isEmpty() == true)
					return false;
				if(RFlag == true)
					dequeue.pollLast();
				else
					dequeue.pollFirst();
			}
		}
		
		return true;
	}
	
	public static void printOutput() {
		
		
		
		
		
		System.out.print("[");
		
		
	
		
		if(RFlag == false) {
			while(dequeue.size() > 1)
				System.out.print(dequeue.pollFirst() + ",");
		}
		else {
			while(dequeue.size() > 1)
				System.out.print(dequeue.pollLast() + ",");	
		}
		
		if(dequeue.size() > 0)
			System.out.print(dequeue.pollFirst());
		
		
		System.out.println("]");
	}
	
	
	public static void main(String args[]) throws IOException{
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			
			init();
			
			input();
			
			boolean flag = executeFunctions();
			
			if(flag == true)
				printOutput();
			else
				System.out.println("error");
			
		}
	}
}
import java.util.*;

public class Main {
    public static void main(String[] args){
        
    	int awards = 0;
    	int[] num = new int[3];
        
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i<3; i++) {
        	num[i] = sc.nextInt();
        }
        
        Arrays.sort(num);
        
        int cnt = 0;
        int sameNum = 0;
        
        for(int i = 0; i<2; i++) {
        	if(num[i] == num[i+1]) {
        		sameNum = num[i];
        		cnt++;
        	}
        }
        
        if(cnt == 2) {
        	awards = 10000 + num[0]*1000;
        }
        else if(cnt == 0) {
        	awards = num[2]*100;
        }
        else {
        	awards = 1000 + sameNum*100;
        }
        
        System.out.println(awards);
        sc.close();
    }
}

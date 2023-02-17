import java.util.Scanner;

public class Main {

	public static void main (String args[]){
		
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int kg_5;
        int kg_3 = 0;

        kg_5 = n/5;
        kg_3 = (n-kg_5*5)/3;
        
        while(true)
        {
            if(kg_5*5 + kg_3*3 == n)
            {
                System.out.println(kg_3+kg_5);
                break;
            }
            else
            {
                kg_5--;
                kg_3 = (n-kg_5*5) / 3;


                if(kg_5 == -1)
                {
                    System.out.println("-1");
                    break;
                }
            }
            
        }
    }

}
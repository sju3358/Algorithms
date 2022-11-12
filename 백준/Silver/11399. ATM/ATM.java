import java.util.*;
public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n,min = 0;
        n = sc.nextInt();
        int p[] = new int[n+1];
        for(int i = 1; i<=n; i++)
            p[i] = sc.nextInt();
        Arrays.sort(p);
        for(int i = 1; i<=n; i++)
        {
            p[i] = p[i - 1] + p[i];
            min += p[i];
        }
        System.out.println(min);
        sc.close();
    }
}
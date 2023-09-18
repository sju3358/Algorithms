import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {


    private int[][] map;
    public void setMapValue(int i, int j, int value){
        this.map[i][j] = Math.min(this.map[i][j],value);
    }
    public Main(int sizeOfMap){

        map = new int[sizeOfMap][sizeOfMap];

        for(int i = 0; i < sizeOfMap; i++)
            Arrays.fill(map[i], 5000001);
    }



    private boolean canComeBackWithTimeLoss(){

        int n = this.map.length;

        for(int k = 0; k < n; k++)
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);

        for(int i = 0; i < n; i++)
            if(map[i][i] < 0)
                return true;
        return false;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());

        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            int sizeOfMap = Integer.parseInt(st.nextToken());
            int countOfRoads = Integer.parseInt(st.nextToken());
            int countOfHoles = Integer.parseInt(st.nextToken());

            Main instance = new Main(sizeOfMap);

            for(int i = 0; i < countOfRoads; i++){

                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                int time = Integer.parseInt(st.nextToken());

                instance.setMapValue(from,to,time);
                instance.setMapValue(to,from,time);

            }

            for(int i = 0; i < countOfHoles; i++){

                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                int time = Integer.parseInt(st.nextToken()) * (-1);

                instance.setMapValue(from,to,time);
            }

            if(instance.canComeBackWithTimeLoss() == true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}